package com.example.dev;

import java.io.FileNotFoundException;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
@Validated
@Component
public class ReactiveController {
	
	@Autowired
	WeatherRepository weatherRepo;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@RequestMapping(path = "/weather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Weather> getCityWeather(
			@NotEmpty @RequestParam(name = "City", defaultValue = "Jaipur") String City) {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(weatherRepo.findItemByCity(City));

	}

	@GetMapping(path = "/weatherDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Weather> getCityWeatherDetails(@QueryParam(value = "City") String City) {
		if (City == null) {
			throw new CustomException();
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(Weather.builder().city(City).country("India").windSpeed("11 mph").build());
	}

	@GetMapping(path = "/Weather", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Weather> getDetails(@RequestParam(name = "City") String City) {
		try {
		if(City==null) {
			throw new FileNotFoundException();
		}
		if(City.equalsIgnoreCase("Gurgaon")) {
			throw new NullPointerException();
		}} catch(FileNotFoundException | NullPointerException n) {
			n.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(Weather.builder().city(City).build());

	}

	@PostMapping(path = "/WeatherUpdate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Weather> updateDetails(@RequestBody Weather weather) {
		kafkaTemplate.send("weather",weather);
		//weatherRepo.save(weather);
		return ResponseEntity.status(HttpStatus.OK).body(weather);

	}
	
	

}
