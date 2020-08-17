package com.altimetrik.ee.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.altimetrik.ee.demo.entity.Item;
import com.altimetrik.ee.demo.entity.Location;
import com.altimetrik.ee.demo.entity.OrderSummary;
import com.altimetrik.ee.demo.entity.Restaurant;

@RequestMapping("/food")
public interface IFoodDeliveryController {
    
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Restaurant>> getRestaurants(@RequestParam("location_id") int location,
            @RequestParam("rating") Optional<Integer> rating, @RequestParam("price") Optional<Double> price);
            
    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Location>> getAllLocations();
    
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OrderSummary> saveOrder(@RequestBody OrderSummary orderSummary);
    
    @RequestMapping(value = "/getOrderSummary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OrderSummary> getOrderSummary(@RequestParam("order_id") int orderId);
    
    @RequestMapping(value = "/getItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Item>> getItems(@RequestParam("restaurant_id") int restaurantId);
    
    @RequestMapping(value = "/updateItemPrice/{restaurant_id}/{item_id}/{price}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Item> updateItemPrice(@RequestParam("restaurant_id") int restaurantId,
    		@RequestParam("item_id") int itemId, @RequestParam("item_price") double itemPrice);
    
}
