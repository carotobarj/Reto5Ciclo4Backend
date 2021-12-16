package com.sergioarboleda.cacharrero.app.repository.crud;

import com.sergioarboleda.cacharrero.app.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author Carotobarj
 */


public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
   
    /**
     * 
     * @param brand
     * @return 
     */
    
    public Optional<Clone> findByBrand(String brand);


    /**
     * 
     * @param price
     * @return 
     */
    
    
    public List<Clone> findByPrice(double price);
}