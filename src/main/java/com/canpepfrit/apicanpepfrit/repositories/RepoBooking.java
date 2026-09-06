package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository

public interface RepoBooking extends JpaRepository<Booking, Long> {

    //Query para mostrar las reservas en este mes
    @Query("SELECT b FROM Booking b WHERE b.startDate <= :lastMonthDay AND b.endDate >= :firstMonthDay")
    List<Booking> findBookingByDate(@Param("firstMonthDay") LocalDate firstMonthDay, @Param("lastMonthDay") LocalDate lastMonthDay);

    List<Booking> findBookingByClientName(String clientName);

    @Query("SELECT b from Booking b WHERE b.startDate<= :date")
    List<Booking> findBookingByStartDate(@Param("date") LocalDate date);

    @Query("SELECT SUM(b.price) FROM Booking b")
    BigDecimal sumTotalPrice();

    @Query("SELECT SUM(b.totalEcotasa) FROM Booking b")
    BigDecimal sumTotalEcotasa();


}
