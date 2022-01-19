package ca.six.router.demo.mall.core

import ca.six.router.demo.common.biz.login.ThisUser
import ca.six.router.demo.mall.biz.ItemDetailActivity
import ca.six.router.library.IRouter
import ca.six.router.library.Precondition
import ca.six.router.library.RouteMeta
import java.util.*

const val ITEM_DETAIL = "ItemDetail"

class MallRouter : IRouter {
    override fun registerRoute(map: HashMap<String, RouteMeta>) {
        map[ITEM_DETAIL] = RouteMeta(ITEM_DETAIL, ItemDetailActivity::class.java)
            .addPrecondition(Precondition(ThisUser::hasLoggedIn, "Login"))
    }
}