package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.ebay.DAO.Entities.Customers;

public interface CustomersRepo extends JpaRepository<Customers, Long>{

}