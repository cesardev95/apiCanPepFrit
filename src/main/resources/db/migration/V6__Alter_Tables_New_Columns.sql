ALTER TABLE db_canpepfrit.employees
    add column hour_price DECIMAL NOT NULL;

ALTER TABLE db_canpepfrit.bookings
    add column booking_date DATE NOT NULL,
    add column total_ecotasa DECIMAL NOT NULL,
    add column plataform ENUM('WEB','AIRBNB','BOOKING') NOT NULL,
    add column total_people INT NOT NULL;

ALTER TABLE db_canpepfrit.activity_logs
    add column hour_price DECIMAL NOT NULL;
