package com.company.afinievskym.letsdoit.Tasks;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.company.afinievskym.letsdoit.DBHelper;
import com.company.afinievskym.letsdoit.MainDrawerAndTasks;
import com.company.afinievskym.letsdoit.R;

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
                ContentValues contentValues = new ContentValues();
                SQLiteDatabase database;

                //ContentValues contentValues = new ContentValues();

                switch (view.getId()) {

                    case R.id.AddMyTask:
                        try {
                            database = dbHelper.getWritableDatabase();
                        } catch (SQLiteException ex) {
                            database = dbHelper.getReadableDatabase();
                        }

                        
                        contentValues.put(DBHelper.TASKS, task);

                        database.insert(DBHelper.TABLE_NAME, null, contentValues);


                        //Комментирую ненужные кнопки
                    /*
                    case R.id.btnClear:
                        database.delete(DBHelper.TABLE_NAME, null, null);
                        break;*/
                        dbHelper.close();
                        Intent intentMain = new Intent(AddNewTaskActivity.this, MainDrawerAndTasks.class);
                        startActivity(intentMain);


                }
            }
        };

       addMyTask.setOnClickListener(onClickListener);
       //btnClear.setOnClickListener(onClickListener);
    }

}
