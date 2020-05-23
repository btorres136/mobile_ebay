package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.mobile.ebay.DAO.Entities.Products;

public interface ProductsRepo extends PagingAndSortingRepository<Products,Long>{

    Products findByproductsID(String Id);

    @Query(nativeQuery = true, value = "select * from products")
    List<Products> findAllAdmin();

    @Query(nativeQuery = true, value = "select * from products p, departments d where p.enable = 1 and end_bid > NOW() and p.department_id = d.department_id and d.enable = 1")
    List<Products> findAllProducts();

    @Query(nativeQuery = true, value="select * from products  p, departments d where title like ?1% and p.enable = 1 and end_bid > NOW() and p.department_id = d.department_id and d.enable = 1")
    List<Products> findProductByKeyWord(String search);

    @Query(nativeQuery = true, value="select * from products  p, departments d where p.title like ?1% and p.department_id = ?2 and p.enable = 1 and end_bid > NOW() and p.department_id = d.department_id and d.enable = 1")
    List<Products> findProductByKeyWordandDepartment(String search, int department);
    
    @Query(nativeQuery = true, value = "select * from products p, bids b where p.productsid = b.productsid and p.product_ownerid = ?1")
    List<Products> findProductOwnerPoductBidsByPorudctOwnerId(int search);

    @Query(nativeQuery = true, value = "select * from products p, departments d where p.department_id = ?1 and p.enable = 1 and end_bid > NOW() and p.department_id = d.department_id and d.enable = 1")
    List<Products> findProductbyDepartment(Long dep);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update products set enable = 0 where productsid = ?1")
    int disableproduct(String id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update products set enable = 1 where productsid = ?1")
    int enableproduct(String id);
}