package com.example.dev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	String type;
	String line1;
	String city;
	String zip;
	String country;
	
	

}
