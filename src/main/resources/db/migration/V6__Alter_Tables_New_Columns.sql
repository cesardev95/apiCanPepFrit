ALTER TABLE db_canpepfrit.empleados
    add column precio_hora DECIMAL NOT NULL;

ALTER TABLE db_canpepfrit.reservas
    add column fecha_reserva DATE NOT NULL,
    add column total_ecotasa DECIMAL NOT NULL,
    add column plataforma ENUM('WEB','AIRBNB','BOOKING') NOT NULL,
    add column total_personas INT NOT NULL;

ALTER TABLE db_canpepfrit.registros_actividad
    add column precio_hora DECIMAL NOT NULL;
