package com.jdbc_crud.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer  {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phone_no;

    public Customer() {

    }

    public Customer(int id, String name, String email, String password, String phone_no) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_no = phone_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone_no='" + phone_no + '\'' +
                '}';
    }
}
