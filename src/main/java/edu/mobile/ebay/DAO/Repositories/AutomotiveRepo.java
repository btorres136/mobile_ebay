package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.ebay.DAO.Entities.Automotive;

public interface AutomotiveRepo extends JpaRepository<Automotive, Long> {
    

}