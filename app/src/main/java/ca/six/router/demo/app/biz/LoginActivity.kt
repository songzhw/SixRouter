package ca.six.router.demo.app.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.app.R
import ca.six.router.demo.common.biz.login.ThisUser
import ca.six.router.demo.common.biz.login.User
import ca.six.router.library.Router
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnLogin.setOnClickListener {
            val name = etLoginName.text.toString()
            ThisUser.setUser(User(name))

            Router.continueNav(this)
            this.finish()
        }
    }


}