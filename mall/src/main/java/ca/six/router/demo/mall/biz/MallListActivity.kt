package ca.six.router.demo.mall.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.common.ext.extra_
import ca.six.router.demo.mall.R
import ca.six.router.demo.mall.databinding.ActivityMallTvBtnBinding
import ca.six.router.library.Router

class MallListActivity : AppCompatActivity() {
    val name by extra_("name", "<empty name>")
    private lateinit var vb: ActivityMallTvBtnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMallTvBtnBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.tvInfo.text = name
        vb.btnAction.text = "Pay"
        vb.btnAction.setOnClickListener {
            Router.open(this, "Pay")
        }
    }
}