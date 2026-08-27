package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepoEmpleado extends JpaRepository<Empleado, Long> {
}
