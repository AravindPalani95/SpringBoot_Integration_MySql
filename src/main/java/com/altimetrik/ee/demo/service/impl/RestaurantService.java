package com.altimetrik.ee.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.entity.Item;
import com.altimetrik.ee.demo.entity.Restaurant;
import com.altimetrik.ee.demo.repository.ItemRepository;
import com.altimetrik.ee.demo.repository.RestaurantRepository;
import com.altimetrik.ee.demo.service.IRestaurantService;

@Service
public class RestaurantService implements IRestaurantService{
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    public List<Restaurant> findByLocation(int locationId){
        return restaurantRepository.findByLocationId(locationId);
    }
    
    public List<Restaurant> findByLocationAndPrice(int locationId,double price){
        return restaurantRepository.findByLocationIdAndMaxPrice(locationId, price);          
    }
    
    public List<Restaurant> findByLocationAndPriceAndRating(int locationId,double price, int rating){
        return restaurantRepository.findByLocationIdAndMaxPriceAndRating(locationId, price, rating);  
    }
    
    public List<Restaurant> findByLocationAndRating(int locationId,int rating){
        return restaurantRepository.findByLocationIdAndRating(locationId, rating); 
    }

	@Override
	public List<Item> findItemByRestaurantId(int restaurantId) {
		return itemRepository.findByRestaurantId(restaurantId);
	}

	@Override
	public Item updateItemPriceByResturantId(int restaurantId, int itemId, double itemPrice) {
		Optional<Item> item = itemRepository.findByItemIdAndRestaurantId(itemId,restaurantId);
		if(item.isPresent()) {
			Item itemObj = item.get();
			itemObj.setItemPrice(itemPrice);
			return itemRepository.save(itemObj);	
		}
		else
			return null;
		
	}
    
}
