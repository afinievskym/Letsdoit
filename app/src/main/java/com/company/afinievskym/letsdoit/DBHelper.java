package com.company.afinievskym.letsdoit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by afini on 02.02.2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    //Данные базы данных и таблиц
    public static final String DATABASE_NAME = "Task";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "MyTasks";
    public static final String TABLE_OBJECTIVE_NAME = "MyObjective";
    //Столбцы
    public static final String TASKS = "MyAddedTasks";
    public static final String ID = "_id";
    public static final String OBJEKTIVES = "MyAddedObjectives";
    public static final String OBJECTIVE_ID = "_id";
    //public static final String TITLE = "Title";
    //Номера столбцов
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + TABLE_OBJECTIVE_NAME + "(" + ID + OBJECTIVE_ID + " integer primary key," /*+ TITLE*/ + " text," + TASKS + OBJEKTIVES + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
    }
}
