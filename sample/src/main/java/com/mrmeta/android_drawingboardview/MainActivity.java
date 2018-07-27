package com.mrmeta.android_drawingboardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mrmeta.drawingboardview.DrawingBoardView;

public class MainActivity extends AppCompatActivity {

    DrawingBoardView mDrawingBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
