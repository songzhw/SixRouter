package cn.six.router1.biz.sessions

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import cn.six.router1.R
import cn.six.router1.core.BasePage
import cn.six.router1.databinding.AfLauncherBinding

class LauncherPage : BasePage() {
    private lateinit var vb: AfLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = AfLauncherBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnHome.setOnClickListener {  }
        vb.btnLogin.setOnClickListener {  }

    }
}