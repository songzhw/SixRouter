package cn.six.router1.views.bottomsheet

import android.os.Bundle
import android.view.MotionEvent
import androidx.core.os.bundleOf
import cn.six.router1.biz.AppConstants
import cn.six.router1.core.BasePage
import cn.six.router1.core.router.BottomSheetMeta

class BottomSheetHostActivity : BasePage() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // intent.getSerializableExtra(key, BottomSheetMeta::class.java) requires Api 33
        val destination = intent.getSerializableExtra(AppConstants.BOTTOM_SHEET_PAGE) as? BottomSheetMeta
        if (destination != null) {
            val shouldShowBottomSheet = destination.preconditionSync() //TODO要修改这里
            if (!shouldShowBottomSheet) {
                this.finish()
                return
            }

            val sheet = destination.fragmentClass.newInstance()

            val args = bundleOf()
            args.putAll(destination.extraBundle)
            args.putAll(intent.extras)
            val deeplink = intent.getStringExtra(AppConstants.DEEPLINK)
            if (deeplink != null) {
                args.putString(AppConstants.DEEPLINK, deeplink)
            }
            sheet.arguments = args // add extraBundle (url in it), and deeplink to it

            sheet.show(this.supportFragmentManager, destination.fragmentTagName)
        } else {
            this.finish()
        }

    }

    // detail 1. this activity is transparent, and it should be finished if it accidentally stays
    // detail 2. the logic here, instead of onDispatchTouchEvent, so the children can have a chance to intercept it
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            finish()
        }
        return super.onTouchEvent(event)
    }

    /*
    TODO
    now the deeplink of pcoptimum has two types:
  * c51://pcoptimun : open the pc optimun page
  * c51//pcoptimum?offerlist=true : open the pc optimun page and will go back to offerlist page
     */
//    override fun onDestroy() {
//        super.onDestroy()
//        val deeplink = intent.getStringExtra(AppConstants.DEEPLINK) ?: return
//        val url = Uri.parse(deeplink)
//        val isBackToHome = "true" == url.getQueryParameter("offerlist")
//        //println("szww BottomSheetHostActivity onDestroy : $isBackToHome")
//        if(isBackToHome) {
//            router.open(FragmentType.OFFER_LIST, bundleOf(AppConstants.IS_TO_CLEAR_AND_NEW_TASK to true))
//        }
//    }
}