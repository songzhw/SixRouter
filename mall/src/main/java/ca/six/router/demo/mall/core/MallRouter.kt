package ca.six.router.demo.mall.core

import ca.six.router.demo.common.core.user.UserSession
import ca.six.router.demo.mall.biz.MallListActivity
import ca.six.router.library.IRouter
import ca.six.router.library.Precondition
import ca.six.router.library.RouteMeta
import java.util.*

const val MALL_LIST = "MallList"

class MallRouter : IRouter {
    override fun registerRoute(map: HashMap<String, RouteMeta>) {
        map[MALL_LIST] = RouteMeta(MALL_LIST, MallListActivity::class.java)
            .addPrecondition(Precondition(UserSession::hasLoggedIn, "Login"))
    }
}