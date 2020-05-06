package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import edu.mobile.ebay.DAO.Entities.Products;

public interface ProductsRepo extends PagingAndSortingRepository<Products,Long>{

    Products findByproductsID(String Id);

    @Query(nativeQuery = true, value = "select * from products")
    Page<Products> findAllProducts(Pageable pageable);

    @Query(nativeQuery = true, value ="select * from products p, electronics_products ep, electronics e where p.productsid = ep.productsid and ep.electronicsid = e.electronicsid")
    List<Products> findAllElectronicProducts();

    @Query(nativeQuery = true, value = "select * from products p, sports_products sp, sports s where p.productsid = sp.productsid and sp.sportsid = s.sportsid")
    List<Products> findAllSportProducts();

    @Query(nativeQuery = true, value = "select * from products p, automotive_products ap, automotive a where p.productsid = ap.productsid and ap.automotiveid = a.automotiveid")
    List<Products> findAllAutomotiveProducts();

    @Query(nativeQuery = true, value="select * from products where title like ?1%")
    List<Products> findProductByKeyWord(String search);

    @Query(nativeQuery = true, value ="select * from products p, electronics_products ep, electronics e where p.productsid = ep.productsid and ep.electronicsid = e.electronicsid and p.title like ?1%")
    List<Products> findElectronicProductsByKeyWord(String search);

    @Query(nativeQuery = true, value = "select * from products p, sports_products sp, sports s where p.productsid = sp.productsid and sp.sportsid = s.sportsid and p.title like ?1%")
    List<Products> findSportProductsByKeyWord(String search);

    @Query(nativeQuery = true, value = "select * from products p, automotive_products ap, automotive a where p.productsid = ap.productsid and ap.automotiveid = a.automotiveid and p.title like ?1%")
    List<Products> findAutomotiveProductsByKeyWord(String search);  
    
    @Query(nativeQuery = true, value = "select * from products p, bids b where p.productsid = b.productsid and p.product_ownerid = ?1")
    List<Products> findProductOwnerPoductBidsByPorudctOwnerId(int search);
}