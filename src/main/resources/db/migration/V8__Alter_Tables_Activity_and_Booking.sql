ALTER TABLE db_canpepfrit.activity_logs
    add column paid boolean NOT NULL;

ALTER TABLE db_canpepfrit.bookings
    add column paid boolean NOT NULL,
    add column details VARCHAR(255);


