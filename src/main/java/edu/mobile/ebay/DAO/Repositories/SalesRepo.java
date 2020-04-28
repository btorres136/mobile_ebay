package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.ebay.DAO.Entities.Sales;

public interface SalesRepo extends JpaRepository<Sales, Long>{

}