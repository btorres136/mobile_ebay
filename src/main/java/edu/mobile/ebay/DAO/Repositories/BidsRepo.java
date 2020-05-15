package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mobile.ebay.DAO.Entities.Bids;

public interface BidsRepo extends JpaRepository<Bids, Long> {

    @Query(nativeQuery = true, value = "select * from bids where customerid = ?1")
    List<Bids> findBids(int costumerid);

    @Query(nativeQuery = true, value = "select MAX(bid_quantity) from bids where productsid = ?1")
    int getMaxId(String productid);
    @Query(nativeQuery = true, value = "select * from bids")
    List<Bids> findAllBids();
}