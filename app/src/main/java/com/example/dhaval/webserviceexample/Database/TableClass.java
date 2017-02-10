package com.example.dhaval.webserviceexample.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dhaval.webserviceexample.Utility.DBConstant;

/**
 * Created by dhaval on 10/2/17.
 */

public class TableClass extends SQLiteOpenHelper {
    Context context;

    TableClass(Context context,String database,String nullColumnCheck,int databaseVersion)
    {
        super(context, DBConstant.DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String table="CREATE TABLE IF NOT EXIST"+DBConstant.TABLE_NAME+" ("
                + DBConstant.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DBConstant.USER_NAME + " TEXT, "
                + DBConstant.USER_PROFILE_PICTURE + " TEXT, "
                + DBConstant.USER_DOB + " TEXT ,"
                + DBConstant.USER_PASSWORD+ "Text) ";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        context.deleteDatabase(DBConstant.DATABASE_NAME);
        onCreate(db);
    }
}
