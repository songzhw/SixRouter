package ca.six.router.demo.app.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.app.R
import ca.six.router.demo.common.ext.extra_
import kotlinx.android.synthetic.main.activity_tv_btn.*

class TouristActivity : AppCompatActivity(R.layout.activity_tv_btn) {
    val name by extra_("desp", "<empty name>")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvInfo.text = name
    }
}
