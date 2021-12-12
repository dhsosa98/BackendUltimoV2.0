package com.example.Backend.Web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8081")
public class HelloWorld {

	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}
}