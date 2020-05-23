package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.mobile.ebay.DAO.Entities.Customers;
import edu.mobile.ebay.DAO.Entities.ProductOwners;

public interface ProductOwnersRepo extends JpaRepository<ProductOwners, Long>{

    boolean existsByCustomerID(Customers id);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update product_owners set enable = 0 where product_ownerid = ?1")
    int disableproductowner(Long procudtownerid);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update product_owners set enable = 1 where product_ownerid = ?1")
	int enableproductowner(Long productownerid);
	

}
