package ca.six.router.demo.mall

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tv_btn.*

class ItemDetailActivity : AppCompatActivity(R.layout.activity_tv_btn) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvInfo.text = "Item Details"
        btnAction.setOnClickListener {
            // startActivity(Intent(this, PayActivity::class.java)) // don't know PayActivity
        }
    }
}