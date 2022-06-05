package com.example.carlos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carlos.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}