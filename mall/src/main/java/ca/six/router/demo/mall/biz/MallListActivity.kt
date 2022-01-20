package ca.six.router.demo.mall.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.common.ext.extra_
import ca.six.router.demo.mall.R
import ca.six.router.library.Router
import kotlinx.android.synthetic.main.activity_mall_tv_btn.*

class MallListActivity : AppCompatActivity(R.layout.activity_mall_tv_btn) {
    val name by extra_("name", "<empty name>")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvInfo.text = name
        btnAction.text = "Pay"
        btnAction.setOnClickListener {
            Router.nav(this, "Pay")
        }
    }
}