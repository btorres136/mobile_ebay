package edu.mobile.ebay.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mobile.ebay.DAO.Entities.Automotive; 

public interface AutomotiveRepo extends JpaRepository<Automotive, Long> {
    /*@Query("")
    Automotive findbyID(@DateTimeFormat(style = "yyyy-mm-dd") Date )*/
}