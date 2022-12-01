package ca.six.router.library

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.util.*

interface IRouter {
    fun registerRoute(map: HashMap<String, RouteMeta>)
}


object Router {
    private val registry = hashMapOf<String, RouteMeta>()

    private var cachedMeta: RouteMeta? = null
    private var cachedArgs: Bundle? = null
    private var cachedIntentFlag = -1

    fun init() {
        val serviceLoader: ServiceLoader<IRouter> = ServiceLoader.load(IRouter::class.java)
        for (service in serviceLoader) {
            service.registerRoute(registry)
        }
    }

    fun open(ctx: Context, destination: String, args: Bundle? = null, flag: Int = -1) {
        val intent = getIntent(ctx, destination, args, flag) ?: return
        ctx.startActivity(intent)
    }

    private fun getIntent(ctx: Context, destination: String, args: Bundle? = null, flag: Int = -1): Intent?{
        val dest = registry.get(destination) ?: return null
        var clazz = dest.clazz

        var isAllMeet = true
        for (precondition in dest.preconditionList) {
            val isMeet = precondition.precondition()
            println("szw precondition = $isMeet (${precondition.precondition})")
            if (!isMeet) {

                val failStationName = precondition.destinationOnFail
                val preconditionStation = registry.get(failStationName)
                if (preconditionStation == null) {
                    println("szw error: No such activity for this route(failStationName) : $failStationName")
                    return null
                }
                clazz = preconditionStation.clazz

                // cache this station, bundle, and intent flag
                cachedMeta = dest
                cachedArgs = args
                cachedIntentFlag = flag

                isAllMeet = false;

                break;
            }
        }

        val intent = Intent(ctx, clazz)
        if (isAllMeet) {
            cachedMeta = null

            if (cachedArgs != null) {
                intent.putExtras(cachedArgs!!)
                cachedArgs = null
            }
            if (cachedIntentFlag > 0) {
                intent.addFlags(cachedIntentFlag)
                cachedIntentFlag = -1
            }

            // 正常跳转时没有cachedArgs, 就使用args
            if (args != null) {
                intent.putExtras(args)
            }
            if (flag > 0) {
                intent.addFlags(flag)
            }
        }
        return intent
    }

    fun openIfOnline(ctx: Context, destination: String, args: Bundle? = null, flag: Int = -1) {
        /*
        if(online(ctx){
            open(ctx, destination, args, flags)
        } else {
            showNoInternetDialog()
        }
         */
    }

    // 专用于穿透跳转的
    fun continueNav(context: Context) {
        if (cachedMeta != null) {
            open(context, cachedMeta!!.target)
        } else {
            throw RuntimeException("There is no cached station in the router")
        }
    }

    // = = = = = = = = = = Activity Result = = = = = = = = = =

    fun openForResult(ctx: Context, destination: String, args: Bundle? = null, flag: Int = -1, activityResultLauncher: ActivityResultLauncher<Intent>) {
        val intent = getIntent(ctx, destination, args, flag) ?: return
        activityResultLauncher.launch(intent)
    }
}
/*
不使用lambda, 即`openForResult(..., result: Lambda)`, 而要用ActivityResultLauncher的原因:

是用lambda就会有crash:
```kotlin
java.lang.IllegalStateException:
  LifecycleOwner MainActivity is attempting to register
  while current state is RESUMED.
  LifecycleOwners must call register before they are STARTED.
```

 */