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
    Button addMyTask;
    DBHelper bdTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        final String TAG = "myLogs";
        newTask = findViewById(R.id.newTask);
        addMyTask = findViewById(R.id.AddMyTask);
        final String task = newTask.getText().toString();
        bdTask = new DBHelper(this);
        final SQLiteDatabase database = bdTask.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        addMyTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentValues.put(BDTask.INEED,task);
                database.insert(BDTask.ADDEDTASKS, null, contentValues);

            }
        });
        Cursor cursor = database.query(BDTask.ADDEDTASKS, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            int taskIndex = cursor.getColumnIndex(BDTask.INEED);
            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(TAG, ", Tasks = " + cursor.getString(taskIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (cursor.moveToNext());
        } else
            Log.d(TAG, "0 rows");
        cursor.close();

    }
}
