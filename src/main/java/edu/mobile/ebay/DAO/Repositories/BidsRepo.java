package edu.mobile.ebay.DAO.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mobile.ebay.DAO.Entities.Bids;

public interface BidsRepo extends JpaRepository<Bids, Long> {
    @Query(nativeQuery = true, value = "select * from bids where customerid = ?1")
    List<Bids> ListAllBidsFromCustomer(int customerid);
}