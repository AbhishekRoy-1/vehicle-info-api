package io.nirmitee.roy.workshop.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

	private String body;
	private String model;
	
	private Manufacturer manufacturer;
	private Integer numberOfDoors;
	private String fuelType;
	private String engine;
	private Integer mileage;
	private Integer modelYear;
	private Integer productionYear;
	private String externalColor;
	
	
}
