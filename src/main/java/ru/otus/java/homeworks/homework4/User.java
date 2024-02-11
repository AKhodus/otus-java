package ru.otus.java.homeworks.homework4;

public class User {
    private String firstName;
    private String lastName;
    private String surName;
    private int yearOfBirth;
    private String email;

    public User(String firstName, String lastName, String surName, int yearOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void userInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + surName + "\n" + "Год рождения: " + yearOfBirth + "\n" + "e-mail: " + email);
    }
}
