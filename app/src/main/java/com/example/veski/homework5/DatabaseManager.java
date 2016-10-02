package com.example.veski.homework5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.inputmethodservice.Keyboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veski on 2.10.2016 г..
 */

public class DatabaseManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HW_name";
    private static final String TABLE_NAME = "ListItem" ;

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "some_name";
    private static final String KEY_INFO = "some_info";


    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STATEMENT = "CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT," + KEY_INFO + " TEXT)";
        db.execSQL(CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String UPGRADE_STATEMENT = "DROP IF EXISTS " + TABLE_NAME;

        onCreate(db);
    }

    void addRecord(ListItem record){
        SQLiteDatabase currentDB = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, record.get_id());
        values.put(KEY_NAME, record.get_some_name());
        values.put(KEY_INFO, record.get_some_info());
        currentDB.insert(TABLE_NAME, null, values);

        currentDB.close();
    }

    public List<ListItem> getAllRecords(){
        SQLiteDatabase currentDB = this.getWritableDatabase();

        List<ListItem> listItems = new ArrayList<ListItem>();
        String SELECT = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor =  currentDB.rawQuery(SELECT,null);
        int count = cursor.getCount();
        if(cursor != null) {
            cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                ListItem item = new ListItem(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                listItems.add(item);
                cursor.moveToNext();
            }
        }

        return listItems;
    }
}
