package cn.six.router1.biz.sessions

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import cn.six.router1.R
import cn.six.router1.core.BasePage
import cn.six.router1.core.router.ROUTE_LOGIN
import cn.six.router1.databinding.AfLauncherBinding
import cn.six.router1.views.fragments.FragmentType

class LauncherPage : BasePage() {
    private lateinit var vb: AfLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = AfLauncherBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnHome.setOnClickListener { router.open(FragmentType.HOME) }
        vb.btnLogin.setOnClickListener { router.open(ROUTE_LOGIN) }
    }
}