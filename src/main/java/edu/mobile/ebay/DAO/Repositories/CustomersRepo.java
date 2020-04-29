package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mobile.ebay.DAO.Entities.Customers;

public interface CustomersRepo extends JpaRepository<Customers, Long>{

    @Query(nativeQuery = true, value = "SELECT * FROM Customers,Product_Owners where Customers.customerid = Product_Owners.customerid")
    List<Customers> findCustomerandProductOwner();
    
    
}