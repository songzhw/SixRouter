package ca.six.router.demo.payment.core

import ca.six.router.demo.common.core.user.UserSession
import ca.six.router.demo.payment.biz.GooglePayActivity
import ca.six.router.demo.payment.biz.NoPayMethodActivity
import ca.six.router.demo.payment.biz.PayActivity
import ca.six.router.library.IRouter
import ca.six.router.library.Precondition
import ca.six.router.library.RouteMeta
import java.util.*

const val NO_PAY = "NoPayMethod"
const val PAY = "Pay"
const val GOOGLE_PAY = "GOOGLE_PAY"

class PayRouter : IRouter {
    override fun registerRoute(map: HashMap<String, RouteMeta>) {
        map[NO_PAY] = RouteMeta(NO_PAY, NoPayMethodActivity::class.java)

        map[PAY] = RouteMeta(PAY, PayActivity::class.java)
            .addPrecondition(Precondition(UserSession::hasLoggedIn, "Login"))
            .addPrecondition(Precondition(UserSession::hasPaymentMethod, NO_PAY))

        map[GOOGLE_PAY] = RouteMeta(GOOGLE_PAY, GooglePayActivity::class.java)
    }

}