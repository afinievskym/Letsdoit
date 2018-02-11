package com.company.afinievskym.letsdoit;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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
    AddNewTaskActivity addNewTaskActivity;
    public ArrayList<String> alltasks;
    public class TaskViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView task;

        public TaskViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardview);
            task = itemView.findViewById(R.id.tasktitle);
        }
    }
    RVAdapter(ArrayList<String> allofmytasks){
        this.alltasks = allofmytasks;
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
        taskViewHolder.task.setText(addNewTaskActivity.myAddedTasks.get(position));

    }

    @Override
    public int getItemCount() {
        return addNewTaskActivity.myAddedTasks.size();
    }
}
