package com.a_lab.textarc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextArc textArc = new TextArc(this);
        textArc.setText("Text arc that was added programmatically");
        textArc.setRadius(255);
        textArc.setCenterAngle(-90);
        textArc.setTextColor(R.color.blue);
        textArc.setTextSize(72);
        textArc.setFontFamily(ResourcesCompat.getFont(this, R.font.krabuler));

        textArc.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        ((FrameLayout)findViewById(R.id.flTextArc)).addView(textArc);
    }
}