package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.RegistroActividad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoRegistroActividad extends JpaRepository<RegistroActividad,Long> {
    public List<RegistroActividad> findRegistroActividadByAlojamiento_Id(Long id);
}
