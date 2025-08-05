package cn.six.router1.core.router

import cn.six.router1.biz.account.MyAccountPage
import cn.six.router1.biz.detail.showcase.ShowcaseLandingPage
import cn.six.router1.biz.sessions.LauncherPage
import cn.six.router1.biz.sessions.LoginPage


class AppSubRoute : ISubRoute {
    override fun registerSubRoute(map: HashMap<String, RouteMeta>) {
        map[ROUTE_LAUNCHER] = RouteMeta(ROUTE_LAUNCHER, LauncherPage::class.java)
        map[ROUTE_LOGIN] = RouteMeta(ROUTE_LOGIN, LoginPage::class.java)
        map[ROUTE_MY_ACCOUNT] = RouteMeta(ROUTE_MY_ACCOUNT, MyAccountPage::class.java)
        map[ROUTE_SHOWCASE_LANDING] = RouteMeta(ROUTE_SHOWCASE_LANDING, ShowcaseLandingPage::class.java)
    }
}

const val ROUTE_LAUNCHER = "launcher"
const val ROUTE_LOGIN = "login"
const val ROUTE_MY_ACCOUNT = "account"
const val ROUTE_SHOWCASE_LANDING = "showcase"
