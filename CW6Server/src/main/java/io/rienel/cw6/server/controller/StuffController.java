package io.rienel.cw6.server.controller;

import java.util.List;
import java.util.UUID;

import io.rienel.cw6.server.model.Stuff;
import io.rienel.cw6.server.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO ArMotozov
 *
 * @since 11/16/2022
 */
@RestController
@RequestMapping("/api/v1/stuff")
public class StuffController {

	private final StuffRepository stuffRepository;

	@Autowired
	public StuffController(StuffRepository stuffRepository) {
		this.stuffRepository = stuffRepository;
	}

	@GetMapping("")
	public List<Stuff> getStuff() {
		return stuffRepository.findAll();
	}

	@GetMapping("/{id}")
	public Stuff getStuffById(@PathVariable("id") UUID id) {
		return stuffRepository.findById(id).orElse(null);
	}
}
