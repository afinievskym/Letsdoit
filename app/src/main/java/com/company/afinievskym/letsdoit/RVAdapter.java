package com.company.afinievskym.letsdoit;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Programmer on 11.02.2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.TaskViewHolder> {
    ArrayList<String> AddedTasks;
    DBHelper dbHelper ;
    SQLiteDatabase database;
    Context context;

    RVAdapter(Context context){
        this.context = context;
        this.AddedTasks = db();
    }
    public ArrayList<String> db(){
        //Всегда getApplicationcontext() для баз данных!
        dbHelper = new DBHelper(context);
        ArrayList<String> dbHelpert = new ArrayList<String>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            //int idIndex = cursor.getColumnIndex(DBHelper.ID);
            int taskIndex = cursor.getColumnIndex(DBHelper.TASKS);
            do {
                        /*Log.d("myLog", "ID = " + cursor.getInt(idIndex) +
                                ", task = " + cursor.getString(taskIndex));*/
                dbHelpert.add(cursor.getString(taskIndex));
                Log.d("myLog", "Size =" + dbHelpert.size());
            } while (cursor.moveToNext());
        }
        return dbHelpert;
    }
    public class TaskViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView task;

        public TaskViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardview);
            task = itemView.findViewById(R.id.tasktitle);
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        //
        TaskViewHolder taskViewHolder = new TaskViewHolder(v);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder taskViewHolder , int position) {
        taskViewHolder.task.setText(AddedTasks.get(position));

    }

    @Override
    public int getItemCount() {
        return AddedTasks.size();
    }
}
