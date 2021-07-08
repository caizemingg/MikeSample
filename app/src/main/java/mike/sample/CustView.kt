package mike.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2021/4/29
 * @description:
 */
class CustView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint().apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
        canvas.drawCircle(50f, 50f, 50f, mPaint)
        canvas.drawRect(50f,50f, 100f, 100f,mPaint)
    }
}