package com.company.afinievskym.letsdoit;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by afini on 02.02.2018.
 */

public class AddNewTaskActivity extends Activity {
    EditText newTask;
    Button addMyTask, btnRead, btnClear;
    DBHelper dbHelper;

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
                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                switch (view.getId()) {
                    case R.id.AddMyTask:
                        contentValues.put(DBHelper.TASKS, task);

                        database.insert(DBHelper.TABLE_NAME, null, contentValues);
                        break;

                    case R.id.btnRead:
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
                        break;
                }
                dbHelper.close();


            }
        };
       addMyTask.setOnClickListener(onClickListener);
       btnRead.setOnClickListener(onClickListener);
       btnClear.setOnClickListener(onClickListener);
    }

}
