package com.canpepfrit.apicanpepfrit.services;

import com.canpepfrit.apicanpepfrit.DTOS.BookingRowDTO;
import com.canpepfrit.apicanpepfrit.DTOS.DashboardDTO;
import com.canpepfrit.apicanpepfrit.repositories.RepoBooking;
import com.canpepfrit.apicanpepfrit.repositories.RepoClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DashboardService {
    private final RepoBooking repoBooking;
    private final RepoClient repoClient;

    public DashboardService(RepoBooking repoBooking, RepoClient repoClient) {
        this.repoBooking = repoBooking;
        this.repoClient = repoClient;
    }

    public DashboardDTO obtainDashboard() {
        DashboardDTO dto = new DashboardDTO();

        dto.setTotalAmount(repoBooking.sumTotalPrice());
        dto.setTotalEcotasa(repoBooking.sumTotalEcotasa());

        List<BookingRowDTO> rows = repoBooking.findAll().stream().map(booking -> {
            BookingRowDTO row = new BookingRowDTO();

            int diaInicio = booking.getStartDate().getDayOfMonth();
            int diaFinal = booking.getEndDate().getDayOfMonth();

            row.setMonth(booking.getEndDate().getMonth().name());
            row.setDays(diaInicio + "-" + diaFinal);
            row.setClientName(booking.getClient().getName());
            row.setPlataform(booking.getPlatform().name());
            row.setBookingDate(booking.getBookingDate());
            row.setNetAmountBooking(booking.getPrice());
            row.setEcotasa(booking.getTotalEcotasa());

            return row;
        }).toList();

        dto.setBookings(rows);
        return dto;
    }
}
