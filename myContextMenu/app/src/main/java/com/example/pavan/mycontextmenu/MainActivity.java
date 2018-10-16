package com.example.pavan.mycontextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        String[] list ={"hello","world"};
        aa= new ArrayAdapter<String>(this,R.layout.simple_list_item_1,list);
        lv.setAdapter(aa);

        registerForContextMenu(lv);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo)
    {
        super.onCreateContextMenu(menu,v,menuinfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.c_menu,menu);
    }
    public void onItemSelected(View v)
    {

    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Log.d("help time", "onContextItemSelected: "+info.position+" " +info.id);
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
