package ca.six.router.demo.mall.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.mall.R
import ca.six.router.library.Router
import kotlinx.android.synthetic.main.activity_tv_btn.*

class ItemDetailActivity : AppCompatActivity(R.layout.activity_tv_btn) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvInfo.text = "Item Details"
        btnAction.setOnClickListener {
            Router.nav(this, "Pay")
        }
    }
}