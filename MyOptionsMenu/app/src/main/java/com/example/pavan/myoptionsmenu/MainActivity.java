package com.example.pavan.myoptionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.o_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.i1:
                Toast.makeText(this,"i1",Toast.LENGTH_SHORT);
                return true;
            case R.id.i2:
                Toast.makeText(this,"i2",Toast.LENGTH_SHORT);
                return true;
            case R.id.i3:
                Toast.makeText(this,"i3",Toast.LENGTH_SHORT);
                return true;
            case R.id.i4:
                Toast.makeText(this,"i4",Toast.LENGTH_SHORT);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
