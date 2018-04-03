package com.jpa.hibernate.demo;

import com.jpa.hibernate.demo.entity.Review;
import com.jpa.hibernate.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Romil Badhe
 */

@SpringBootApplication
public class BasicApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("5", "Great hands on stuff"));
        reviews.add(new Review("5", "Good going"));

        courseRepository.addReviewsForCourseGeneric(10003L, reviews);

    }
}
