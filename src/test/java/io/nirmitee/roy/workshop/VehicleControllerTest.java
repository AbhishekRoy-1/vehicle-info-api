package io.nirmitee.roy.workshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import io.nirmitee.roy.workshop.controllers.VehicleController;
import io.nirmitee.roy.workshop.entities.Detail;
import io.nirmitee.roy.workshop.entities.Location;
import io.nirmitee.roy.workshop.entities.Manufacturer;
import io.nirmitee.roy.workshop.entities.Vehicle;
import io.nirmitee.roy.workshop.services.VehicleService;

@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VehicleService vehicleService;
	
	private Vehicle vehicle;
	@BeforeEach
	void setup() {
		vehicle=new Vehicle(1,"USED",new Detail("sedan","impala"
				,new Manufacturer((long) 101,"chevrolet"),4,"Gasoline","3.6l V6",
				32280,2018,2018,"white"
				),new Location(40.73061,-73.927645));
		Mockito.when(vehicleService.createVehicle(vehicle)).thenReturn(vehicle);
		
	}
	
	@Test
	public void testCreateVehicle() throws Exception {
		vehicle=new Vehicle(11,"USED",new Detail("sedan","impala"
				,new Manufacturer((long) 101,"chevrolet"),4,"Gasoline","3.6l V6",
				32280,2018,2018,"white"
				),new Location(40.73061,-73.927645));
		Mockito.when(vehicleService.createVehicle(vehicle)).thenReturn(vehicle);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/vehicle/").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "  \"v_id\": 1,\r\n"
						+ "  \"condition\": \"USED\",\r\n"
						+ "  \"details\": {\r\n"
						+ "    \"body\": \"sedan\",\r\n"
						+ "    \"model\": \"impala\",\r\n"
						+ "    \"manufacturer\": {\r\n"
						+ "      \"code\": 101,\r\n"
						+ "      \"name\": \"chevrolet\"\r\n"
						+ "    },\r\n"
						+ "    \"numberOfDoors\": 4,\r\n"
						+ "    \"fuelType\": \"Gasoline\",\r\n"
						+ "    \"engine\": \"3.6l V6\",\r\n"
						+ "    \"mileage\": 32280,\r\n"
						+ "    \"modelYear\": 2018,\r\n"
						+ "    \"productionYear\": 2018,\r\n"
						+ "    \"externalColor\": \"white\"\r\n"
						+ "  },\r\n"
						+ "  \"location\": {\r\n"
						+ "    \"lat\": 40.73061,\r\n"
						+ "    \"lon\": -73.927645\r\n"
						+ "  }\r\n"
						+ "}}")
				).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	
}
