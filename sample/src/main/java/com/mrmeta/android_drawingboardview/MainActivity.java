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

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawColor(Color.BLUE);
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawWidth(8);
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawingBoardView.setDrawAlpha(mDrawingBoardView.getDrawAlpha() / 2);
            }
        });
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDrawingBoardView.canUndo())
                    mDrawingBoardView.undo();
            }
        });

        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDrawingBoardView.canRedo())
                    mDrawingBoardView.redo();
            }
        });

    }
}
