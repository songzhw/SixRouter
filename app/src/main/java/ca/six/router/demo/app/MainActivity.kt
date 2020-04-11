package ca.six.router.demo.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.mall.core.ITEM_DETAIL
import ca.six.router.library.Router
import kotlinx.android.synthetic.main.activity_tv_btn.*

class MainActivity : AppCompatActivity(R.layout.activity_tv_btn) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvInfo.text = "Mall Online"
        btnAction.setOnClickListener {
            Router.nav(this, ITEM_DETAIL)
        }
    }
}
