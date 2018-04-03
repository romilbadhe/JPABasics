package com.jpa.hibernate.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // Always Lazy Fetching
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public List<Review> getReviews() {
        return reviews;
    }


    // add review one at a time
    public void addReview(Review review) {
        this.reviews.add(review);
    }

    // remove review one at a time
    public void removeReview(Review review) {
        this.reviews.remove(review);
    }


    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }


}