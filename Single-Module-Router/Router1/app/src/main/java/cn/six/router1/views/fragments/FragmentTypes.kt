package cn.six.router1.views.fragments

import androidx.fragment.app.Fragment
import cn.six.router1.biz.detail.oldd.LegacyDetailFragment
import cn.six.router1.biz.home.HomeFragment
import cn.six.router1.biz.home.RedeemFragment

enum class FragmentType(
    name: String = "",
    val classType: Class<out Fragment?>
) {
    HOME("HOME", HomeFragment::class.java),
    REDEEM("REDEEM", RedeemFragment::class.java),
    OLD_DETAIL("OLD_DETAIL", LegacyDetailFragment::class.java)
    ;
}
