package cn.six.router1.core.router

import android.os.Bundle
import androidx.core.os.bundleOf
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

enum class BottomSheetMeta(
    // which bottom sheet fragment should show
    val fragmentClass: Class<out BottomSheetDialogFragment>,
    // tag name is used in the `activity.replace(fragmentObj, fragmentTagName)`
    val fragmentTagName: String,
    // the data passed to the bottom sheet fragment
    val extraBundle: Bundle = bundleOf(),
    // should show this BottomSheet in the first place  (async call to FF endpoints is not considered here)
    val preconditionSync: () -> Boolean = { true }
) {

//    INSTANT_OFFER(BottomSheetInstantOfferFragment::class.java, "bottomSheet-instant-offer",
//            preconditionSync = { InstantOfferManager.shouldEnableInstantOfferSync() }),


}