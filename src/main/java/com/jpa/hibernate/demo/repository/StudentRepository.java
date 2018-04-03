package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Passport;
import com.jpa.hibernate.demo.entity.Student;
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
public class StudentRepository {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            // insert
            em.persist(student);
        } else {
            // update
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }


    public void saveStudentWithPassport() {

        Passport passport = new Passport("XZ2122");
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(passport);
        em.persist(student);
    }
}
