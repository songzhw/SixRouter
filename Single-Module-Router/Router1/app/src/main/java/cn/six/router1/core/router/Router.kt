package cn.six.router1.core.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.six.router1.core.MyApp
import cn.six.router1.views.fragments.FragmentType

class Router {
    private val registry = hashMapOf<String, RouteMeta>()

    fun init() {
        val subRoutes = AppSubRoute()
        subRoutes.registerSubRoute(registry)
    }

    fun open(
        targetId: String, args: Bundle? = null, context: Context? = MyApp.app(), intentFlag: Int = -1
    ) {
        val destination = registry[targetId]
        if(destination == null) throw RuntimeException("no such route : $targetId")

        val intent = Intent(context, destination.clazz)

        var flag = intentFlag
        if (context !is Activity) {
            flag = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        if (flag > 0) {
            intent.addFlags(flag)
        }

        if (args != null) {
            intent.putExtras(args)
        }

        context?.startActivity(intent)
    }

    fun open(
        fragment: FragmentType, args: Bundle? = null, context: Context? = MyApp.app(), intentFlag: Int = -1
    ) {

    }
}