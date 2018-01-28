package com.company.afinievskym.letsdoit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewTaskActivity extends AppCompatActivity {
    EditText newTask;
    Button addMyTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        newTask = findViewById(R.id.newTask);
        addMyTask = findViewById(R.id.AddMyTask);
        addMyTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
