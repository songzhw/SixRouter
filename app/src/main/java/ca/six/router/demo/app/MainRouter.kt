package ca.six.router.demo.app

import ca.six.router.demo.app.biz.LoginActivity
import ca.six.router.demo.app.biz.MainActivity
import ca.six.router.demo.app.biz.TouristActivity
import ca.six.router.library.IRouter
import ca.six.router.library.Station
import java.util.*

const val MAIN = "Main"
const val LOGIN = "Login"
const val TOURIST = "Tourist"

class MainRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Station>) {
        map[MAIN] = Station(MAIN, MainActivity::class.java)
        map[LOGIN] = Station(LOGIN, LoginActivity::class.java)
        map[TOURIST] = Station(TOURIST, TouristActivity::class.java)
    }
}