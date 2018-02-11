package com.company.afinievskym.letsdoit;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by afini on 02.02.2018.
 */

public class AddNewTaskActivity extends Activity {
    EditText newTask;
    Button addMyTask, btnRead, btnClear;
    DBHelper dbHelper;
    ArrayList<String> myAddedTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        //Поля

        //Находим элементы
        newTask = findViewById(R.id.newTask);
        addMyTask = findViewById(R.id.AddMyTask);
        btnRead = findViewById(R.id.btnRead);
        btnClear = findViewById(R.id.btnClear);
        dbHelper = new DBHelper(this);

        //Поля базы данных
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Запись в БД
                String task = newTask.getText().toString();

                SQLiteDatabase database;

                ContentValues contentValues = new ContentValues();
                try {
                    database = dbHelper.getWritableDatabase();
                }
                catch (SQLiteException ex){
                    database = dbHelper.getReadableDatabase();
                }
                switch (view.getId()) {
                    case R.id.AddMyTask:
                        contentValues.put(DBHelper.TASKS, task);

                        database.insert(DBHelper.TABLE_NAME, null, contentValues);


                        //Комментирую ненужные кнопки
                    /*case R.id.btnRead:
                        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

                        if (cursor.moveToFirst()) {
                            int idIndex = cursor.getColumnIndex(DBHelper.ID);
                            int taskIndex = cursor.getColumnIndex(DBHelper.TASKS);
                            do {
                                Log.d("myLog", "ID = " + cursor.getInt(idIndex) +
                                        ", task = " + cursor.getString(taskIndex));
                            } while (cursor.moveToNext());
                        } else
                            Log.d("myLog", "0 task");

                        cursor.close();
                        break;

                    case R.id.btnClear:
                        database.delete(DBHelper.TABLE_NAME, null, null);
                        break;*/

                        myAddedTasks = new ArrayList<>();
                        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

                        if (cursor.moveToFirst()) {
                            int idIndex = cursor.getColumnIndex(DBHelper.ID);
                            int taskIndex = cursor.getColumnIndex(DBHelper.TASKS);
                            do {
                        /*Log.d("myLog", "ID = " + cursor.getInt(idIndex) +
                                ", task = " + cursor.getString(taskIndex));*/
                                myAddedTasks.add(cursor.getString(taskIndex));
                                Log.d("myLog", "Size =" + myAddedTasks.size());
                            } while (cursor.moveToNext());
                        } else
                            //Log.d("myLog", "0 task");

                            cursor.close();
                        dbHelper.close();
                        Intent intentMain = new Intent(AddNewTaskActivity.this, MainDrawerAndTasks.class);
                        startActivity(intentMain);


                }
            }
        };

       addMyTask.setOnClickListener(onClickListener);
       /*btnRead.setOnClickListener(onClickListener);
       btnClear.setOnClickListener(onClickListener);*/
    }

}
