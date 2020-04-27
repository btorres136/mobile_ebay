package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.ebay.DAO.Entities.Electronics;

public interface ElectronicsRepo extends JpaRepository<Electronics, Long> {
    

}