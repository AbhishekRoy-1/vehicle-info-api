package io.nirmitee.roy.workshop.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nirmitee.roy.workshop.entities.Vehicle;
import io.nirmitee.roy.workshop.exceptions.ResourceNotFoundException;
import io.nirmitee.roy.workshop.payloads.VehicleDto;
import io.nirmitee.roy.workshop.repositories.VehicleRepo;
import io.nirmitee.roy.workshop.services.VehicleService;
import lombok.AllArgsConstructor;
@Service

public class VehicleServiceImpl implements VehicleService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private VehicleRepo vehicleRepo;
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		
		return this.vehicleRepo.save(vehicle);
	}

	@Override
	public VehicleDto updateVehicle(VehicleDto vehicleDto, Integer vId) {
		Vehicle vehicle=this.vehicleRepo.findById(vId)
				.orElseThrow(()-> new ResourceNotFoundException("Vehicle", "Vehicle Id", vId));
		vehicle.setCondition(vehicleDto.getCondition());
		vehicle.setDetails(vehicleDto.getDetails());
		vehicle.setLocation(vehicleDto.getLocation());
		Vehicle updatedVehicle=this.vehicleRepo.save(vehicle);
		return this.modelMapper.map(updatedVehicle, VehicleDto.class);
		
	}

	@Override
	public Vehicle getVehicleById(Integer vId) {
		Vehicle vehicle=this.vehicleRepo.findById(vId)
				.orElseThrow(()->new ResourceNotFoundException("Vehicle", "Vehicle Id", vId));
		return vehicle;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicleRepo.findAll().forEach(vehicle ->vehicles.add(vehicle));
		return vehicles;
	}


	@Override
	public void deleteVehicle(Integer vId) {
		Vehicle vehicle= this.vehicleRepo.findById(vId)
				.orElseThrow(()->new ResourceNotFoundException("Vehicle", "Vehicle Id", vId));
		this.vehicleRepo.delete(vehicle);
		
	}

}
