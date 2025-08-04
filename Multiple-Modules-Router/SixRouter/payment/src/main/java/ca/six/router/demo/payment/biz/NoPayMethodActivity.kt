package ca.six.router.demo.payment.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.payment.R
import ca.six.router.demo.payment.databinding.ActivityPayTvBtnBinding

class NoPayMethodActivity : AppCompatActivity() {
    private lateinit var vb: ActivityPayTvBtnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityPayTvBtnBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.tvInfo.text = "You have not add payment method yet"
        vb.btnAction.text = "Go add one payment method (not implemented yet)"
    }
}