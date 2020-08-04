package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.mobile.ebay.DAO.Entities.Departments;

public interface DepartmentsRepo extends JpaRepository<Departments, Long>{

    @Query(nativeQuery = true, value = "Select * from Departments where enable = 1")
    List<Departments> findalldepartments();

    @Query(nativeQuery = true, value = "Select * from Departments where department_id = ?1 and enable = 1")
    Departments finddepartments(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update departments set enable = 0 where department_id = ?1")
    int disabledepartment(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update departments set enable = 1 where department_id = ?1")
    int enabledepartment(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update departments set department_name = ?1 where department_id = ?2")
    int changedepartmentname(String newdepartment_name, Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update departments set description = ?1 where department_id = ?2")
    int changedepartmentdescription(String newdepartment_description, Long id);




    
}
