package com.jpa.hibernate.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author Romil Badhe
 */

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

   /* public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            // insert
            em.persist(course);
        } else {
            // update
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {

        logger.info("playWithEntityManager - start");

        Course course1 = new Course("Web Services in Basic Steps");
        em.persist(course1);
        em.flush();     // push changes to db


        Course course2 = new Course("Angular 2 in Basic Steps");
        em.persist(course2);

        course2.setName("Angular 5 in Basic Steps - Updated");

        em.flush();     // push changes to db

        course1.setName("Web Services in Basic Steps - Updated");

        em.refresh(course1); // will query again to database

        System.out.println("Data in Course 1: " + course1.getName()); // Data in Course 1: Web Services in Basic Steps


        em.clear();     // wll clear every thing which is tracked by Entity Manager



    }
*/
}
