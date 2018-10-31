package com.example.pavan.mysqlitedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StringDBAdapter
{
    private static final String DB_NAME="String_Database.db";
    private static final String TABLE_NAME="String_Table";
    private static final int DB_VERSION=1;

    private static final String KEY_ID="id";
    private static final String COLUMN_STRING="String";
    private static final String TABLE_CREATE="";
    private final Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;



        public StringDBAdapter(Context context)
        {
            this.context=context;
            myDBHelper=new MyDBHelper(context,DB_NAME,null,DB_VERSION);
        }
    public StringDBAdapter open() {
        db=myDBHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        db.close();
    }
    public Cursor getAllRecords() {
        return db.query(TABLE_NAME,null,null,null,null,null
                ,null);
    }
    public Cursor getRecordsWithinRange(int gid) {
        return db.query(TABLE_NAME,null,KEY_ID+"<="+gid,
                null,null,null,null);
    }
    public long addString(String str) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_STRING, str);
        return db.insert(TABLE_NAME,null,cv);
    }
    public boolean deleteRecord(long id) {
        return db.delete(TABLE_NAME,KEY_ID+"="+id,null)>0;
    }

    public int updateString(long id, String str) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_STRING, str);
        return db.update(TABLE_NAME, cv,KEY_ID+"="+id,null);
    }


        private static class MyDBHelper extends SQLiteOpenHelper{

            public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory cf,int version)
            {
                super(context,name,cf,version);

            }
            @Override
            public void onCreate(SQLiteDatabase db)
            {
                db.execSQL(TABLE_CREATE);
            }
            @Override
            public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
            {
                Log.w("Updation","Database version is being updated");
                db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
                onCreate(db);
            }

        }






}
