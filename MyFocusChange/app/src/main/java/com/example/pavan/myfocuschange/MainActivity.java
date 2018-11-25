package com.example.pavan.myfocuschange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    View.OnFocusChangeListener f=new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(!hasFocus) return;
            if(v==e1)
            {
                Toast.makeText(getApplicationContext(),"e1 focus",Toast.LENGTH_SHORT).show();


            }
            else if (v==e2)
            {
                Toast.makeText(getApplicationContext(),"e2 focus",Toast.LENGTH_SHORT).show();

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e1.setOnFocusChangeListener(f);
        e2.setOnFocusChangeListener(f);
    }
}
