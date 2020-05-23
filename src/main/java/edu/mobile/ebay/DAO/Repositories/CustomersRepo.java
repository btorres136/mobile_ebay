package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.mobile.ebay.DAO.Entities.Customers;

public interface CustomersRepo extends JpaRepository<Customers, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Customers,Product_Owners where Customers.customerid = Product_Owners.customerid")
    List<Customers> findCustomerandProductOwner();

    @Query(nativeQuery = true, value = "select * from customers")
    List<Customers> findAllCustomers();

    boolean existsByCustomerID(String id);
    
    Customers findByCustomerID(String id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update customers set enable = 0 where customerid = ?1")
    int disablecustomer(String id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update customers set enable = 1 where customerid = ?1")
    int enablecustomer(String id);
}