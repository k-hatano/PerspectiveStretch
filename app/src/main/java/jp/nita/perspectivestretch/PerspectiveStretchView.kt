package jp.nita.perspectivestretch

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.logging.Handler
import kotlin.math.cos
import kotlin.math.sin

class PerspectiveStretchView(context: Context?, attributes: AttributeSet?) : View(context, attributes) {
    var currentAngle: Double = 0.0
    var currentZRate = 1.0

    fun updateViewBy(time: Int) {
        currentAngle = (time * 10.0 / 8.0) / 90 * Math.PI
        currentZRate = (sin(time * 10 / 360.0) + 1) * 0.8 + 0.1
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val ZStrength = 36

        var paint = Paint()
        paint.color = Color.WHITE
        canvas?.drawRect(Rect(0, 0, this.width, this.height), paint)

        paint.color = Color.BLACK
        canvas?.drawOval(RectF(((this.width * 20 / 64 - this.width * currentZRate / ZStrength) - this.width * 10 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) - this.width * 10 / 64 * currentZRate / 2).toFloat(),
                ((this.width * 20 / 64 - this.width * currentZRate / ZStrength) + this.width * 10 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) + this.width * 10 / 64 * currentZRate / 2).toFloat()
        ), paint)

        canvas?.drawOval(RectF(((this.width * 44 / 64 + this.width * currentZRate / ZStrength) - this.width * 10 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) - this.width * 10 / 64 * currentZRate / 2).toFloat(),
                ((this.width * 44 / 64 + this.width * currentZRate / ZStrength) + this.width * 10 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) + this.width * 10 / 64 * currentZRate / 2).toFloat()
        ), paint)

        paint.color = Color.WHITE
        canvas?.drawOval(RectF(((this.width * 20 / 64 - this.width * currentZRate / ZStrength) - this.width * 6 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) - this.width * 6 / 64 * currentZRate / 2).toFloat(),
                ((this.width * 20 / 64 - this.width * currentZRate / ZStrength) + this.width * 6 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) + this.width * 6 / 64 * currentZRate / 2).toFloat()
        ), paint)

        canvas?.drawOval(RectF(((this.width * 44 / 64 + this.width * currentZRate / ZStrength) - this.width * 6 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) - this.width * 6 / 64 * currentZRate / 2).toFloat(),
                ((this.width * 44 / 64 + this.width * currentZRate / ZStrength) + this.width * 6 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) + this.width * 6 / 64 * currentZRate / 2).toFloat()
        ), paint)

        paint.color = Color.WHITE
        paint.strokeWidth = (this.width / 32.0f * currentZRate).toFloat()
        canvas?.drawLine((this.width * 20 / 64 - this.width * currentZRate / ZStrength).toFloat(),
                (this.height * 32 / 64).toFloat(),
                ((this.width * 20 / 64 - this.width * currentZRate / ZStrength) + cos(currentAngle) * this.width * 16 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) + sin(currentAngle) * this.width * 16 / 64 * currentZRate / 2).toFloat(), paint)

        canvas?.drawLine((this.width * 44 / 64 + this.width * currentZRate / ZStrength).toFloat(),
                (this.height * 32 / 64).toFloat(),
                ((this.width * 44 / 64 + this.width * currentZRate / ZStrength) + cos(currentAngle) * this.width * 16 / 64 * currentZRate / 2).toFloat(),
                ((this.height * 32 / 64) + sin(currentAngle) * this.width * 16 / 64 * currentZRate / 2).toFloat(), paint)
    }
}