package com.bibliotheque.repository;

import com.bibliotheque.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource
@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNomContaining(String nom);
    Client findByPrenom(String prenom);
    Client findByEmail(String email);
}
