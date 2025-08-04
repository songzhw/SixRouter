package ca.six.router.demo.app.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.app.R
import ca.six.router.demo.common.ext.extra_
import ca.six.router.demo.payment.databinding.ActivityPayTvBtnBinding

class TouristActivity : AppCompatActivity() {
    private lateinit var vb: ActivityPayTvBtnBinding
    val name by extra_("desp", "<empty name>")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityPayTvBtnBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.tvInfo.text = name
    }
}
