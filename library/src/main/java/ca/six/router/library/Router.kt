package ca.six.router.library

import android.content.Context
import android.content.Intent
import android.os.Bundle
import java.util.*

interface IRouter {
    fun registerRoute(map: HashMap<String, Station>)
}


object Router {
    private val registry = hashMapOf<String, Station>()

    private var cachedStation: Station? = null
    private var cachedArgs: Bundle? = null
    private var cachedIntentFlag = -1

    fun init() {
        val serviceLoader: ServiceLoader<IRouter> = ServiceLoader.load(IRouter::class.java)
        for (service in serviceLoader) {
            service.registerRoute(registry)
        }
    }

    fun nav(ctx: Context, destination: String, args: Bundle? = null, flag: Int = -1) {
        val dest = registry.get(destination) ?: return
        var clazz = dest.clazz

        var isAllMeet = true
        for (precondition in dest.preconditionList) {
            val isMeet = precondition.precondition()
            if (!isMeet) {

                val failStationName = precondition.failStationName
                val preconditionStation = registry.get(failStationName)
                    ?: throw RuntimeException("No such Station: $failStationName")
                clazz = preconditionStation.clazz

                // cache this station, bundle, and intent flag
                cachedStation = dest
                cachedArgs = args
                cachedIntentFlag = flag

                isAllMeet = false;

                break;
            }
        }

        if (isAllMeet) {
            cachedStation = null
        }

        val intent = Intent(ctx, clazz)
        // piercing navigation就会有cachedArgs不为空
        if (cachedArgs != null) {
            intent.putExtras(cachedArgs!!)
            cachedArgs = null
        }
        // 正常跳转时没有cachedArgs, 就使用args
        if (args != null) {
            intent.putExtras(args)
        }
        if (cachedIntentFlag > 0) {
            intent.addFlags(cachedIntentFlag)
            cachedIntentFlag = -1
        }
        if (flag > 0) {
            intent.addFlags(flag)
        }

        ctx.startActivity(intent)
    }

    //  for enpower station. (专用于穿透跳转的)
    fun continueNav(context: Context) {
        if (cachedStation != null) {
            nav(context, cachedStation!!.target)
        } else {
            throw RuntimeException("There is no cached station in the router")
        }
    }
}