package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.ebay.DAO.Entities.Products;

public interface ProductsRepo extends JpaRepository<Products,Long>{
    


}