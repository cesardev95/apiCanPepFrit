package com.canpepfrit.apicanpepfrit.DTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

@Data
public class DashboardDTO {
    private final String[] meses ={"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
    private final int[] dias = IntStream.rangeClosed(1, 31).toArray();
    private List<ClienteLightDTO> clientes;
    private String plataforma;
    private LocalDate fechaReserva;
    private BigDecimal importeNetoReserva;
    private BigDecimal totalGanancias;
    private BigDecimal precioNoche;
    private BigDecimal ecotasa;

}
