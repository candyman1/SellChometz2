package com.example.android.sellchometz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tatty on 9/12/2017.
 */

public class ShulHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shulsignin.db";

    private static final int DATABASE_VERSION =1;
    public ShulHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_LITTLE_TABLE =  "CREATE TABLE " + ShulInfoContract.ShulEntry.SHUL_TABLE + " ( "
                + ShulInfoContract.ShulEntry.SHUL_MAIL + " TEXT NOT NULL, "
                + ShulInfoContract.ShulEntry.SHUL_RABBI + " TEXT NOT NULL); ";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_LITTLE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
        db.execSQL("DROP TABLE IF EXISTS " + ShulInfoContract.ShulEntry.SHUL_TABLE);

        // Create tables again
        onCreate(db);
    }
}


