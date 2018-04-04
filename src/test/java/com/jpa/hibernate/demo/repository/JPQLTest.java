package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void jpql_course_without_students() {

        TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Result -> {}", resultList);

    }

    @Test
    public void jpql_course_with_atleast_two_student() {

        TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Course with atleast two student - {}", resultList);
    }

    @Test
    public void jpql_course_ordered_by_student() {

        TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students)", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("jpql_course_ordered_by_student - {}", resultList);
    }

    @Test
    public void jpql_students_with_passport_in_certain_pattern() {

        TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%1234%' ", Student.class);
        List<Student> resultList = query.getResultList();

        logger.info("jpql_students_with_passport_in_certain_pattern - {}", resultList);
    }


    @Test
    public void join() {
        Query query = em.createQuery("select c,s from Course c join c.students s");
        List<Object[]> resultList = query.getResultList();      // JPA will return Array of Array as Object

        logger.info("Results - {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course - {}, Student - {}", result[0], result[1]);
        }
    }

    @Test
    public void leftJoin() {
        Query query = em.createQuery("select c,s from Course c left join c.students s");
        List<Object[]> resultList = query.getResultList();      // JPA will return Array of Array as Object

        logger.info("Results - {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course - {}, Student - {}", result[0], result[1]);
        }
    }

    @Test
    public void crossJoin() {
        Query query = em.createQuery("select c,s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();      // JPA will return Array of Array as Object

        logger.info("Results - {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course - {}, Student - {}", result[0], result[1]);
        }
    }

}
