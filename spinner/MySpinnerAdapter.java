package com.example.spinner;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class MySpinnerAdapter implements SpinnerAdapter {

    private List<Student> studentList;
    private Context context;
    public MySpinnerAdapter(Context context,List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.drop_row,viewGroup,false);

        TextView tvID = view.findViewById(R.id.tvId);
        TextView tvName = view.findViewById(R.id.tvName);

        tvID.setText(studentList.get(i).getId()+"");
        tvName.setText(studentList.get(i).getName()+"");
        return view;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }



    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentList.get(i);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.select_row,viewGroup,false);

        TextView tvID = view.findViewById(R.id.tvId);
        TextView tvName = view.findViewById(R.id.tvName);

        tvID.setText(studentList.get(i).getId()+"");
        tvName.setText(studentList.get(i).getName()+"");

        return view;
    }





    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }



    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public int getItemViewType(int i) {
        return 0;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }
}
