package com.altimetrik.ee.demo.service;

import java.util.List;

import com.altimetrik.ee.demo.entity.Item;
import com.altimetrik.ee.demo.entity.Restaurant;

public interface IRestaurantService {
    
    public List<Restaurant> findByLocation(int locationId);
    
    public List<Restaurant> findByLocationAndPrice(int locationId,double price);
    
    public List<Restaurant> findByLocationAndRating(int locationId,int rating);
    
    public List<Restaurant> findByLocationAndPriceAndRating(int locationId,double price, int rating);
    
    public List<Item> findItemByRestaurantId(int restaurantId);
    
    public Item updateItemPriceByResturantId(int restaurantId, int itemId, double itemPrice);
}
