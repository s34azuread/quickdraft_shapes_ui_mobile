package org.firstdraft.quickdraft_shapes_ui_mobile;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

public class RectangleView
        extends AppCompatTextView
{
    static String file_name = "";
    static String user_name = "";

    Paint mpaint = new Paint();

    Paint paint2 = new Paint();

    float text_width,textSize;

    static String s = "";

    EditText ed;

    int RECTANGLE_BASE_WIDTH = 150;
    int RECTANGLE_BASE_HEIGHT = 100;

    private void draw_rectangle(Canvas canvas,
                                int base_width,int base_height,
                                String text)
    {
        paint2.setColor(Color.BLACK);
        paint2.setTextSize(50);  //set text size

        text_width = paint2.measureText(text)/2;
        textSize = paint2.getTextSize();

        paint2.setTextAlign(Paint.Align.CENTER);

        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setColor(Color.BLACK);

        int x = (this.getWidth() - base_width)/2;
        int y = (this.getHeight() - base_height)/2;

        int text_x,text_y;
        text_x = x + (int)text_width/2;
        text_y = y + (int)textSize/2;

        canvas.drawRect(x - text_width,
                y - textSize,
                x + text_width + base_width,
                y - textSize + base_height, mpaint);

        canvas.drawText(s, text_x, text_y ,paint2); //x=250,y=250

    }

    private void set_params()
    {

        TransmitRectangleUtility.base_width = RECTANGLE_BASE_WIDTH;
        TransmitRectangleUtility.base_height = RECTANGLE_BASE_HEIGHT;
        TransmitRectangleUtility.horizontal_deviation = text_width;

        TransmitRectangleUtility.shape_text = s;

        /*TransmitRectangleUtility.add_shape_element(RECTANGLE_BASE_WIDTH, RECTANGLE_BASE_HEIGHT,
                                                    text_width, s);*/

        TransmitRectangleUtility.canvas_width = this.getWidth();
        TransmitRectangleUtility.canvas_height = this.getHeight();

    }

    @Override
    public void onDraw(Canvas canvas) {

        draw_rectangle(canvas,RECTANGLE_BASE_WIDTH,RECTANGLE_BASE_HEIGHT,s);

        set_params();

    }

    public RectangleView(Context c) {
        super(c);
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
