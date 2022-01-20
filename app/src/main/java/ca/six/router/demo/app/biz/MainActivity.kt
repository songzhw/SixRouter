package ca.six.router.demo.app.biz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.app.R
import ca.six.router.demo.app.TOURIST
import ca.six.router.demo.common.core.user.User
import ca.six.router.demo.common.core.user.UserSession
import ca.six.router.demo.mall.core.MALL_LIST
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
            Router.nav(this, MALL_LIST, args)
        }
        btnTourist.setOnClickListener {
            val flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            Router.nav(this, TOURIST, args, flags)
        }
        btnPay.setOnClickListener {
            Router.nav(this, PAY)
        }

        cbLogin.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                val methods = if(hasPay) arrayListOf("Paypal") else null
                UserSession.setUser(User("one", true, methods))
            } else {
                UserSession.setUser(null)
            }
            isLogin = isChecked
        }

        cbLogin.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                UserSession.setPayMethods("credit card")
            } else {
                UserSession.setPayMethods(null)
            }
            hasPay = isChecked
        }
    }
}
