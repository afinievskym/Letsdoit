package com.company.afinievskym.letsdoit;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Подключаю классы
    DrawerItemClickListener drawerItemClickListener;
    //Поля главного экрана
    FloatingActionButton AddTask;
    //Поля выдвижного экрана
    public String[] MyMenu;
    public ListView DrawerLayout;
    //https://developer.android.com/training/material/lists-cards.html


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Создание выдвижного меню
        MyMenu = getResources().getStringArray(R.array.MyMenu);
        DrawerLayout = findViewById(R.id.left_drawer);
        DrawerLayout.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, MyMenu));
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
        //Работа с элементами выдвижного экрана
        DrawerLayout.setOnItemClickListener(new DrawerItemClickListener());
        //drawerItemClickListener.onItemClick(); Вызов метода из другого класса





    }

}
