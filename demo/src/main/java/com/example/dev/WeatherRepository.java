package com.example.dev;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface WeatherRepository extends MongoRepository<Weather,String>{
	
	 @Query("{City:'?0'}")
	 Weather findItemByCity(String City);


}
