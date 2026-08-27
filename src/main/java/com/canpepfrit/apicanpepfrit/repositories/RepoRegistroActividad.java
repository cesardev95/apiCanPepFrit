package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RepoRegistroActividad extends JpaRepository<RegistroActividad, Long> {
    List<RegistroActividad> findRegistroActividadByAlojamiento_Id(Long id);
}
