package com.jpa.hibernate.demo.repository;

import com.jpa.hibernate.demo.entity.Employee;
import com.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.jpa.hibernate.demo.entity.PartTimeEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager em;

    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    public void insert(Employee employee) {
        em.persist(employee);
    }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class)
                .getResultList();
    }


    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class)
                .getResultList();
    }


}
