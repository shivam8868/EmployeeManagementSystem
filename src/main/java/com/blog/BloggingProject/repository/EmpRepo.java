package com.blog.BloggingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.BloggingProject.entity.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {

}
