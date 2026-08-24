
CREATE TABLE IF NOT EXISTS alojamientos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono VARCHAR(100)
    );
CREATE TABLE IF NOT EXISTS clientes(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(100),
    email VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(100)
    );
CREATE TABLE IF NOT EXISTS registros_actividad(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    idEmpleado BIGINT NOT NULL,
    idAlojamiento BIGINT NOT NULL,
    horas INTEGER NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (idEmpleado) REFERENCES empleados(id),
    FOREIGN KEY (idAlojamiento) REFERENCES alojamientos(id)
    );
CREATE TABLE IF NOT EXISTS reservas(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    idCliente BIGINT NOT NULL,
    idAlojamiento BIGINT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_final DATE NOT NULL,
    precio DECIMAL NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES clientes(id),
    FOREIGN KEY (idAlojamiento) REFERENCES alojamientos(id)
);