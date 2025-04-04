CREATE TABLE Clientes (
    DNI VARCHAR(20) PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Telefono VARCHAR(15),
    Cuenta_bancaria VARCHAR(34)
);

CREATE TABLE Citas (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(20) NOT NULL,
    Asunto VARCHAR(100) NOT NULL,
    Fecha DATETIME NOT NULL,
    Matricula VARCHAR(10),
    Acudido BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (DNI) REFERENCES Clientes(DNI)
);


CREATE TABLE Reparaciones (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_reparacion VARCHAR(100) NOT NULL,
    Fecha_inicio DATETIME NOT NULL,
    Fecha_final DATETIME,
    Asunto VARCHAR(200),
    Horas DOUBLE,
    ID_cita INT,
    Acabado BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (ID_cita) REFERENCES Citas(ID)
);

CREATE TABLE Empleados_Reparaciones (
    ID_empleado INT NOT NULL,
    ID_reparacion INT NOT NULL,
    PRIMARY KEY (id_empleado, id_reparacion),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(ID),
    FOREIGN KEY (id_reparacion) REFERENCES Reparaciones(ID)
);

CREATE TABLE Productos_Reparaciones (
    ID_producto INT NOT NULL,
    ID_reparacion INT NOT NULL,
    Cantidad DECIMAL(10,2) NOT NULL DEFAULT 1,
    Precio_unidad DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (ID_producto, ID_reparacion),
    FOREIGN KEY (ID_producto) REFERENCES Inventario(ID),
    FOREIGN KEY (ID_reparacion) REFERENCES Reparaciones(ID)
);

CREATE TABLE Economia (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Tipo VARCHAR(20) NOT NULL,
    Cantidad DECIMAL(12,2) NOT NULL,
    Asunto VARCHAR(200) NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

