package cn.six.router1.views.bottomsheet

import android.os.Build
import cn.six.router1.core.router.Router
import cn.six.router1.core.router.Signpost
import cn.six.router1.ext_utils.dpToPx
import cn.six.router1.ext_utils.getScreenHeight
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

// v1: When we open a BottomSheetDialogFragment, the sheet will only be a `half_expand` status
// to make it `full_expand`, we have to customize BottomSheetDialogFragment by adding logic to its `onStart`
// v2: the above logic is moved to the `CustomBottomSheetFragment` class.
open class BaseBottomSheetFragment(layoutResId: Int) : CustomBottomSheetFragment() {
    val router: Router by inject()
    var previousFragmentName = "" // a saved route for SignPost
    val disposables = CompositeDisposable()
    val isAndroid15OrAbove = Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }


    override fun onResume() {
        super.onResume()
        previousFragmentName = Signpost.currentFragment
        Signpost.currentFragment = this.javaClass.simpleName
    }

    // when the bottomSheetFragment is closed, we need the BottomSheetHostActivity to be closed too
    // otherwise, the BottomSheetHostActivity will absorb every click/touch event of our app
    override fun onDestroy() {
        super.onDestroy()
        Signpost.currentFragment = previousFragmentName

        // if this is open by deeplink when our app is closed, then we need to go back to the offerlist once it's done
//        val isHomePage = this.activity is FragmentHostActivity
//        val isSplashPage = this.activity is LauncherActivity
//        val isLoginPage = this.activity is LoginActivity
//        val isNotEntrancePage = !isHomePage && !isSplashPage && !isLoginPage
//        val isTaskRoot = this.activity?.isTaskRoot ?: false
//        val isDeeplinkDestinationShowing = isTaskRoot && isNotEntrancePage
//        if (isDeeplinkDestinationShowing) {
//            router.open(FragmentType.OFFER_LIST, context = this.activity)
//        }

        // To avoid the BottomSheetHostActivity absorb all the clicking/touching event, we have to finish the activity too
        if (this.activity is BottomSheetHostActivity) {
            this.activity?.finish()
        }
    }

    protected fun calculateFullScreenBsHeight(): Int {
        val topOffset = when {
            isAndroid15OrAbove -> 72.dpToPx()
            else -> 16.dpToPx() // Covering AND14- Devices (Default Setup)
        }
        return getScreenHeight() - topOffset
    }

}