package com.company.afinievskym.letsdoit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Поля выдвижного экрана
    private String[] MyMenu;
    private ListView DrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Создание выдвижного меню
        MyMenu = getResources().getStringArray(R.array.MyMenu);
        DrawerLayout = findViewById(R.id.left_drawer);
        DrawerLayout.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item, MyMenu));
    }
}
