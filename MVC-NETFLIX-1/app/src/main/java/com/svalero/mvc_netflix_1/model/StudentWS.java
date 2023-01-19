package com.svalero.mvc_netflix_1.model;

import com.svalero.mvc_netflix_1.model.pojo.Student;

public class StudentWS {
    private Student student;

    public Student getStudentWS() {
        student = new Student();
        student.setName("Perico");
        student.setSurname("Valero");
        return student;
    }
}
