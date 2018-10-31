package com.example.pavan.mysimplegraphicsapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        c.drawCircle(300,20,65,p);

    }
}
