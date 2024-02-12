CREATE TABLE IF NOT EXISTS inventario (
    sku CHAR(4) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL
);

CREATE TABLE IF NOT EXISTS empleados(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    puesto VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS polizas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    fecha DATE DEFAULT CURRENT_DATE,
    articulo CHAR(4) NOT NULL,
    empleado INT,
    FOREIGN KEY(articulo) REFERENCES inventario(sku),
    FOREIGN KEY(empleado) REFERENCES empleados(id)
);
