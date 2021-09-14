package com.bingo.room2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ing on 2021/9/14
 */
public class StudentRecyclerViewAdapter extends RecyclerView.Adapter {
    List<Student> students;
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentRecyclerViewAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);
        TextView tvId = holder.itemView.findViewById(R.id.id);
        tvId.setText(String.valueOf(student.id));
        TextView tvName = holder.itemView.findViewById(R.id.name);
        tvName.setText(String.valueOf(student.name));
        TextView tvAge = holder.itemView.findViewById(R.id.age);
        tvAge.setText(String.valueOf(student.age));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View root) {
            super(root);
        }
    }
}
