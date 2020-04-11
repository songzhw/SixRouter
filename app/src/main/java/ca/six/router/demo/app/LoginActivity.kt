package ca.six.router.demo.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.common.biz.login.ThisUser
import ca.six.router.demo.common.biz.login.User
import ca.six.router.demo.mall.core.ITEM_DETAIL
import ca.six.router.library.Router
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnLogin.setOnClickListener {
            val name = etLoginName.text.toString()
            ThisUser.setUser(User(name))

            // TODO temporarily
            Router.nav(this, ITEM_DETAIL)
        }
    }


}