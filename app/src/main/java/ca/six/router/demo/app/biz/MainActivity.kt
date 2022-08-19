package ca.six.router.demo.app.biz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import ca.six.router.demo.app.R
import ca.six.router.demo.app.TOURIST
import ca.six.router.demo.common.core.user.User
import ca.six.router.demo.common.core.user.UserSession
import ca.six.router.demo.mall.core.MALL_LIST
import ca.six.router.demo.payment.core.GOOGLE_PAY
import ca.six.router.demo.payment.core.PAY
import ca.six.router.library.Router
import kotlinx.android.synthetic.main.activity_tv_btn.*

class MainActivity : AppCompatActivity(R.layout.activity_tv_btn) {

    private var isLogin = false;
    private var hasPay = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = Bundle()
        args.putString("name", "pet - cat")
        args.putString("desp", "tourist")

        tvInfo.text = "Mall Online"
        btnAction.setOnClickListener {
            Router.open(this, MALL_LIST, args)
        }
        btnTourist.setOnClickListener {
            val flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            Router.open(this, TOURIST, args, flags)
        }
        btnPay.setOnClickListener {
            Router.open(this, PAY)
        }
        btnGp.setOnClickListener {
            val data = bundleOf("userId" to 3)
            Router.openForResult(this, GOOGLE_PAY, args = data) {
                println("szw onCallback : ${it.data}")
            }
        }

        cbLogin.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                val methods = if(hasPay) arrayListOf("Paypal") else null
                UserSession.setUser(User("one", true, methods))
                println("szw checked1: ${UserSession.hasLoggedIn()}")
            } else {
                UserSession.setUser(null)
                println("szw unchecked1: ${UserSession.hasLoggedIn()}")
            }
            isLogin = isChecked
        }

        cbMethods.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                UserSession.setPayMethods("credit card")
            } else {
                UserSession.setPayMethods(null)
            }
            hasPay = isChecked
            println("szw check2($isChecked) : ${UserSession.hasPaymentMethod()}")
        }
    }
}
