package com.example.carlos.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.carlos.dto.ClientDTO;
import com.example.carlos.entities.Client;
import com.example.carlos.repositories.ClientRepository;
import com.example.carlos.tests.Factory;

@ExtendWith(SpringExtension.class)
public class ClientServiceTests {

	@InjectMocks
	private ClientService service;

	@Mock
	private ClientRepository repository;

	private long existingId;
	private long nonExistingId;
	private Client client;
	private ClientDTO clientDTO;
	private PageImpl<Client> page;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 2L;
		client = Factory.createClient();
		clientDTO = Factory.createClientDTO();
		page = new PageImpl<>(List.of(client));

		Mockito.when(repository.findAll((Pageable) any())).thenReturn(page);
	}

	@Test
	public void findAllPagedShouldReturnPage() {

		Pageable pageable = PageRequest.of(0, 10);

		Page<ClientDTO> result = service.findAllPaged(pageable);

		Assertions.assertNotNull(result);
	}

}
