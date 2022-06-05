package com.example.carlos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carlos.dto.ClientDTO;
import com.example.carlos.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
		Page<ClientDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

}
