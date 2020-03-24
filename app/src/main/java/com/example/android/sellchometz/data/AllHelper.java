package com.example.android.sellchometz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Home on 5/9/2017.
 */

public class AllHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "signin.db";

    private static final int DATABASE_VERSION =15;

    public AllHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_BIG_TABLE =  "CREATE TABLE " + AllInfoContract.AllEntry.TABLE_NAME + " ("
                + AllInfoContract.AllEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AllInfoContract.AllEntry.FIRST_NAME + " TEXT NOT NULL, "
                + AllInfoContract.AllEntry.LAST_NAME + " TEXT NOT NULL, "
                + AllInfoContract.AllEntry.ADDRESS + " TEXT NOT NULL, "
                +AllInfoContract.AllEntry.PASSWORD+" TEXT NOT NULL, "
                +AllInfoContract.AllEntry.CITY+" TEXT NOT NULL, "
                +AllInfoContract.AllEntry.STATE+" TEXT NOT NULL, "
                +AllInfoContract.AllEntry.PHONE+" TEXT NOT NULL,"

                +AllInfoContract.AllEntry.ATTIC+" TEXT NOT NULL, "
                +AllInfoContract.AllEntry.BASEMENT+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.BATHCAB+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.BREAKFRONT+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.BRIEFCASE+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.CLOSET+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.CRAWL+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.DRAWER+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.FREEZER+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.GARAGE+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.GRILL+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.KITCAB+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.LIQUORCAB+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.MEDCHEST+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.PANTRY+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.FRIDGE+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.SHED+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.STORAGE+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.OTHERPLACE+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.CARBOX+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.CAR+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.INVESTBOX+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.INVEST+" TEXT NOT NULL, "
                +AllInfoContract.AllEntry.LOCKERBOX+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.LOCKER+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.NEIGHBORBOX+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.NEIGHBOR+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.OFFICEBOX+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.OFFICE+" TEXT NOT NULL, "
                +AllInfoContract.AllEntry.FREEZEBOX+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.FREEZE+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.OTHERBOX+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.OTTER+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.ZONEBOX+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.BAKINGING+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.BAKINGPRO+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.BARLEY+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.BEER+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.CEREAL+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.CONDIMENTS+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.COSMETICS+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.CRACKERS+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.FROZEN+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.GROCERIES+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.LIQUOR+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.MEDICINE+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.MIXES+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.NOODLE+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.OATMEAL+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.PERFUME+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.PET+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.PICKLES+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.PLAYDOUGH+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.TOILETRIES+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.VITAMINS+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.WHEAT+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.UTENSILS+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.APPLIANCE+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.BAKINGT+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.TOYS+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.BOOKS+" INTEGER NOT NULL, "
                +AllInfoContract.AllEntry.SEFORIM+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.ETC+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.ALSOINC+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.VALUE+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.STAY+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.KEYB+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.COMBB+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.KEY+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.COMB+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.FULLBED+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.EXCLUDEB+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.EXCLUDE+" TEXT NOT NULL,"
                +AllInfoContract.AllEntry.ONLYB+" INTEGER NOT NULL,"
                +AllInfoContract.AllEntry.ONLY+" TEXT NOT NULL);";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_BIG_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
        db.execSQL("DROP TABLE IF EXISTS " + AllInfoContract.AllEntry.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
}

