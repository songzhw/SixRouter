package ca.six.router.library

import android.app.Activity
import android.content.Context
import android.content.Intent
import java.util.*

interface IRouter {
    fun registerRoute(map: HashMap<String, Class<out Activity>>)
}


object Router {
    private val registry = hashMapOf<String, Class<out Activity>>()

    fun init() {
        val serviceLoader: ServiceLoader<IRouter> = ServiceLoader.load(IRouter::class.java)
        for (service in serviceLoader) {
            service.registerRoute(registry)
        }
    }

    fun nav(ctx: Context, destination: String) {
        val destActivity = registry.get(destination)
        val intent = Intent(ctx, destActivity)
        ctx.startActivity(intent)
    }
}