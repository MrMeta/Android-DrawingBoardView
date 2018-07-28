package com.mrmeta.drawingboardview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;

import com.byox.drawview.enums.DrawingMode;
import com.byox.drawview.enums.DrawingTool;
import com.byox.drawview.utils.SerializablePaint;
import com.byox.drawview.views.DrawView;
import com.skydoves.colorpickerpreference.ColorEnvelope;
import com.skydoves.colorpickerpreference.ColorListener;
import com.skydoves.colorpickerpreference.ColorPickerDialog;

public class DrawingBoardView extends LinearLayout {

    private static final int DRAW_WIDTH_MINIMUM = 1;

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

        ImageButton selectPenButton = view.findViewById(R.id.select_pen);
        selectPenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPen();
            }
        });

        ImageButton selectEraserButton = view.findViewById(R.id.select_eraser);
        selectEraserButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectEraser();
            }
        });

        ImageButton selectRectangleButton = view.findViewById(R.id.select_rectangle);
        selectRectangleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectShape(Shape.RECTANGLE);
            }
        });

        ImageButton selectCircleButton = view.findViewById(R.id.select_circle);
        selectCircleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectShape(Shape.CIRCLE);
            }
        });

        ImageButton selectFillButton = view.findViewById(R.id.select_fill);
        selectFillButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFill();
            }
        });

        SeekBar selectDrawWidthSeekBar = view.findViewById(R.id.select_draw_width);
        selectDrawWidthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setDrawWidth(DRAW_WIDTH_MINIMUM + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ColorRadioButton selectRedButton = view.findViewById(R.id.select_red);
        selectRedButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setDrawColor(((ColorRadioButton)v).getBaseColorCode());
            }
        });

        ColorRadioButton selectGreenButton = view.findViewById(R.id.select_green);
        selectGreenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setDrawColor(((ColorRadioButton)v).getBaseColorCode());
            }
        });

        ColorRadioButton selectBlueButton = view.findViewById(R.id.select_blue);
        selectBlueButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setDrawColor(((ColorRadioButton)v).getBaseColorCode());
            }
        });

        ColorRadioButton selectBlackButton = view.findViewById(R.id.select_black);
        selectBlackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setDrawColor(((ColorRadioButton)v).getBaseColorCode());
            }
        });

        RadioButton moreColorButton = view.findViewById(R.id.more_color);
        moreColorButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerDialog.Builder builder = new ColorPickerDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                builder.setTitle(getContext().getString(R.string.choose_color));
                builder.setPreferenceName("pen_color");
                builder.setPositiveButton(getContext().getString(R.string.confirm), new ColorListener() {
                    @Override
                    public void onColorSelected(ColorEnvelope colorEnvelope) {
                        setDrawColor(colorEnvelope.getColor());
                    }
                });
                builder.setNegativeButton(getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
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