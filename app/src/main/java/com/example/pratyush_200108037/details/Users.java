package com.example.pratyush_200108037.details;

public class Users {

        String name, college, course, year, roll , emailid , phoneno , pass;

    public Users(String name, String college, String course, String year, String roll, String emailid, String phoneno, String pass, String id) {
        this.name = name;
        this.college = college;
        this.course = course;
        this.year = year;
        this.roll = roll;
        this.emailid = emailid;
        this.phoneno = phoneno;
        this.pass = pass;
    }


    public Users(){}

    public Users(String name, String college, String course, String year, String roll, String emailid, String phoneno, String pass) {
        this.name = name;
        this.college = college;
        this.course = course;
        this.year = year;
        this.roll = roll;
        this.emailid = emailid;
        this.phoneno = phoneno;
        this.pass = pass;
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
