package com.a_lab.textarc

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<LinearLayout>(R.id.textArcLayout).addView(
            TextArc(this).apply {
                setText("Text arc that was added programmatically")
                setRadius((resources.displayMetrics.density * 95).toInt())
                setCenterAngle(-90)
                setTextColor(R.color.blue)
                setTextSize((resources.displayMetrics.density * 28).toInt())
                setFontFamily(ResourcesCompat.getFont(this@MainActivity, R.font.krabuler))
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
        )
    }
}