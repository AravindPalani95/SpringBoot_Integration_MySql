package com.altimetrik.ee.demo.service.impl;

import java.util.List;

import com.altimetrik.ee.demo.entity.Location;
import com.altimetrik.ee.demo.repository.LocationRepository;
import com.altimetrik.ee.demo.service.ILocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService{

    @Autowired
    private LocationRepository locationRepository;

	@Override
	public List<Location> getAllLocation() {
		return locationRepository.findAll();
	}
}
