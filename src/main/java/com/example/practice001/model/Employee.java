package com.example.practice001.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee" )
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender", length = 7)
    private String gender;

    @Column(name = "email", unique = true)
    private String email;

    public Employee(){
    }
    public Employee(String name, String gender, String email){
        this.name=name;
        this.gender=gender;
        this.email=email;
    }

    public Employee(Long id, String name, String gender, String email) {
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.email=email;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
