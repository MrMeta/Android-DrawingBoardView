package com.mrmeta.drawingboardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.byox.drawview.enums.DrawingMode;
import com.byox.drawview.enums.DrawingTool;
import com.byox.drawview.utils.SerializablePaint;
import com.byox.drawview.views.DrawView;

public class DrawingBoardView extends LinearLayout {

    DrawView mDrawView;

    public DrawingBoardView(Context context) {
        super(context);
        initView();
    }

    public DrawingBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DrawingBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_drawing_board, this, false);
        addView(view);

        mDrawView = view.findViewById(R.id.draw_view);
        initDrawView();
    }

    public void initDrawView() {
        if (mDrawView != null) {
            mDrawView.setLineCap(SerializablePaint.Cap.ROUND);

            SerializablePaint paint = new SerializablePaint();
            paint.setColor(Color.WHITE);
            mDrawView.setBackgroundPaint(paint);
            mDrawView.setBackgroundColor(Color.WHITE);
        }
    }

    // pen color, fill color, shape border color
    public DrawingBoardView setDrawColor(int drawColor) {
        mDrawView.setDrawColor(drawColor);
        return this;
    }

    public int getDrawColor() {
        return mDrawView.getDrawColor();
    }

    // pen size, erase size, shape border size
    public DrawingBoardView setDrawWidth(int drawWidth) {
        mDrawView.setDrawWidth(drawWidth);
        return this;
    }

    public int getDrawWidth() {
        return mDrawView.getDrawWidth();
    }

    // pen opacity
    public DrawingBoardView setDrawAlpha(int drawAlpha) {
        mDrawView.setDrawAlpha(drawAlpha);
        return this;
    }

    public int getDrawAlpha() {
        return mDrawView.getDrawAlpha();
    }

    // select eraser
    public DrawingBoardView selectEraser() {
        mDrawView.setDrawingMode(DrawingMode.ERASER);
        mDrawView.setPaintStyle(Paint.Style.STROKE);
        return this;
    }

    // select pen
    public DrawingBoardView selectPen() {
        mDrawView.setDrawingMode(DrawingMode.DRAW);
        mDrawView.setDrawingTool(DrawingTool.PEN);
        mDrawView.setPaintStyle(Paint.Style.STROKE);
        return this;
    }

    // select shape
    public DrawingBoardView selectShape(Shape type) {
        mDrawView.setDrawingMode(DrawingMode.DRAW);
        mDrawView.setPaintStyle(Paint.Style.FILL_AND_STROKE);
        switch (type) {
            case RECTANGLE:
                mDrawView.setDrawingTool(DrawingTool.RECTANGLE);
                break;
            case CIRCLE:
                mDrawView.setDrawingTool(DrawingTool.CIRCLE);
                break;
        }
        return this;
    }

    // select fill
    public DrawingBoardView selectFill() {
        mDrawView.setDrawingMode(DrawingMode.DRAW);
        mDrawView.setDrawingTool(DrawingTool.FILL);
        return this;
    }

    // select clear
    public DrawingBoardView selectClear() {
        mDrawView.clearHistory();
        return this;
    }

    public boolean canUndo() {
        return mDrawView.canUndo();
    }

    public boolean undo() {
        return mDrawView.undo();
    }

    public boolean canRedo() {
        return mDrawView.canRedo();
    }

    public boolean redo() {
        return mDrawView.redo();
    }

    // TODO: 분리..?
    public enum Shape {
        RECTANGLE,
        CIRCLE,
    }
}