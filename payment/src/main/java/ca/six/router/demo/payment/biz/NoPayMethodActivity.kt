package ca.six.router.demo.payment.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.payment.R
import kotlinx.android.synthetic.main.activity_tv_btn.*

class NoPayMethodActivity : AppCompatActivity(R.layout.activity_tv_btn) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvInfo.text = "You have not add payment method yet"
        btnAction.text = "Go add one payment method"
    }
}