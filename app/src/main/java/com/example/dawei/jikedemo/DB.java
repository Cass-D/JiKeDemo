package com.example.dawei.jikedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DaWei on 2016/12/18.
 */

public class DB extends SQLiteOpenHelper {

    public DB(Context context) {
        super(context, "db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE user("+
            "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "name TEXT DEFAULT \"\","+
            "sex  TEXT DEFAULT \"\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
