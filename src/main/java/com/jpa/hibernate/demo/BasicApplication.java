package com.jpa.hibernate.demo;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Romil Badhe
 */

@SpringBootApplication
public class BasicApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        Course course = repository.findById(10001L);

        logger.info("Course 10001 -> {}", course);


        Course saveCourse = repository.save(new Course("JUnit in Basic Steps"));

        logger.info("New Course - > {}", saveCourse);

        repository.playWithEntityManager();

    }
}
