package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Course;
import com.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Romil Badhe
 */

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Course findById(Long id) {
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

    public void addReviewsForCourse() {

        // get the course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews ->  {}", course.getReviews());

        // add 2 reviews
        Review review1 = new Review("5", "Great hands on stuff");
        Review review2 = new Review("5", "Good going");

        // setting the relationships
        course.addReview(review1);
        review1.setCourse(course);

        // setting the relationships
        course.addReview(review2);
        review2.setCourse(course);

        // save it to database
        em.persist(review1);
        em.persist(review2);
    }


    public void addReviewsForCourseGeneric(Long courseId, List<Review> reviewList) {

        // get the course
        Course course = findById(courseId);
        logger.info("course.getReviews ->  {}", course.getReviews());

        // add reviews
        for (Review review : reviewList) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);     // save to db
        }
    }
}
