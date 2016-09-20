package com.descarteaqui.descarteaqui.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "descarteaqui.db";

    // Table Names
    public static final String TABLE_MARKERS = "markers";
    public static final String TABLE_PETITIONS = "petitions";

    // Table Creating
    public static final String CREATE_TABLE_MARKERS = "create table "+ TABLE_MARKERS +"("
            + "_id" + " integer primary key autoincrement, "
            + "title" + " text, "
            + "latitude" + " text, "
            + "longitude" + " text, "
            + "snippet" + " text, "
            + "icon" + " integer"
            +");";

    public static final String CREATE_TABLE_PETITIONS = "create table "+ TABLE_PETITIONS +"("
            + "_id" + " integer primary key autoincrement, "
            + "street" + " text, "
            + "created_at" + " text, "
            + "district" + " text, "
            + "justification" + " text, "
            + "creator" + " text, "
            + "ok_rates" + " integer, "
            + "ng_rates" + " integer"
            +");";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_MARKERS);
        db.execSQL(CREATE_TABLE_PETITIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("drop table if exists " + TABLE_PETITIONS);
        db.execSQL("drop table if exists " + TABLE_MARKERS);

        // create new tables
        onCreate(db);
    }

}