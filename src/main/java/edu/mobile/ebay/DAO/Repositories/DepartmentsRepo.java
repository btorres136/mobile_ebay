package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mobile.ebay.DAO.Entities.Departments;

public interface DepartmentsRepo extends JpaRepository<Departments, Long>{

    @Query(nativeQuery = true, value = "Select * from Departments")
    List<Departments> findalldepartments();

    
}