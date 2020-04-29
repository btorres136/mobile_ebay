package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import edu.mobile.ebay.DAO.Entities.Products;

public interface ProductsRepo extends JpaRepository<Products,Long>{
    

    @Query(nativeQuery = true, value = "select * from products")
    List<Products> findAllProducts();

    @Query(nativeQuery = true, value ="select * from products p, electronics_products ep, electronics e where p.productsid = ep.productsid and ep.electronicsid = e.electronicsid")
    List<Products> findAllElectronicProducts();

    @Query(nativeQuery = true, value = "select * from products p, sports_products sp, sports s where p.productsid = sp.productsid and sp.sportsid = s.sportsid")
    List<Products> findAllSportProducts();

    @Query(nativeQuery = true, value = "select * from products p, automotive_products ap, automotive a where p.productsid = ap.productsid and ap.automotiveid = a.automotiveid")
    List<Products> findAllAutomotiveProducts();
}