package com.mrmeta.drawingboardview;

import android.content.Context;
import android.util.AttributeSet;

import com.byox.drawview.views.DrawView;

public class DrawingBoardView extends DrawView {

    public DrawingBoardView(Context context) {
        super(context);
    }

    public DrawingBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // pen color, paint color, shape border color
    public DrawingBoardView setDrawColor(int drawColor) {
        super.setDrawColor(drawColor);
        return this;
    }

    // pen size, erase size, shape border size
    public DrawingBoardView setDrawWidth(int drawWidth) {
        super.setDrawWidth(drawWidth);
        return this;
    }

    // pen opacity
    public DrawingBoardView setDrawAlpha(int drawAlpha) {
        super.setDrawAlpha(drawAlpha);
        return this;
    }

    // TODO: implements clear

    // TODO: implements shape type

    // TODO: shape fill color

    // TODO: select eraser, paint
}