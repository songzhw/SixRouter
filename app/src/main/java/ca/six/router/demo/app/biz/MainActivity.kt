package ca.six.router.demo.app.biz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.router.demo.app.R
import ca.six.router.demo.app.TOURIST
import ca.six.router.demo.mall.core.ITEM_DETAIL
import ca.six.router.library.Router
import kotlinx.android.synthetic.main.activity_tv_btn.*

class MainActivity : AppCompatActivity(R.layout.activity_tv_btn) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = Bundle()
        args.putString("name", "pet - cat")
        args.putString("desp", "tourist")

        tvInfo.text = "Mall Online"
        btnAction.setOnClickListener {
            Router.nav(this, ITEM_DETAIL, args)
        }
        btnTourist.setOnClickListener {
            val flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            Router.nav(this, TOURIST, args, flags)
        }
    }
}
