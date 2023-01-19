package com.svalero.mvc_netflix_1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.mvc_netflix_1.controller.StudentController;
import com.svalero.mvc_netflix_1.model.StudentWS;
import com.svalero.mvc_netflix_1.model.pojo.Student;

public class MainActivity extends AppCompatActivity {
    private StudentController controller;
    private MainActivity view;
    private StudentWS model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // cargar vista
        view = this;
        //model + view
        controller = new StudentController(model, view);
        //caso de uso -> getStudent
        controller.getStudent();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            //pasar datos de los campos de texto segun el contenido de los campos de texto
            TextView name = (TextView) findViewById(R.id.editTextTextPersonName);
            String nameStr = name.getText().toString();
            TextView password = (TextView) findViewById(R.id.editTextTextPassword);
            String passwordStr = password.getText().toString();
            controller.updateStudent(nameStr, passwordStr);
        });
    }


    public void printStudentDetails(Student student) {
        Log.d("MainActivity - NAME", student.getName());
        Log.d("MainActivity - SURNAME", student.getSurname());
    }
}