package ca.six.router.library

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import java.util.*

interface IRouter {
    fun registerRoute(map: HashMap<String, Station>)
}


object Router {
    private val registry = hashMapOf<String, Station>()
    private var cacheDestination: Station? = null

    fun init() {
        val serviceLoader: ServiceLoader<IRouter> = ServiceLoader.load(IRouter::class.java)
        for (service in serviceLoader) {
            service.registerRoute(registry)
        }
    }

    fun nav(ctx: Context, destination: String) {
        val dest = registry.get(destination) ?: return
        var clazz = dest.clazz

        // check enpower
        val enpower = dest.getEnpower()
        if (!TextUtils.isEmpty(enpower)) {
            val enpowerStation = registry.get(enpower)
            clazz = enpowerStation?.clazz ?: dest.clazz

            dest.setEnpower("")
            cacheDestination = dest
        }

        // check precondition
        if (dest.precondition != null && !dest.precondition!!()) {
            val failDestination = registry.get(dest.target)
            clazz = failDestination?.clazz ?: dest.clazz
        }

        val intent = Intent(ctx, clazz)
        ctx.startActivity(intent)
    }

    //  for enpower station. (专用于穿透跳转的)
    fun continueNav(context: Context) {
        if (cacheDestination != null) {
            nav(context, cacheDestination!!.target)
            cacheDestination = null
        }
    }
}