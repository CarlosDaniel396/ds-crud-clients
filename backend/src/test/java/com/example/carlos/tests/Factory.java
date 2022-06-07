package com.example.carlos.tests;

import java.time.Instant;

import com.example.carlos.dto.ClientDTO;
import com.example.carlos.entities.Client;

public class Factory {

	public static Client createClient() {
		Client client = new Client(1L, "Ana", "123465", "ana@gmail.com", "Rua tal, número 50", 99990000, "Female",
				Instant.parse("2020-10-20T03:00:00Z"));
		return client;
	}

	public static ClientDTO createClientDTO() {
		Client client = createClient();
		return new ClientDTO(client);
	}
}
