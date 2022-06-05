package com.example.carlos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.carlos.dto.ClientDTO;
import com.example.carlos.entities.Client;
import com.example.carlos.repositories.ClientRepository;
import com.example.carlos.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable) {
		Page<Client> list = repository.findAll(pageable);
		return list.map(x -> new ClientDTO(x));
	}

	

}
