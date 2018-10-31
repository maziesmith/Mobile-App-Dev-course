package com.example.pavan.mysqlitedatabaseapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    StringDBAdapter sdba;
    StringBuilder sb;
    EditText e1;
    TextView t1;
    Button b1;
    Button b2;
    Button b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sdba=new StringDBAdapter(this);
        sb = new StringBuilder();
        sdba.open();
        e1=findViewById(R.id.e1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        t1=findViewById(R.id.t1);

    }
    public void onClick(View V) {
        switch(V.getId()) {
            case R.id.b1:
                if (!e1.getText().toString().equals("")) {
                    sdba.addString(e1.getText().toString());
                    Toast.makeText(this, "String is added to Database", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(this, "String is empty", Toast.LENGTH_LONG).show();
                break;
            case R.id.b3:
                fetchAndDisplayAllTuples();
                break;
        }
    }

    void fetchAndDisplayAllTuples() {
        if(sdba==null)
            return;
        Cursor c=sdba.getAllRecords();
        StringBuilder sb = new StringBuilder();
        while(c.moveToNext()) {
            sb.append(c.getInt(0)+" "+c.getString(1)+"\n");
        }
        t1.setText(sb.toString());
    }
}
