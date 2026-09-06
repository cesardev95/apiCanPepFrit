
CREATE TABLE IF NOT EXISTS accommodations(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(100)
    );
CREATE TABLE IF NOT EXISTS clients(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(100),
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(100)
    );
CREATE TABLE IF NOT EXISTS activity_logs(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_employee BIGINT NOT NULL,
    id_accommodation BIGINT NOT NULL,
    hours INTEGER NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (id_employee) REFERENCES employees(id),
    FOREIGN KEY (id_accommodation) REFERENCES accommodations(id)
    );
CREATE TABLE IF NOT EXISTS bookings(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_client BIGINT NOT NULL,
    id_accommodation BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    price DECIMAL NOT NULL,
    FOREIGN KEY (id_client) REFERENCES clients(id),
    FOREIGN KEY (id_accommodation) REFERENCES accommodations(id)
);