package com.example.dhaval.webserviceexample.Utility;

import android.content.Context;

import com.example.dhaval.webserviceexample.Database.DBHelper;

/**
 * Created by dhaval on 10/2/17.
 */

public class CommonUtility {

    /**
     * Check if singleton object of DB is null and not open; in the case
     * reinitialize and open DB.
     *
     * @param mContext
     */
    public static DBHelper getDBObject(Context mContext) {
        DBHelper dbhelper = DBHelper.getInstance(mContext);
        return dbhelper;
    }
}
