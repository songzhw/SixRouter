package ca.six.router.demo.payment.core

import ca.six.router.demo.common.biz.login.ThisUser
import ca.six.router.demo.payment.biz.NoPayMethodActivity
import ca.six.router.demo.payment.biz.PayActivity
import ca.six.router.library.IRouter
import ca.six.router.library.Precondition
import ca.six.router.library.Station
import java.util.*

const val NO_PAY = "NoPayMethod"
const val PAY = "Pay"

class PayRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Station>) {
        map[NO_PAY] = Station(NO_PAY, NoPayMethodActivity::class.java)

        map[PAY] = Station(PAY, PayActivity::class.java)
            .addPrecondition(Precondition(ThisUser::hasPaymentMethod, NO_PAY))
    }

}