package com.mrmeta.drawingboardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.byox.drawview.enums.DrawingMode;
import com.byox.drawview.enums.DrawingTool;
import com.byox.drawview.utils.SerializablePaint;
import com.byox.drawview.views.DrawView;

public class DrawingBoardView extends DrawView {

    // TODO: 분리..?
    public enum Shape {
        RECTANGLE,
        CIRCLE,
    }

    public DrawingBoardView(Context context) {
        super(context);
        init();
    }

    public DrawingBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setLineCap(SerializablePaint.Cap.ROUND);

        SerializablePaint paint = new SerializablePaint();
        paint.setColor(Color.WHITE);
        setBackgroundPaint(paint);
        setBackgroundColor(Color.WHITE);
    }

    // pen color, fill color, shape border color
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

    // select eraser
    public DrawingBoardView selectEraser() {
        setDrawingMode(DrawingMode.ERASER);
        setPaintStyle(Paint.Style.STROKE);
        return this;
    }

    // select pen
    public DrawingBoardView selectPen() {
        setDrawingMode(DrawingMode.DRAW);
        setDrawingTool(DrawingTool.PEN);
        setPaintStyle(Paint.Style.STROKE);
        return this;
    }

    // select shape
    public DrawingBoardView selectShape(Shape type) {
        setDrawingMode(DrawingMode.DRAW);
        setPaintStyle(Paint.Style.FILL_AND_STROKE);
        switch (type) {
            case RECTANGLE:
                setDrawingTool(DrawingTool.RECTANGLE);
                break;
            case CIRCLE:
                setDrawingTool(DrawingTool.CIRCLE);
                break;
        }
        return this;
    }

    // select fill
    public DrawingBoardView selectFill() {
        setDrawingMode(DrawingMode.DRAW);
        setDrawingTool(DrawingTool.FILL);
        return this;
    }

    // select clear
    public DrawingBoardView selectClear() {
        super.clearHistory();
        return this;
    }
}