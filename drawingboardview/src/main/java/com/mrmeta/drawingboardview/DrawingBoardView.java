package com.mrmeta.drawingboardview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class DrawingBoardView extends View {

    public DrawingBoardView(Context c) {
        super(c);
    }

    public DrawingBoardView(Context c, AttributeSet attrs) {
        super(c, attrs, 0);
    }

    public DrawingBoardView(Context c, AttributeSet attrs, int defStyle) {
        super(c, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_drawing_board, null);
    }
}
