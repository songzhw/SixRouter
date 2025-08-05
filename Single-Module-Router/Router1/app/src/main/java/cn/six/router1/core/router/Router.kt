package cn.six.router1.core.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.six.router1.core.MyApp
import cn.six.router1.views.fragments.FragmentHostActivity
import cn.six.router1.views.fragments.FragmentMeta

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
        configIntent(intent)
        context?.startActivity(intent)
    }

    // 这里说是fragment, 其实是为了兼容app中早就存在的fragment
    // 现在也一律使用"一个Activity搭配一个Fragment"的架构, 统一起来
    fun open(
        fragment: FragmentMeta, args: Bundle? = null, context: Context? = MyApp.app(), intentFlag: Int = -1
    ) {
        val intent = Intent(context, FragmentHostActivity::class.java)
        intent.putExtra("FRAGMENT_CANONICAL_PATH", fragment)
        configIntent(intent)
        context?.startActivity(intent)
    }



    // = = = = = = = = = private methods = = = = = = = = =
    private fun configIntent(intent: Intent, args: Bundle? = null, context: Context? = MyApp.app(), intentFlag: Int = -1) {
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
    }
}