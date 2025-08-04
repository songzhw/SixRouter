package ca.six.router.demo.app

import android.app.Application
import ca.six.router.library.Router

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Router.init()
    }
}