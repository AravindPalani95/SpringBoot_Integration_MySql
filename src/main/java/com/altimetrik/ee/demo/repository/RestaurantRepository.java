package com.altimetrik.ee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.altimetrik.ee.demo.entity.Restaurant;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{
    
    public List<Restaurant> findByLocationId(int locationId);
    
    public List<Restaurant> findByLocationIdAndMaxPrice(int locationId,double price);
    
    public List<Restaurant> findByLocationIdAndRating(int locationId,int rating);
    
    public List<Restaurant> findByLocationIdAndMaxPriceAndRating(int locationId,double price, int rating);
    
}
