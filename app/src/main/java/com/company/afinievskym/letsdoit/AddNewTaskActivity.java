package com.company.afinievskym.letsdoit;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by afini on 02.02.2018.
 */

public class AddNewTaskActivity extends Activity {
    EditText newTask;
    Button addMyTask,btnRead,btnClear;
    DBHelper bdTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        //Поля
        final String TAG = "myLogs";
        //Находим элементы
        newTask = findViewById(R.id.newTask);
        addMyTask = findViewById(R.id.AddMyTask);
        btnRead = findViewById(R.id.btnRead);
        btnClear = findViewById(R.id.btnClear);
        bdTask = new DBHelper(this);
        //Поля базы данных
        final SQLiteDatabase database = bdTask.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.AddMyTask :
                        final String task = newTask.getText().toString();
                        contentValues.put(DBHelper.TASKS,task);
                        database.insert(DBHelper.TABLE_NAME, null, contentValues);
                        break;
                    case R.id.btnRead:
                        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

                        if (cursor.moveToFirst()) {
                            int idIndex = cursor.getColumnIndex(DBHelper.ID);
                            int TasksIndex = cursor.getColumnIndex(DBHelper.TASKS);
                            int TitleIndex = cursor.getColumnIndex(DBHelper.TITLE);
                            do {
                                Log.d(TAG, "ID = " + cursor.getInt(idIndex) +
                                        ", name = " + cursor.getString(TasksIndex) +
                                        ", email = " + cursor.getString(TitleIndex));
                            } while (cursor.moveToNext());
                        } else
                            Log.d(TAG,"0 rows");

                        cursor.close();
                        break;

                    case R.id.btnClear:
                        database.delete(DBHelper.TABLE_NAME, null, null);
                        break;
                }
                bdTask.close();

            }
        };
        //Присваиваю обработчик кнопкам
        addMyTask.setOnClickListener(onClickListener);
        btnClear.setOnClickListener(onClickListener);
        btnRead.setOnClickListener(onClickListener);
        //

    }
}
