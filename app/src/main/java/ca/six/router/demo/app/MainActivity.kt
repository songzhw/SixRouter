package ca.six.router.demo.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.six.router.demo.mall.ItemDetailActivity
import kotlinx.android.synthetic.main.activity_tv_btn.*

class MainActivity : AppCompatActivity(R.layout.activity_tv_btn) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnAction.setOnClickListener {
            startActivity(Intent(this, ItemDetailActivity::class.java))
        }
    }
}
