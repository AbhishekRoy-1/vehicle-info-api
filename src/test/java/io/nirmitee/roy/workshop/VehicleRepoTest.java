package io.nirmitee.roy.workshop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.nirmitee.roy.workshop.entities.Detail;
import io.nirmitee.roy.workshop.entities.Location;
import io.nirmitee.roy.workshop.entities.Manufacturer;
import io.nirmitee.roy.workshop.entities.Vehicle;
import io.nirmitee.roy.workshop.repositories.VehicleRepo;
@SpringBootTest
public class VehicleRepoTest {
	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Test
	void isVehicleExistById() {
		Vehicle vehicle=new Vehicle(1,"USED",new Detail("sedan","impala"
				,new Manufacturer((long) 101,"chevrolet"),4,"Gasoline","3.6l V6",
				32280,2018,2018,"white"
				),new Location(40.73061,-73.927645));
		vehicleRepo.save(vehicle);
		 Boolean actualResult=vehicleRepo.existsById(1);
		 assertThat(actualResult).isTrue();
	}

}
