package ca.six.router.demo.app.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.app.MAIN
import ca.six.router.demo.common.ext.extra_
import ca.six.router.library.Router

/*
 Notification needs a Intent (to be precise, a PendingIntent actually)
 , which is not compatible with our Router library.

 A workaround would be using this HubActivity.
 Every notification's PendingIntent would go straight to the HubActivity
 HubActivity would dispatch all different request

 Advantage:
 1). so we could reuse our Router
 2). by adding a middleware activity, we finally could add INTENT FLAG to notification intent
 */
class DeepLinkActivity : AppCompatActivity() {
    val destination by extra_("router", MAIN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Router.open(this, destination)
        this.finish()
    }

}