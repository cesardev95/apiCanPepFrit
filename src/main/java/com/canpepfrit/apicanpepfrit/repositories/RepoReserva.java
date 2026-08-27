package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository

public interface RepoReserva extends JpaRepository<Reserva, Long> {

    //Query para mostrar las reservas en este mes
    @Query("SELECT r FROM Reserva r WHERE r.fechaInicio <= :ultimoDiaMes AND r.fechaFinal >= :primerDiaMes")
    List<Reserva> findReservaByDate(@Param("primerDiaMes") LocalDate primerDiaMes,@Param("ultimoDiaMes") LocalDate ultimoDiaMes);

    List<Reserva> findReservaByCliente_Nombre(String clienteNombre);

    @Query("SELECT r from Reserva r WHERE r.fechaInicio<= :fechaIntroducida")
    List<Reserva> findReservaByFechaInicio(@Param("fechaIntroducida") LocalDate fechaIntroducida);




}
