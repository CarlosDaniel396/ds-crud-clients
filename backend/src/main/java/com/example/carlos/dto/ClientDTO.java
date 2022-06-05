package com.example.carlos.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;

import com.example.carlos.entities.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String cpf;
	private String email;
	private String address;
	private Long phoneNumber;
	private String gender;
	private Instant birthDate;

	public ClientDTO() {
	}

	public ClientDTO(Long id, String name, String cpf, String email, String address, Long phoneNumber, String gender,
			Instant birthDate) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		email = entity.getEmail();
		address = entity.getAddress();
		phoneNumber = entity.getPhoneNumber();
		gender = entity.getGender();
		birthDate = entity.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

}
