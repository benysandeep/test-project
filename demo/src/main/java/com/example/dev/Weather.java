package com.example.dev;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
@Document(collection="Weather")
public class Weather  {
	
	
	
	@NotNull
	String city;
	
	
	int temp;
	String country;
	String windSpeed;
	boolean rainy;

}
