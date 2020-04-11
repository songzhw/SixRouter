package ca.six.router.demo.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tv_btn.*

class PayActivity : AppCompatActivity(R.layout.activity_tv_btn) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvInfo.text = "Choose the way you pay\n\n1. Paypal\n2. Debit Card\n3. Credit Card\n4. AliPay"
    }
}