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
    }
}
