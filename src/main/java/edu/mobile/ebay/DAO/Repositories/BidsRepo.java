package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.ebay.DAO.Entities.Bids;

public interface BidsRepo extends JpaRepository<Bids, Long> {

}