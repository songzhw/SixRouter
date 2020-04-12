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

    fun nav(ctx: Context, destination: String) {
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

                isAllMeet = false;

                break;
            }
        }

        if (isAllMeet) {
            cachedStation = null
        }

        val intent = Intent(ctx, clazz)
        // TODO what if there is no piercing router, jsut a normal nav(no cachedArgs?)?
        if (cachedArgs != null) {
            intent.putExtras(cachedArgs!!)
            cachedArgs = null
        }
        if (cachedIntentFlag != -1) {
            intent.addFlags(cachedIntentFlag)
            cachedIntentFlag = -1
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