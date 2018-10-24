package com.example.pavan.filestorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button btnStore,btnClear,btnRetrieve;
    EditText e1,e2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        btnStore=(Button)findViewById(R.id.btn1);
        t1=findViewById(R.id.t1);
    }


    private void writeToFile(String text) {
        try {
            OutputStreamWriter outputStreamWriter = new
                    OutputStreamWriter(openFileOutput("userinput.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(text);
            outputStreamWriter.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    private String getFileContent() {
        String fileContent = "";
        try {
            InputStream is = openFileInput("userinput.txt");
            if (is != null) {
                InputStreamReader isr = new InputStreamReader(
                        is);
                BufferedReader br = new BufferedReader(isr);
                String line = "";
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                is.close();
                fileContent = sb.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn1:
                writeToFile(e2.getText().toString());
                break;
            case R.id.btn2:
                t1.setText(getFileContent());
                break;

        }
    }
}
