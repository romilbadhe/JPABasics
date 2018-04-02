package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Romil Badhe
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {


    @Autowired
    CourseRepository repository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById_basic() {
        logger.info("findById_basic is running");
        Course course = repository.findById(10001L);

        assertEquals("JPA in Basic Steps", course.getName());
        assertNotEquals("JPA in Steps", course.getName());

    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {

        logger.info("deleteById_basic is running");

        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void update_basic() {

        logger.info("save_basic is running");

        //retrieve the course
        Course course = repository.findById(1L);
        assertEquals("JUnit in Basic Steps", course.getName());

        //change the name of course
        course.setName("JUnit in Basic Steps - Updated");
        repository.save(course);
        assertNotEquals("JUnit in Basic Steps", course.getName());

        Course updateCourse = repository.findById(1L);

        logger.info("Updated Course -> {}", updateCourse);

    }


    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        repository.playWithEntityManager();
    }


}
