package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.controller.ManageAirlineController;
import com.example.repository.AirlineRepository;

import com.example.model.AirlineModel;

//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
class ApplicationTests {

	@Autowired
	private ManageAirlineController airlineController;

	@MockBean
	private AirlineRepository repository;

	@Test
	public void testAllAirlines() {
		Mockito.when(repository.findAll())
				.thenReturn(Arrays.asList(new AirlineModel(), new AirlineModel(), new AirlineModel()));
		List<AirlineModel> airline = airlineController.getAirlines();
		Assertions.assertSame(3, airline.size());
	}

	@Test
	public void saveAirlineTest() {
		AirlineModel airline = new AirlineModel();
		airline.setId(100);
		airline.setAirlinename("Spicejet");
		airline.setContactAddress("HelloAddress");
		airline.setContactNum("9933556758");
		airline.setLogo("test");
		Mockito.when(airlineController.saveAirline(Mockito.any())).thenReturn(airline);
		assertEquals(airline, airlineController.saveAirline(airline));
	}
	@Test
    public void testAirlinebyId() {
		AirlineModel airline = new AirlineModel();
		airline.setId(1);
		Optional<AirlineModel> optional = Optional.of(airline);
		Mockito.when(repository.findById(3)).thenReturn(optional);
		Assertions.assertSame(1, airline.getId());
    }
	/*
	 * @Test void contextLoads() { }
	 */

}
