package com.company.afinievskym.letsdoit;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.company.afinievskym.letsdoit.Classes_for_Task.AddMainObjectiveActivity;
import com.company.afinievskym.letsdoit.Classes_for_Task.ObjectiveActivity;
import com.company.afinievskym.letsdoit.Classes_for_Task.RVAdapter;

public class MainDrawerAndTasks extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Подключаю классы
    AddNewTaskActivity addNewTaskActivity;
    public RVAdapter rvAdapter;

    //Поля главного экрана
    FloatingActionButton AddTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer_and_tasks);
        //Поля созданные изначально
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Кнопка Добавить задачу
        AddTask = (FloatingActionButton) findViewById(R.id.fab);
        AddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent task = new Intent(MainDrawerAndTasks.this, AddNewTaskActivity.class);
                startActivity(task);
            }
        });


        RecyclerView rv = (RecyclerView)findViewById(R.id.my_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        //Error NullPointer execption
        RVAdapter adapter = new RVAdapter(getApplicationContext());
        //end error
        rv.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_drawer_and_tasks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myListTaskMenuItem) {
            Intent mytasksIntent = new Intent();
        } else if (id == R.id.calendarMenuItem) {

        } else if (id == R.id.myTargetsMenuItem) {
            Intent myobjectivesintent = new Intent(MainDrawerAndTasks.this, ObjectiveActivity.class);
            startActivity(myobjectivesintent);
            /*android.support.v4.app.FragmentTransaction myobjectives = getSupportFragmentManager().beginTransaction();
            myobjectives.replace(R.id.container, new MyTargetsFragment());
            myobjectives.commit();*/

        } else if (id == R.id.achivmentsMenuItem) {


        } else if (id == R.id.notesMenuItem) {

        } else if (id == R.id.dailyIventsMenuItem) {

        }
        else if (id == R.id.settingsMenuItem) {

        }
        else if (id == R.id.manualMenuItem) {

        }
        else if (id == R.id.aboutDeveloperMenuItem) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
