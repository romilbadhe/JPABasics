package com.jpa.hibernate.demo.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    // mappedBy makes Student the owing side of relationship
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    protected Passport() {
    }

    public Passport(String name) {
        this.number = name;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }


}