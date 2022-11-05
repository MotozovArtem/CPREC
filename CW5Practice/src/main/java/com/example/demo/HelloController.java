package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public ResponseEntity<String> hello(@RequestParam(value = "name", required = false) String name) {
		return new ResponseEntity<>(String.format("Hello, %s! Today is %s!", name,
				LocalDate.now().format(DateTimeFormatter.ISO_DATE)), HttpStatus.OK);
	}
}
