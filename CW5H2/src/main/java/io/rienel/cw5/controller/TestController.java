package io.rienel.cw5.controller;

import java.util.List;

import io.rienel.cw5.model.Test;
import io.rienel.cw5.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

	private final TestRepository repository;

	@Autowired
	public TestController(TestRepository repository) {
		this.repository = repository;
		repository.save(new Test(1, "Test"));
	}

	@GetMapping("test")
	public List<Test> test() {
		return repository.findAll();
	}
}
