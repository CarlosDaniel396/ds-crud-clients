package com.example.carlos.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
import com.example.carlos.services.exceptions.ResourceNotFoundException;
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

		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(client));
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());

		Mockito.when(repository.getReferenceById(existingId)).thenReturn(client);
		Mockito.when(repository.getReferenceById(nonExistingId)).thenReturn(client);
		Mockito.when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
		
		Mockito.when(repository.save(any())).thenReturn(client);
		

	}

	@Test
	public void findAllPagedShouldReturnPage() {

		Pageable pageable = PageRequest.of(0, 10);

		Page<ClientDTO> result = service.findAllPaged(pageable);

		Assertions.assertNotNull(result);
	}

	@Test
	public void findByIdShouldReturnClientDTOWhenIdExists() {

		ClientDTO result = service.findById(existingId);

		Assertions.assertNotNull(result);
	}

	@Test
	public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistingId);
		});
	}
	
	@Test
	public void updateShouldReturnClientDTOWhenIdExists() {

		ClientDTO result = service.update(existingId, clientDTO);

		Assertions.assertNotNull(result);
	}
	
	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(nonExistingId, clientDTO);
		});
	}
}
