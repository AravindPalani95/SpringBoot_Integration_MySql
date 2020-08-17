package com.altimetrik.ee.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.ee.demo.entity.Item;
import com.altimetrik.ee.demo.entity.Location;
import com.altimetrik.ee.demo.entity.OrderSummary;
import com.altimetrik.ee.demo.entity.Restaurant;
import com.altimetrik.ee.demo.service.ILocationService;
import com.altimetrik.ee.demo.service.IOrderService;
import com.altimetrik.ee.demo.service.IRestaurantService;

import io.swagger.annotations.Api;

@Api(tags = "Food Delivery Services")
@RestController
public class FoodDeliveryController implements IFoodDeliveryController{

    @Autowired
    private ILocationService locationService;
    
    @Autowired
    private IRestaurantService restaurantService;
    
    @Autowired
    private IOrderService orderService;
    
	@Override
	public ResponseEntity<List<Restaurant>> getRestaurants(int locationId, Optional<Integer> rating,
			Optional<Double> price) {
			    if(rating.isPresent() && price.isPresent()){
			        return new ResponseEntity<List<Restaurant>>(restaurantService.findByLocationAndPriceAndRating(locationId,
			        price.get(),rating.get()),HttpStatus.OK);
			    }
			    else if(rating.isPresent()){
			        return new ResponseEntity<List<Restaurant>>(restaurantService.findByLocationAndRating(locationId,rating.get()),HttpStatus.OK);
			    }
			    else if(price.isPresent()){
			        return new ResponseEntity<List<Restaurant>>(restaurantService.findByLocationAndPrice(locationId,price.get()),HttpStatus.OK);
			    }
			    else
			    {
			        return new ResponseEntity<List<Restaurant>>(restaurantService.findByLocation(locationId),HttpStatus.OK);
			    }
	}

	@Override
	public ResponseEntity<List<Location>> getAllLocations() {
		return new ResponseEntity<List<Location>>(locationService.getAllLocation(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<OrderSummary> getOrderSummary(int orderId) {
		return new ResponseEntity<OrderSummary>(orderService.getOrderSummary(orderId),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<OrderSummary> saveOrder(@RequestBody OrderSummary orderSummary) {
		return new ResponseEntity<OrderSummary>(orderService.saveOrderSummary(orderSummary),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Item>> getItems(int restaurantId) {
		return new ResponseEntity<List<Item>>(restaurantService.findItemByRestaurantId(restaurantId),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Item> updateItemPrice(int restaurantId, int itemId, double itemPrice) {
		return new ResponseEntity<Item>(restaurantService.updateItemPriceByResturantId(restaurantId,itemId,itemPrice),HttpStatus.OK);
	}

	
}
