package com.example.dev;

import javax.validation.constraints.Pattern;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class UserDetailsController {
	//http://localhost:8080/employee/xyz/id
	//Path variable from uri path
	@GetMapping(path="xyz/{Id}",produces=MediaType.APPLICATION_JSON)
	public int findUserId(@PathVariable(value = "Id") String id) {
		
		return 0;
	}
	//http://localhost:8080/employee/xyz?id=abc
	//Request param from query string
	@PostMapping(path="/Id",produces=MediaType.APPLICATION_JSON)
	public int UpdateUserId(@RequestParam(value = "Id")@Pattern(regexp = "[a-zA-Z0-9] {3}") String id) {
		
		return 0;
	}
	
	@GetMapping(path="rtp/{Id})",produces=MediaType.APPLICATION_JSON)
	public int findDetail(@PathVariable(value="id") String id) {
		return 0;
	}
	
	@GetMapping(path="rtp/Id)",produces=MediaType.APPLICATION_JSON)
	public int findDetails(@RequestParam(value="id") String id) {
		return 0;
	}

}
