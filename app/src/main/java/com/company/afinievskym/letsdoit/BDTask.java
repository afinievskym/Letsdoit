package com.company.afinievskym.letsdoit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Programmer on 28.01.2018.
 */

public class BDTask extends SQLiteOpenHelper {
    public static final String TASKDATABASE= "mytasks";
    public static final String ADDEDTASKS = "myaddedtasks";
    public static final int DATABASE_VERSION = 1;
    public static final String INEED = "my_task_in_edit";
    //*Обнуляю курсор
    public BDTask(Context context, String name, int version) {
        super(context, TASKDATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bdTask) {
        bdTask.execSQL("create table " + ADDEDTASKS + "(" + " integer primary key," + INEED + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase bdTask, int i, int i1) {
        bdTask.execSQL("drop table if exists " + ADDEDTASKS);
        onCreate(bdTask);

    }
}
