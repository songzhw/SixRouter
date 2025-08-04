package cn.six.router1.views.bottomsheet

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.annotation.*
import androidx.annotation.IntRange
import androidx.core.view.updateLayoutParams
import cn.six.router1.R
import cn.six.router1.ext_utils.dpToPx
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class CustomBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var viewOutside: View
    private lateinit var flayRoundCorner: RoundCornerFrameLayout
    lateinit var bsBehavior: BottomSheetBehavior<View>

    private var roundCornerRadius = 0f
    private var isAlwaysExpand = false
    private var isCancelOnOutside = true
    private var isSheetCancelable = true

    // = = = = = = = = = = public method = = = = = = = = = =
    open fun isSheetCancelableOnTouchOutside() = true
    open fun isSheetCancelable() = true

    @IntRange(from = WRAP_CONTENT.toLong(), to = MATCH_PARENT.toLong())
    open fun getExpandedHeight() = MATCH_PARENT
    open fun isSheetAlwaysExpanded() = true
    open fun getPeekHeight() = resources.displayMetrics.heightPixels * 7 / 16

    @ColorInt open fun getBackgroundColor() = Color.WHITE
    @Dimension open fun getRoundCornerRadius() = 32f.dpToPx()


    // = = = = = = = = = = lifecycle methods = = = = = = = = = =
    final override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        CustomBottomSheetDialog(requireContext())

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        roundCornerRadius = getRoundCornerRadius()
        isAlwaysExpand = isSheetAlwaysExpanded()
        isSheetCancelable = isSheetCancelable()
        isCancelOnOutside = isSheetCancelableOnTouchOutside()

        dialog?.setCancelable(isSheetCancelable)
        val isCancelableOnTouchOutside = isSheetCancelable && isCancelOnOutside
        dialog?.setCanceledOnTouchOutside(isCancelableOnTouchOutside)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setDimAmount(0.6f)
        return null
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        flayRoundCorner = dialog?.findViewById(R.id.flayRoundCorner)!!
        viewOutside = dialog?.findViewById(R.id.viewOutside)!!

        flayRoundCorner.setBackgroundColor(getBackgroundColor())
        flayRoundCorner.setCornerRadius(roundCornerRadius)

        bsBehavior = BottomSheetBehavior.from(flayRoundCorner)
        bsBehavior.skipCollapsed = isAlwaysExpand

        if (isAlwaysExpand) {
            bsBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            flayRoundCorner.updateLayoutParams { height = getExpandedHeight() }
        } else {
            bsBehavior.peekHeight = getPeekHeight()
            flayRoundCorner.minimumHeight = bsBehavior.peekHeight
        }
    }

    protected fun getBehavior(): BottomSheetBehavior<View>? {
        if (::bsBehavior.isInitialized) return bsBehavior
        return null
    }

}