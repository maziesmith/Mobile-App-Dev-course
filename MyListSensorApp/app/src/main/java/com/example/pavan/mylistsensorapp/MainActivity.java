package com.example.pavan.mylistsensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sm;
    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm =(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> ls = sm.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sb = new StringBuilder();
        for(Sensor sensor : ls)
        {
            sb.append(sensor.getName()+"\n");
        }
        t.setText(sb.toString());

    }
}
