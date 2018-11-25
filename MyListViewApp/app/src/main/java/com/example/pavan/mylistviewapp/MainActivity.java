package com.example.pavan.mylistviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner lv;
    ArrayList<String> a;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        a=new ArrayList<>(Arrays.asList("hello","world","mach"));
        //aa =ArrayAdapter.createFromResource(this,R.array.countres,R.layout.lv_item);
        aa =new ArrayAdapter<String>(this,R.layout.lv_item,a);
        lv.setAdapter(aa);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),id+"=id",Toast.LENGTH_SHORT).show();
                String val = a.get(position);
                a.remove(position);
                a.add(0,val);

                aa.notifyDataSetChanged();
            }
        });
    }
}
