package com.company.afinievskym.letsdoit;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Поля главного экрана
    FloatingActionButton AddTask;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //Поля выдвижного экрана
    private String[] MyMenu;
    private ListView DrawerLayout;
    //https://developer.android.com/training/material/lists-cards.html


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Создание выдвижного меню
        MyMenu = getResources().getStringArray(R.array.MyMenu);
        DrawerLayout = findViewById(R.id.left_drawer);
        DrawerLayout.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item, MyMenu));
        //Кнопка Добавить задачу
        AddTask = findViewById(R.id.AddTask);
        AddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent task = new Intent(MainActivity.this, AddNewTaskActivity.class);
                startActivity(task);
            }
        });
        //Создание RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        //Ошибка - на сайте дополнительный код для исправления
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);



    }
}
