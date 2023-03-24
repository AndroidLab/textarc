package com.a_lab.textarc

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat

/**
 * Text arc.
 */
class TextArc @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr
) {
    private var radius = 320
    //private int startAngle = Integer.MIN_VALUE;
    //private int sweepAngle = Integer.MIN_VALUE;
    private var centerAngle = -90
    private var textSize: Int = (resources.displayMetrics.density * 16).toInt()
    private var text = ""

    private var textColor = Color.WHITE
    private var fontFamily: Typeface? = null

    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG)
    private var offset = 0

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextArc)

        radius = typedArray.getDimensionPixelSize(R.styleable.TextArc_radius, radius)

        //startAngle = typedArray.getInteger(R.styleable.TextArc_start_angle, startAngle);
        //sweepAngle = typedArray.getInteger(R.styleable.TextArc_sweep_angle, sweepAngle);
        centerAngle = typedArray.getInteger(R.styleable.TextArc_center_angle, centerAngle)
        textSize = typedArray.getDimensionPixelSize(R.styleable.TextArc_text_size, textSize)

        text = typedArray.getString(R.styleable.TextArc_text) ?: ""
        textColor = typedArray.getColor(R.styleable.TextArc_text_color, Color.WHITE)

        fontFamily = typedArray.getResourceId(R.styleable.TextArc_font_family, -1).let {
            if (it == -1) {
                null
            } else {
                ResourcesCompat.getFont(context, it)
            }
        }

        typedArray.recycle();
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        offset = (textSize * 0.75f).toInt()

        layoutParams.width = if (radius > 0) radius * 2 + offset * 2 else 0
        layoutParams.height = if (radius > 0) radius * 2 + offset * 2 else 0

        requestLayout()

        paintText.color = textColor
        paintText.typeface = fontFamily
        paintText.textSize = textSize.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        val textWidth = paintText.measureText(text)
        val circumference = (2 * Math.PI * radius).toFloat() //Circumference length
        val textAngle = textWidth * 360 / circumference //Угол занимаемый текстом
        val startAngle = centerAngle - textAngle / 2
        val oval = RectF(
            offset.toFloat(), offset.toFloat(),
            (radius * 2 + offset).toFloat(), (radius * 2 + offset).toFloat()
        )
        val pathArc = Path()
        pathArc.addArc(oval, startAngle, 350f)
        canvas.drawTextOnPath(text, pathArc, 0f, 0f, paintText)
    }


    /**
     * Sets text.
     * @param text Text.
     */
    fun setText(text: String?) {
        this.text = text ?: ""
        invalidate()
    }

    /**
     * Sets radius.
     * @param radius Radius.
     */
    fun setRadius(radius: Int) {
        this.radius = radius
        invalidate()
    }

    /**
     * Sets center angle.
     * @param centerAngle Center angle.
     */
    fun setCenterAngle(centerAngle: Int) {
        this.centerAngle = centerAngle
        invalidate()
    }

    /**
     * Sets text color.
     * @param textColor Text color.
     */
    fun setTextColor(textColor: Int) {
        this.textColor = textColor
        invalidate()
    }

    /**
     * Sets text size.
     * @param textSize Text size.
     */
    fun setTextSize(textSize: Int) {
        this.textSize = textSize.toFloat().toInt()
        invalidate()
    }

    /**
     * Sets font family.
     * @param fontFamily Font family.
     */
    fun setFontFamily(fontFamily: Typeface?) {
        this.fontFamily = fontFamily
        invalidate()
    }

}