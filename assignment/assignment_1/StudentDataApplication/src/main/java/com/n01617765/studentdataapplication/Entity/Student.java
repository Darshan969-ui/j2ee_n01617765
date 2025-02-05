package com.n01617765.studentdataapplication.Entity;

import java.time.LocalDate;

public class Student {
    private int ID;
    private String Name;
    private String Gender;
    private int Age;
    private String Email;
    private String City;
    private LocalDate DOB;

    public Student(){

    }
    public Student(int ID, String Name, String Gender, int Age, String Email, String City, LocalDate DOB) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.Age = Age;
        this.Email = Email;
        this.City = City;
        this.DOB = DOB;
    }
    // Getter and Setter for ID
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    // Getter and Setter for Name
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    // Getter and Setter for Gender
    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    // Getter and Setter for Age
    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    // Getter and Setter for City
    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    // Getter and Setter for DOB
    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}
