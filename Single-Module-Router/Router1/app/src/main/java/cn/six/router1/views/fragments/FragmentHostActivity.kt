package cn.six.router1.views.fragments

import android.os.Bundle
import androidx.core.os.bundleOf
import cn.six.router1.R
import cn.six.router1.core.BasePage
import cn.six.router1.databinding.LayoutNavBinding
import cn.six.router1.ext_utils.replace

class FragmentHostActivity : BasePage() {
    private lateinit var vb: LayoutNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = LayoutNavBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val path = intent.extras?.getSerializable("FRAGMENT_CANONICAL_PATH)")
        if (path != null && path is FragmentType) {
            intent.removeExtra("FRAGMENT_CANONICAL_PATH")
            val targetFragment = path.classType.newInstance()
            targetFragment?.arguments = intent.extras
            this.replace(targetFragment, R.id.content, false)
        }
    }
}