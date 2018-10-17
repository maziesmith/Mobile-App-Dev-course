package com.example.pavan.smsapphw;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    String phno;
    String message;
    Button b1;
    final int MY_PERMISSIONS_REQUEST_SEND_SMS=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);
        //MY_PERMISSIONS_REQUEST_SEND_SMS=1;

    }
    public void onClick(View v)
    {
        sendSMSMessage();
    }
    public void sendSMSMessage()
    {

        //check if permissions have been granted
        phno = e1.getText().toString();
        message = e2.getText().toString();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
            return;
        }
        for(int i=0;i<10;i++) {


            SmsManager smsmgr = SmsManager.getDefault();
            smsmgr.sendTextMessage(phno, null, i+"", null, null);
            try
            {
                sleep(1000);
            }
            catch (Exception e)
            {

            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int [] grantResults)
    {
        switch(requestCode)
        {
            case MY_PERMISSIONS_REQUEST_SEND_SMS:
            {
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {
                    sendSMSMessage();
                    /*
                    SmsManager smsmgr =  SmsManager.getDefault();
                    smsmgr.sendTextMessage(phno,null,message,null,null);
                    */
                }
            }
        }
    }
}
