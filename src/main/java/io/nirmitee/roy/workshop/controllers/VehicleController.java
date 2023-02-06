package io.nirmitee.roy.workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import io.nirmitee.roy.workshop.entities.Vehicle;
import io.nirmitee.roy.workshop.payloads.ApiResponse;
import io.nirmitee.roy.workshop.payloads.VehicleDto;
import io.nirmitee.roy.workshop.services.VehicleService;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
		Vehicle createdVehicle=this.vehicleService.createVehicle(vehicle);
		return new ResponseEntity<Vehicle>(createdVehicle,HttpStatus.OK);	
	}
	@GetMapping("/")
	public ResponseEntity<List<Vehicle>> getAllVehicles(){
		return ResponseEntity.ok(this.vehicleService.getAllVehicle());
		
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto, @PathVariable Integer Id){
		
		VehicleDto updateVehicle=this.vehicleService.updateVehicle(vehicleDto, Id);
		 return new ResponseEntity<VehicleDto>(updateVehicle,HttpStatus.OK);
	}
	
	@GetMapping("/{vId}")
	public ResponseEntity<Vehicle> getSingleUsers(@PathVariable Integer vId){
		return ResponseEntity.ok(this.vehicleService.getVehicleById(vId));
		
	}
	
	@DeleteMapping("/{vId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer vId){
		this.vehicleService.deleteVehicle(vId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully!", true),HttpStatus.OK);
		
	}

}
