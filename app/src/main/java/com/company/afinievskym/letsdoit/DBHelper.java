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
    public static final String TABLE_OBJECTIVE_TITLE = "MyObjective";
    //Столбцы
    public static final String TASKS = "MyAddedTasks";
    public static final String ID = "_id";
    public static final String OBJEKTIVES = "MyAddedObjectives";
    public static final String OBJECTIVE_ID = "_id";

    //Objective BD
    public static final String TABLE_ADD_OBJECTIVE_TASK = "MyOTask";
    public static final String OBJEKTIVE_TASKS = "MyAdeedObjektivesTasks";
    public static final String OBJEKTIVE_TASKS_ID = "_id";
    public static final String TASKS_SQL = "create table " + TABLE_NAME + "(" + ID + " integer primary key," /*+ TITLE*/ + " text," + TASKS + " text" + ")";
    public static final String OBJECTIVE_SQL = "create table " + TABLE_OBJECTIVE_TITLE + "(" + ID + " integer primary key," /*+ TITLE*/ + " text," + OBJEKTIVES + " text" + ")";
    //public static final String TITLE = "Title";

    //Номера столбцов
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TASKS_SQL + OBJECTIVE_SQL);
        //+ TABLE_OBJECTIVE_TITLE + TABLE_ADD_OBJECTIVE_TASK
        //OBJECTIVE_ID +OBJEKTIVE_TASKS_ID +
        //OBJEKTIVES + OBJEKTIVE_TASKS +
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME );

    }
}
