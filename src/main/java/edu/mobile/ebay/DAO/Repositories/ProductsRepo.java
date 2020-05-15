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

    @Query(nativeQuery = true, value="select * from products where title like ?1%")
    List<Products> findProductByKeyWord(String search);
    
    @Query(nativeQuery = true, value = "select * from products p, bids b where p.productsid = b.productsid and p.product_ownerid = ?1")
    List<Products> findProductOwnerPoductBidsByPorudctOwnerId(int search);

    @Query(nativeQuery = true, value = "select * from products where department_id = ?1")
    List<Products> findProductbyDepartment(Long dep);
}