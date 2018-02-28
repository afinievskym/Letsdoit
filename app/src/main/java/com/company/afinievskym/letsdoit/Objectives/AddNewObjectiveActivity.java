package com.company.afinievskym.letsdoit.Objectives;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.company.afinievskym.letsdoit.DBHelper;
import com.company.afinievskym.letsdoit.R;

public class AddNewObjectiveActivity extends AppCompatActivity {
    EditText newObjective;
    Button addMyObjective;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_objective);
        //Находим элементы
        newObjective = findViewById(R.id.neweditObjective);
        addMyObjective = findViewById(R.id.addMyObjectiveBut);
        dbHelper = new DBHelper(this);
        // Работа с БД
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = newObjective.getText().toString();
                ContentValues contentValues = new ContentValues();
                SQLiteDatabase database;
                switch (view.getId()){
                    case R.id.addMyObjectiveBut:
                        try {
                            database = dbHelper.getWritableDatabase();
                        } catch (SQLiteException ex) {
                            database = dbHelper.getReadableDatabase();
                        }


                        contentValues.put(DBHelper.TABLE_NAME, task);

                        database.insert(DBHelper.TABLE_ADD_OBJECTIVE_TASK, null, contentValues);
                        dbHelper.close();
                        //Intent intentMain = new Intent(AddNewObjectiveActivity.this, MainDrawerAndTasks.class);
                        //startActivity(intentMain);

                }
            }
        };
          addMyObjective.setOnClickListener(onClickListener);
    }

}
