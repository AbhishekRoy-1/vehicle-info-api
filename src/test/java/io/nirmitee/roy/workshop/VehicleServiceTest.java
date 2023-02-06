package io.nirmitee.roy.workshop;





import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import io.nirmitee.roy.workshop.entities.Detail;
import io.nirmitee.roy.workshop.entities.Location;
import io.nirmitee.roy.workshop.entities.Manufacturer;
import io.nirmitee.roy.workshop.entities.Vehicle;
import io.nirmitee.roy.workshop.repositories.VehicleRepo;
import io.nirmitee.roy.workshop.services.VehicleService;
@SpringBootTest
public class VehicleServiceTest {
	@MockBean
	private VehicleRepo vehicleRepo;
	
	@Autowired
	private VehicleService vehicleService;
	
	@BeforeEach
	void setup() {
		Optional<Vehicle> vehicleOptional=Optional.of(new Vehicle(11,"USED",new Detail("sedan","impala"
				,new Manufacturer((long) 1101,"chevrolet"),4,"Gasoline","3.6l V6",
				32280,2018,2018,"white"
				),new Location(40.73061,-73.927645)));
		Mockito.when(vehicleRepo.findById(11)).thenReturn(vehicleOptional);
	}
	@Test
	public void getVehicleById_success() {
		Vehicle vehicle=new Vehicle(11,"USED",new Detail("sedan","impala"
				,new Manufacturer((long) 1101,"chevrolet"),4,"Gasoline","3.6l V6",
				32280,2018,2018,"white"
				),new Location(40.73061,-73.927645));
		Vehicle vehicleSearch=vehicleService.getVehicleById(11);
		assertEquals(vehicleSearch,vehicle);
		
		
	}
			


	
	

}
