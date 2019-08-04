package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private Spinner spStudent;
    private List<Student> studentList;
    private Button btnSelectItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Radiation();
        CreateAdapter();
        Event();
    }

    private void Event() {
        spStudent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,studentList.get(i).getName()+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSelectItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student =(Student) spStudent.getSelectedItem();
                Toast.makeText(MainActivity.this,student.getName()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CreateAdapter() {
        //create one object fake do select default
        studentList = new ArrayList<>();
        Student studentFake = new Student("--Vui Lòng "," Lựa Chọn--");
        studentList.add(0,studentFake);

        for (int i = 0; i < 20; i++) {
            Student student = new Student(""+i,"Khuong "+i);
            studentList.add(student);
        }

        MySpinnerAdapter adapter = new MySpinnerAdapter(MainActivity.this,studentList);
        spStudent.setAdapter(adapter);
    }

    private void Radiation() {
        spStudent = findViewById(R.id.spStudent);
        btnSelectItem = findViewById(R.id.btnShowItem);
    }
}
