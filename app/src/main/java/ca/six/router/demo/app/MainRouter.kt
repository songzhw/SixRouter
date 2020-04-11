package ca.six.router.demo.app

import ca.six.router.library.IRouter
import ca.six.router.library.Station
import java.util.*

const val MAIN = "Main"
const val LOGIN = "Login"

class MainRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Station>) {
        map[MAIN] = Station(MAIN, MainActivity::class.java)
        map[LOGIN] = Station(LOGIN, LoginActivity::class.java)
    }
}