package com.company.afinievskym.letsdoit.Classes_for_Task;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.company.afinievskym.letsdoit.DBHelper;
import com.company.afinievskym.letsdoit.R;

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
        ArrayList<String> dbHelperArray = new ArrayList<String>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            //int idIndex = cursor.getColumnIndex(DBHelper.ID);
            int taskIndex = cursor.getColumnIndex(DBHelper.TASKS);
            do {
                        /*Log.d("myLog", "ID = " + cursor.getInt(idIndex) +
                                ", task = " + cursor.getString(taskIndex));*/
                dbHelperArray.add(cursor.getString(taskIndex));
                Log.d("myLog", "Size =" + dbHelperArray.size());
            } while (cursor.moveToNext());
        }
        return dbHelperArray;
    }
    public class TaskViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView objektive;


        public TaskViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.objektiveCardview);
            objektive = itemView.findViewById(R.id.objectiveText);
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
        taskViewHolder.objektive.setText(AddedTasks.get(position));

    }

    @Override
    public int getItemCount() {
        return AddedTasks.size();
    }
}
