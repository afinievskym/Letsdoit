package com.company.afinievskym.letsdoit.Objectives;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.company.afinievskym.letsdoit.DBHelper;
import com.company.afinievskym.letsdoit.R;

import java.util.ArrayList;

/**
 * Created by Programmer on 19.02.2018.
 */

public class RVObjectiveAdapter extends RecyclerView.Adapter<RVObjectiveAdapter.TaskViewHolder> {
    public ArrayList<String> AddedObjective;
    DBHelper dbHelper ;
    SQLiteDatabase database;
    Context context;
    public RVObjectiveAdapter(Context context) {
        this.context = context;
        this.AddedObjective = db();
        for (int i = 0; i < AddedObjective.size(); i++) {
            Log.d("myLog", "ObjectivemainArray = " + AddedObjective.get(i));
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public ArrayList<String> db(){
        //Всегда getApplicationcontext() для баз данных!
        dbHelper = new DBHelper(context);
        ArrayList<String> dbHelperArray = new ArrayList<String>();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_OBJECTIVE_TITLE, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            //int idIndex = cursor.getColumnIndex(DBHelper.ID);
            int taskIndex = cursor.getColumnIndex(DBHelper.OBJEKTIVES);
            do {
                        Log.d("myLog", " objektives = " + cursor.getString(taskIndex));
                dbHelperArray.add(cursor.getString(taskIndex));
                Log.d("myLog", "Size =" + dbHelperArray.size());
                for (int i = 0; i < dbHelperArray.size(); i++) {
                    Log.d("myLog", "Elements = " + dbHelperArray.get(i));
                }
            } while (cursor.moveToNext());
        }
        cursor.close();

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
    public RVObjectiveAdapter.TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.objectivecard, parent, false);
        RVObjectiveAdapter.TaskViewHolder taskViewHolder = new RVObjectiveAdapter.TaskViewHolder(v);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(RVObjectiveAdapter.TaskViewHolder holder, int position) {
        holder.objektive.setText(AddedObjective.get(position));
    }

    @Override
    public int getItemCount() {return AddedObjective.size();}
}
