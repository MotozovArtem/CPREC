package io.rienel.cw6.server.controller;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import io.rienel.cw6.server.model.Client;
import io.rienel.cw6.server.repository.ClientRepository;
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
@RequestMapping("/api/v1/client")
public class ClientController {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@GetMapping("")
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@GetMapping("/{id}")
	public Client getClientById(@PathVariable("id") UUID id) {
		Objects.requireNonNull(id);
		return clientRepository.findById(id).orElse(null);
	}
}
