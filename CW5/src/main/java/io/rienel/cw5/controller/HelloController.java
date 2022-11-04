package io.rienel.cw5.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HelloController {

	@GetMapping("hello")
	public ResponseEntity<String> hello(@RequestParam("name") String name) {
		Objects.requireNonNull(name);
		return new ResponseEntity<>(String.format("Hello %s! Today is %s!", name, LocalDate.now().format(DateTimeFormatter.ISO_DATE)), HttpStatus.OK);
	}

}
