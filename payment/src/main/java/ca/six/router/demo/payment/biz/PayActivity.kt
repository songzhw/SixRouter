package ca.six.router.demo.payment.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.payment.R
import ca.six.router.demo.payment.databinding.ActivityPayTvBtnBinding

class PayActivity : AppCompatActivity(R.layout.activity_pay_tv_btn) {
    private lateinit var vb: ActivityPayTvBtnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityPayTvBtnBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.tvInfo.text = "Choose the way you pay\n\n1. Paypal\n2. Debit Card\n3. Credit Card\n4. AliPay"
        vb.btnAction.text = "(not implemented yet)"
    }
}