package org.example.model;

public class Student {
    private String name;
    private String surname;
    private int age;
    private int grade;

    public Student(String name, String surname, int age, int grade) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grade = grade;
    }

    public Student() {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
