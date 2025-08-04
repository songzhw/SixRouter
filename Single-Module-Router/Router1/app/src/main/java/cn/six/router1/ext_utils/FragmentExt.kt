package cn.six.router1.ext_utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

// isRecord: 做为第一个Fragment一般为false, 其它情况得是true才对
fun FragmentActivity.replace(target: Fragment, container: Int, isRecord: Boolean = true) {
    val transaction = this.supportFragmentManager.beginTransaction()
    if (isRecord) {
        val currentFragment = getCurrentFragment(container)
        transaction.addToBackStack("${currentFragment?.javaClass?.simpleName} -> ${target.javaClass.simpleName}")
    }
    transaction.replace(container, target)
    transaction.commitAllowingStateLoss()
}

fun FragmentActivity.getCurrentFragment(container: Int): Fragment? {
    return this.supportFragmentManager.findFragmentById(container)
}