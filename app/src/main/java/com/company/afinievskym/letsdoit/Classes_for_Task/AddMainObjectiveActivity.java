package com.company.afinievskym.letsdoit.Classes_for_Task;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.company.afinievskym.letsdoit.DBHelper;
import com.company.afinievskym.letsdoit.MainDrawerAndTasks;
import com.company.afinievskym.letsdoit.R;

public class AddMainObjectiveActivity extends AppCompatActivity {
    EditText newObjective;
    Button addMyObjective;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main_objective);


        //Находим элементы
        newObjective = findViewById(R.id.neweditMainObjective);
        addMyObjective = findViewById(R.id.addMyMainObjectiveBut);
        dbHelper = new DBHelper(this);
        addMyObjective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = newObjective.getText().toString();
                ContentValues contentValues = new ContentValues();
                SQLiteDatabase database;
                        try {
                            database = dbHelper.getWritableDatabase();
                        } catch (SQLiteException ex) {
                            database = dbHelper.getReadableDatabase();
                        }


                        contentValues.put(DBHelper.OBJEKTIVES, task);
                        database.insert(DBHelper.TABLE_OBJECTIVE_TITLE, null, contentValues);

                        dbHelper.close();
                        Intent intentMain = new Intent(AddMainObjectiveActivity.this, ObjectiveActivity.class);
                        startActivity(intentMain);
            }
        });


    }
}
