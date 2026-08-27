package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCliente extends JpaRepository<Cliente, Long> {
}
