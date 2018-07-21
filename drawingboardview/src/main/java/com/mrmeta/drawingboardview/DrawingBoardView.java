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

    public DrawView setDrawColor(int drawColor) {
        return super.setDrawColor(drawColor);
    }
}