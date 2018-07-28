package com.mrmeta.drawingboardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

public class ColorRadioButton extends AppCompatRadioButton {
    private String mBaseColor;
    private int mBaseColorCode;

    public ColorRadioButton(Context context) {
        super(context);
        init();
    }

    public ColorRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
        init();

    }

    public ColorRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
        init();
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ColorRadioButton,
                0, 0
        );

        try {
            mBaseColor = a.getString(R.styleable.ColorRadioButton_base_color);
            mBaseColorCode = Color.parseColor(mBaseColor);
        } finally {
            a.recycle();
        }
    }

    private void init() {
        GradientDrawable colorCircle = (GradientDrawable) getResources().getDrawable(R.drawable.color_circle);
        GradientDrawable borderedColorCircle = (GradientDrawable) getResources().getDrawable(R.drawable.bordered_color_circle);
        colorCircle.setColor(mBaseColorCode);
        borderedColorCircle.setColor(mBaseColorCode);

        StateListDrawable selector = new StateListDrawable();

        selector.addState(new int[] {-android.R.attr.state_checked}, colorCircle);
        selector.addState(new int[] {+android.R.attr.state_checked}, borderedColorCircle);

        setButtonDrawable(selector);
    }

    public String getBaseColor() {
        return mBaseColor;
    }

    public void setBaseColor(String color) {
        mBaseColor = color;
    }

    public int getBaseColorCode() {
        return mBaseColorCode;
    }
}
