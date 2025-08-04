package cn.six.router1.biz.detail.showcase

import android.os.Bundle
import cn.six.router1.core.BasePage
import cn.six.router1.databinding.AfShowcaseLandingBinding

class ShowcaseLandingPage: BasePage() {
    private lateinit var vb: AfShowcaseLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = AfShowcaseLandingBinding.inflate(layoutInflater)
        setContentView(vb.root)

    }
}