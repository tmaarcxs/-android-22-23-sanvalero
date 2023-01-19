package com.svalero.mvc_netflix_1.controller;

import com.svalero.mvc_netflix_1.MainActivity;
import com.svalero.mvc_netflix_1.model.StudentWS;
import com.svalero.mvc_netflix_1.model.pojo.Student;

public class StudentController {
    private StudentWS model;
    private MainActivity view;

    public StudentController(StudentWS model, MainActivity view) {
        this.model = model;
        this.view = view;
    }

    public void getStudent(){
        //threads -> retrofit 2
        //iria a webservice rest y traeria los datos
       Student student = model.getStudentWS();
        view.printStudentDetails(student);
    }

    public void updateStudent(String name, String password){
        //threads -> retrofit 2
        //iria a webservice rest y traeria los datos
        Student student = model.getStudentWS();
        student.setName(name);
        student.setPassword(password);
    }
}
