package ca.six.router.demo.payment.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.payment.R
import kotlinx.android.synthetic.main.activity_pay_tv_btn.*

class PayActivity : AppCompatActivity(R.layout.activity_pay_tv_btn) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvInfo.text = "Choose the way you pay\n\n1. Paypal\n2. Debit Card\n3. Credit Card\n4. AliPay"
        btnAction.text = "(not implemented yet)"
    }
}