package com.altimetrik.ee.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.ee.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{
	
	public List<Item> findByRestaurantId(int restaurantId);
	
	public Optional<Item> findByItemIdAndRestaurantId(int itemId, int restaurantId);

}
