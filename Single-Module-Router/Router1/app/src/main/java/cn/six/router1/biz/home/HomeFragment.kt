package cn.six.router1.biz.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.six.router1.core.BaseFragment
import cn.six.router1.core.router.ROUTE_MY_ACCOUNT
import cn.six.router1.databinding.AfHomeBinding
import cn.six.router1.ext_utils.config
import cn.six.router1.views.fragments.FragmentMeta

class HomeFragment: BaseFragment() {
    private var vb: AfHomeBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {vb = AfHomeBinding.inflate(inflater); return vb?.root;  }
    override fun onDestroyView() { vb = null; super.onDestroyView(); }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vb?.btn9?.config("redeem") { router.open(FragmentMeta.REDEEM) }
        vb?.btn3?.config("my account") {router.open(ROUTE_MY_ACCOUNT)}
    }
}