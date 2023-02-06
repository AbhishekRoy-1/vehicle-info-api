package io.nirmitee.roy.workshop.services;

import java.util.List;

import io.nirmitee.roy.workshop.entities.Vehicle;
import io.nirmitee.roy.workshop.payloads.VehicleDto;



public interface VehicleService {
	Vehicle createVehicle(Vehicle vehicle);
	VehicleDto updateVehicle(VehicleDto vehicleDto, Integer vId);
	Vehicle getVehicleById(Integer vId);
	List<Vehicle> getAllVehicle();
	void deleteVehicle(Integer vId);
	
	
}
