package com.example.dhaval.webserviceexample.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.dhaval.webserviceexample.Utility.DBConstant;
import com.example.dhaval.webserviceexample.pojo.UserInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dhaval on 10/2/17.
 */

public class DBHelper {
    //database instance
    private SQLiteDatabase db;
    //context instance
    private final Context context;
    //customized class context instance
    private final TableClass dbHelper;
    public static int no;
    public static DBHelper db_helper = null;


    public static DBHelper getInstance(Context context){
        try{
            //this is because db helper we need to be singleon class.
            if(db_helper == null){

                db_helper = new DBHelper(context);
                db_helper.open();
            }
        }catch(IllegalStateException e){
            //db_helper already open
        }
        return db_helper;
    }

    /*
    * set context of the class and initialize AppData Object
    */
    public DBHelper(Context c) {
        context = c;
        dbHelper = new TableClass(context, DBConstant.DATABASE_NAME, null, DBConstant.DATABASE_VERSION);
    }

    /*
     * close databse.
     */
    public void close() {
        if (db.isOpen()) {
            db.close();
        }
    }

    public boolean dbOpenCheck() {
        try{
            return db.isOpen();
        }catch(Exception e){
            return false;
        }
    }

    /*
     * open database
     */
    public void open() throws SQLiteException {
        try {
            //dbhelper object to write getWritableDatabase.
            //dbhelper objec to write getReadableDatabase.
            db = dbHelper.getWritableDatabase();
        } catch (Exception e) {
            // Log.v("open database Exception", "error==" + e.getMessage());
            db = dbHelper.getReadableDatabase();
        }
    }

    public long insertContentVals(String tableName, ContentValues content){
        long id=0;
        try{
            id = db.insert(tableName, null, content);
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    /*
    Cursor object is used to run against the table.
     */
    public Cursor getTableRecords(String tablename, String[] columns, String where, String orderby){
        //query will be fired.The parameter are table name,columns to return,where,condition,comparingValues
        Cursor cursor =  db.query(false, tablename, columns,where, null, null, null, orderby, null);
        return cursor;
    }

     /*
	 * Get count of all tables in a table as per the condition
	 */

    public int getFullCount(String table, String where) {
        Cursor cursor = db.query(false, table, null, where, null, null, null, null, null);
        try {
            if (cursor != null) {
                cursor.moveToFirst();
                no = cursor.getCount();
                cursor.close();
            }
        } finally {
            cursor.close();
        }
        return no;
    }








    public int updateRecords(String table, ContentValues values,
                             String whereClause, String[] whereArgs) {
        int a = db.update(table, values, whereClause, whereArgs);
        return a;
    }

    public List<UserInfo> getAllUser() {
        List<UserInfo> userList = new LinkedList<UserInfo>();

        // select book query
        String query = "SELECT  * FROM " + DBConstant.TABLE_NAME;

        // get reference of the BookDB database
        Cursor cursor = db.rawQuery(query, null);
        //Cursor c= db.rawQuery(query,null );

        // parse all results
        UserInfo userInfo = null;
        if (cursor.moveToFirst()) {
            do {

                userInfo = new UserInfo();
                userInfo.setId((cursor.getString(0)).toString());
                userInfo.setUserName(cursor.getString(1));
                userInfo.setUserDob(cursor.getString(2));
                userInfo.setUserDob(cursor.getString(3));
                userInfo.setUserProfilePicture(Integer.parseInt(cursor.getString(3)));

                // Add book to books
                userList.add(userInfo);
            } while (cursor.moveToNext());
        }
        return userList;
    }

}
