package ca.six.router.demo.mall.core

import ca.six.router.demo.mall.biz.ItemDetailActivity
import ca.six.router.library.IRouter
import ca.six.router.library.Station
import java.util.*

const val ITEM_DETAIL = "ItemDetail"

class MallRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Station>) {
        map[ITEM_DETAIL] = Station(ITEM_DETAIL, ItemDetailActivity::class.java)
            .setEnpower("Login")
    }
}