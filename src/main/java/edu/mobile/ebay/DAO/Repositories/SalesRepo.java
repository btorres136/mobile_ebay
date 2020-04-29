package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mobile.ebay.DAO.Entities.Sales;

public interface SalesRepo extends JpaRepository<Sales, Long>{

    @Query(nativeQuery = true, value="select * from sales s, products p, bids b where s.buyer_customerid = ?1 and s.selled_product_productsid = p.productsid and p.productsid = b.productsid")
    List<Sales> findSalesByCustomerID(int customerid);
}