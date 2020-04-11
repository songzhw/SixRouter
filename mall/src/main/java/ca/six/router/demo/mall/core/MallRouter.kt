package ca.six.router.demo.mall.core

import android.app.Activity
import ca.six.router.demo.mall.biz.ItemDetailActivity
import ca.six.router.library.IRouter
import java.util.*

class MallRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Class<out Activity>>) {
        map["ItemDetail"] = ItemDetailActivity::class.java
    }
}