package ca.six.router.demo.payment.biz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.payment.R
import kotlinx.android.synthetic.main.activity_pay_tv_btn.*

class GooglePayActivity : AppCompatActivity(R.layout.activity_pay_tv_btn) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userId = intent.getIntExtra("userId", 0)

        tvInfo.text = "bind to Google Play?"
        btnAction.setOnClickListener {
            val itt = Intent()
            itt.putExtra("isBind", userId % 2 == 0)
            setResult(RESULT_OK, itt)
        }
    }
}