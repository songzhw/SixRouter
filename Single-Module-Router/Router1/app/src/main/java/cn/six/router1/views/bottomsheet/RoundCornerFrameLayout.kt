package cn.six.router1.views.bottomsheet

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.FrameLayout

class RoundCornerFrameLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val path = Path()
    private val rect = RectF()
    private val outerRadii = floatArrayOf(
        /* Top left corner*/    0f, 0f,     /* Top right corner*/   0f, 0f,
        /*Bottom right corner*/ 0f, 0f,     /* Bottom left corner*/ 0f, 0f
    )
    private var isNoCornerRadius = false

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rect.set(0f, 0f, w.toFloat(), h.toFloat())
        resetPath()
    }

    override fun draw(canvas: Canvas) {
        if(isNoCornerRadius) {
            super.draw(canvas)
            return
        }

        val saveCount = canvas.save()
        canvas.clipPath(path)
        super.draw(canvas)
        canvas.restoreToCount(saveCount)
    }


    internal fun setCornerRadius(radius: Float) {
        // Top left corner
        outerRadii[0] = radius; outerRadii[1] = radius
        // Top right corner
        outerRadii[2] = radius; outerRadii[3] = radius
        if (width == 0 || height == 0) return

        isNoCornerRadius = (radius == 0f)
        resetPath()
        invalidate()
    }

    private fun resetPath() {
        path.reset()
        path.addRoundRect(rect, outerRadii, Path.Direction.CW)
        path.close()
    }
}