package ca.six.router.demo.payment

import android.app.Activity
import ca.six.router.library.IRouter
import java.util.*

class PayRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Class<out Activity>>) {
        map["Pay"] = PayActivity::class.java
    }

}