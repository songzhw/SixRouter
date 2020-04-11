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

        // check precondition
        if (dest.precondition != null && !dest.precondition!!()) {
            val failDestination = registry.get(dest.target)
            clazz = failDestination?.clazz ?: dest.clazz
        }

        val intent = Intent(ctx, clazz)
        ctx.startActivity(intent)
    }
}