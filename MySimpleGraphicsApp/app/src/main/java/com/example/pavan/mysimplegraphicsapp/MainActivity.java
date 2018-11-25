package com.example.pavan.mysimplegraphicsapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Canvas c;
    DemoView demo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demo = new DemoView(this);
        setContentView(demo);
    }

    public class DemoView extends View
    {
        public DemoView(Context mContext)
        {
            super(mContext);
        }
        @Override
        public void onDraw(Canvas c)
        {
            super.onDraw(c);
            Paint p = new Paint();
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.YELLOW);
            int i=0;
            c.drawRect(100, i, 200, i, p);
            Paint p2 = new Paint();
            p2.setColor(Color.BLACK);
            c.drawRect(100, 100+i, 200, 200+i, p2);
            Paint p3 = new Paint();
            /*
            p3.setColor(Color.GREEN);
            c.drawRect(100, 100+2*i, 200, 200+2*i, p3);
            */
        }
    }
}
