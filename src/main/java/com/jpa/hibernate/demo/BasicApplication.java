package com.jpa.hibernate.demo;

import com.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.jpa.hibernate.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BasicApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("100000")));

        logger.info("All Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());
        logger.info("All Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
	}
}
