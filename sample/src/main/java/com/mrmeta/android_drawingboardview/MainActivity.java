package com.mrmeta.android_drawingboardview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mrmeta.drawingboardview.DrawingBoardView;

public class MainActivity extends AppCompatActivity {

    DrawingBoardView mDrawingBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawingBoardView = (DrawingBoardView)findViewById(R.id.draw_view);

        Button selectBlue = (Button)findViewById(R.id.select_blue);
        selectBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawColor(Color.BLUE);
            }
        });

        Button selectBlack = (Button)findViewById(R.id.select_black);
        selectBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawColor(Color.BLACK);
            }
        });

        Button doubleWidth = (Button)findViewById(R.id.double_width);
        doubleWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawWidth(mDrawingBoardView.getDrawWidth() * 2);
            }
        });

        Button halveWidth = (Button)findViewById(R.id.halve_width);
        halveWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawWidth(mDrawingBoardView.getDrawWidth() / 2);
            }
        });

        Button halveOpacity = (Button)findViewById(R.id.halve_opacity);
        halveOpacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawAlpha(mDrawingBoardView.getDrawAlpha() / 2);
            }
        });

        Button undoBtn = (Button)findViewById(R.id.undo);
        undoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDrawingBoardView.canUndo())
                    mDrawingBoardView.undo();
            }
        });

        Button redoBtn = (Button)findViewById(R.id.redo);
        redoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDrawingBoardView.canRedo())
                    mDrawingBoardView.redo();
            }
        });

        Button selectPen = (Button)findViewById(R.id.select_pen);
        selectPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.selectPen();
            }
        });

        Button selectEraser = (Button)findViewById(R.id.select_eraser);
        selectEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.selectEraser();
            }
        });

        Button selectRectangle = (Button)findViewById(R.id.select_rectangle);
        selectRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.selectShape(DrawingBoardView.Shape.RECTANGLE);
            }
        });

        Button selectCircle = (Button)findViewById(R.id.select_circle);
        selectCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.selectShape(DrawingBoardView.Shape.CIRCLE);
            }
        });

        Button selectFill = (Button)findViewById(R.id.select_fill);
        selectFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.selectFill();
            }
        });

        Button selectClear = (Button)findViewById(R.id.select_clear);
        selectClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.selectClear();
            }
        });

    }
}
