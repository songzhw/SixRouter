package cn.six.router1.views.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatDialog
import cn.six.router1.databinding.SheetGrandparentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetBehavior.State

class CustomBottomSheetDialog : AppCompatDialog {

    private lateinit var vb: SheetGrandparentBinding
    private lateinit var behavior: BottomSheetBehavior<FrameLayout>

    internal var cancelable = true
    private var canceledOnTouchOutside = true

    private val bottomSheetCallback = object : BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, @State newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) cancel()
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {/* no op */
        }
    }

    constructor(context: Context) : this(context, 0)

    constructor(context: Context, theme: Int) : super(context, theme) {
        // We hide the title bar for any style configuration. Otherwise, there will be a gap
        // above the bottom sheet when it is expanded.
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun setContentView(@LayoutRes layoutResId: Int) =
        super.setContentView(wrapInBottomSheet(layoutResId, null, null))

    override fun setContentView(view: View) = super.setContentView(wrapInBottomSheet(0, view, null))
    override fun setContentView(view: View, params: ViewGroup.LayoutParams?) =
        super.setContentView(wrapInBottomSheet(0, view, params))

    override fun setCancelable(cancelable: Boolean) {
        super.setCancelable(cancelable)
        if (this.cancelable != cancelable) {
            this.cancelable = cancelable
            if (::behavior.isInitialized) {
                behavior.isHideable = cancelable
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (::behavior.isInitialized) {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            behavior.addBottomSheetCallback(bottomSheetCallback)
        }
    }

    override fun onStop() {
        behavior.removeBottomSheetCallback(bottomSheetCallback)
        super.onStop()
    }

    override fun setCanceledOnTouchOutside(cancel: Boolean) {
        super.setCanceledOnTouchOutside(cancel)
        if (cancel && !cancelable) cancelable = true
        canceledOnTouchOutside = cancel
    }


    private fun wrapInBottomSheet(
        layoutResId: Int,
        view: View?,
        params: ViewGroup.LayoutParams?
    ): View {
        var supportView = view
        vb = SheetGrandparentBinding.inflate(layoutInflater)

        if (layoutResId != 0 && supportView == null) {
            supportView = layoutInflater.inflate(layoutResId, vb.colaySheet, false)
        }

        behavior = BottomSheetBehavior.from(vb.flayRoundCorner)
        behavior.isHideable = cancelable

        if (params == null) vb.flayRoundCorner.addView(supportView)
        else vb.flayRoundCorner.addView(supportView, params)

        vb.viewOutside.setOnClickListener {
            if (cancelable && isShowing && canceledOnTouchOutside) {
                cancel()
            }
        }

        // Consume the event and prevent it from falling through
        vb.flayRoundCorner.setOnTouchListener { _, _ -> true }

        return vb.flaySheetRoot
    }

}