package cn.six.router1.biz.detail.oldd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.six.router1.core.BaseFragment
import cn.six.router1.databinding.AfOldDetailBinding

class LegacyDetailFragment: BaseFragment() {
    private var vb: AfOldDetailBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {vb = AfOldDetailBinding.inflate(inflater); return vb?.root;  }
    override fun onDestroyView() { vb = null; super.onDestroyView(); }

}