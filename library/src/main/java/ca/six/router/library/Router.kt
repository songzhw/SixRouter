package ca.six.router.library

import android.content.Context
import android.content.Intent
import java.util.*

interface IRouter {
    fun registerRoute(map: HashMap<String, Station>)
}


object Router {
    private val registry = hashMapOf<String, Station>()

    fun init() {
        val serviceLoader: ServiceLoader<IRouter> = ServiceLoader.load(IRouter::class.java)
        for (service in serviceLoader) {
            service.registerRoute(registry)
        }
    }

    fun nav(ctx: Context, destination: String) {
        val dest = registry.get(destination) ?: return
        var clazz = dest.clazz

        for (precondition in dest.preconditionList) {
            val isMeet = precondition.precondition()
            if (!isMeet) {
                val failStationName = precondition.failStationName
                val preconditionStation = registry.get(failStationName)
                    ?: throw RuntimeException("No such Station: $failStationName")
                clazz = preconditionStation.clazz
                break;
            }
        }

        val intent = Intent(ctx, clazz)
        ctx.startActivity(intent)
    }

    //  for enpower station. (专用于穿透跳转的)
    fun continueNav(context: Context) {
        //TODO
    }
}