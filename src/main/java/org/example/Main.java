package org.example;

import org.example.dao.StudentDao;
import org.example.model.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) {
        Student student=new Student();
        student.setName("Nihad");
        student.setSurname("Aliyev");
        student.setAge(20);
        student.setGrade(100);

        StudentDao studentDao=new StudentDao();
        studentDao.save(student);

    }
}