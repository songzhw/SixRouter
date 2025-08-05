package cn.six.router1.biz.sessions

import android.os.Bundle
import cn.six.router1.core.BasePage
import cn.six.router1.core.router.ROUTE_LOGIN
import cn.six.router1.databinding.AfLauncherBinding
import cn.six.router1.views.fragments.FragmentMeta

class LauncherPage : BasePage() {
    private lateinit var vb: AfLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = AfLauncherBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnHome.setOnClickListener { router.open(FragmentMeta.HOME) }
        vb.btnLogin.setOnClickListener { router.open(ROUTE_LOGIN) }
    }
}