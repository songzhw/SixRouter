package ca.six.router.demo.app.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.app.R
import ca.six.router.demo.app.databinding.ActivityLoginBinding
import ca.six.router.demo.common.core.user.User
import ca.six.router.demo.common.core.user.UserSession
import ca.six.router.library.Router

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    private lateinit var vb: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnLogin.setOnClickListener {
            UserSession.setUser(User("songzhw", false))

            Router.continueNav(this)
            this.finish()
        }
    }


}