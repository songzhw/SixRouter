package ca.six.router.demo.payment.biz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.payment.databinding.ActivityPayTvBtnBinding

class GooglePayActivity : AppCompatActivity() {
    private lateinit var vb: ActivityPayTvBtnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityPayTvBtnBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val userId = intent.getIntExtra("userId", 0)

        vb.tvInfo.text = "bind to Google Play?"
        vb.btnAction.setOnClickListener {
            val itt = Intent()
            itt.putExtra("isBind", userId + 20)
            setResult(RESULT_OK, itt)
            this.finish()
        }
    }
}