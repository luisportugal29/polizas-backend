-- Insercciones para la tabla empleados
INSERT INTO empleados (nombre, apellido, puesto) VALUES ('Juan', 'Gómez', 'Desarrollador');
INSERT INTO empleados (nombre, apellido, puesto) VALUES ('María', 'Rodríguez', 'Analista');
INSERT INTO empleados (nombre, apellido, puesto) VALUES ('Pedro', 'Martínez', 'Diseñador');
INSERT INTO empleados (nombre, apellido, puesto) VALUES ('Laura', 'López', 'Gerente');
INSERT INTO empleados (nombre, apellido, puesto) VALUES ('Carlos', 'Pérez', 'Ingeniero');

-- Insercciones para la tabla inventario
INSERT INTO inventario (sku, nombre, cantidad) VALUES ('A001', 'Laptop Accer', 10);
INSERT INTO inventario (sku, nombre, cantidad) VALUES ('B001', 'Bocinas Logitech', 20);
INSERT INTO inventario (sku, nombre, cantidad) VALUES ('C001', 'Refrigerador Samsung', 15);
INSERT INTO inventario (sku, nombre, cantidad) VALUES ('D001', 'Airpods Pro 2', 25);
INSERT INTO inventario (sku, nombre, cantidad) VALUES ('E001', 'Samsung Galaxy S24 Ultra', 30);

-- Inserciones para la tabla 'polizas'
INSERT INTO polizas (cantidad, articulo, empleado) VALUES (2,'A001', 1);
INSERT INTO polizas (cantidad, articulo, empleado) VALUES (5,'B001', 2);
INSERT INTO polizas (cantidad, articulo, empleado) VALUES (5,'B001', 3);
INSERT INTO polizas (cantidad, articulo, empleado) VALUES (5,'C001', 4);
INSERT INTO polizas (cantidad, articulo, empleado) VALUES (10,'E001', 5);
