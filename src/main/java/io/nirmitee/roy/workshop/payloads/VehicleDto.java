package io.nirmitee.roy.workshop.payloads;

import io.nirmitee.roy.workshop.entities.Detail;
import io.nirmitee.roy.workshop.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDto {
	private Integer v_id;
	
	private String condition;

	private Detail details;
	
	private Location location;
	
}
