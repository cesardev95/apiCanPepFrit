package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoReserva extends JpaRepository<Reserva, Long> {
}
