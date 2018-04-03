package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author Romil Badhe
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {

        logger.info("retrieveStudentAndPassportDetails test is running");
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());

    }

}
