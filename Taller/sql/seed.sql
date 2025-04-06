USE GestionTaller;

INSERT INTO Clientes (DNI, Nombre, Apellido, Telefono, Direccion, Email, Cuenta_bancaria)
VALUES ('12345678A', 'Juan', 'Pérez', 123456789, 'Calle Falsa 123', 'juan@example.com', 'ES1234567890123456789012');

CREATE TABLE Clientes (
    DNI VARCHAR(20) PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Telefono INT(15),
    Direccion VARCHAR (100),
    Email VARCHAR (100),
    Cuenta_bancaria VARCHAR(34)
);

USE GestionTaller;
CREATE TABLE Citas (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(20) NOT NULL,
    Asunto VARCHAR(100) NOT NULL,
    Fecha DATETIME NOT NULL,
    Matricula VARCHAR(50),
    FOREIGN KEY (DNI) REFERENCES Clientes(DNI)
);

USE GestionTaller;
CREATE TABLE Reparaciones (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_reparacion VARCHAR(100) NOT NULL,
    Fecha_inicio DATETIME NOT NULL,
    Fecha_final DATETIME,
    Asunto VARCHAR(200),
    Horas DOUBLE(10,2),
    ID_cita INT,
    Acabado BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (ID_cita) REFERENCES Citas(ID)
);
USE GestionTaller;
CREATE TABLE Empleados_Reparaciones (
    ID_empleado VARCHAR(50) NOT NULL,
    ID_reparacion INT NOT NULL,
    PRIMARY KEY (ID_empleado, ID_reparacion),
    FOREIGN KEY (ID_empleado) REFERENCES Empleados(ID),
    FOREIGN KEY (ID_reparacion) REFERENCES Reparaciones(ID)
);
USE GestionTaller;
CREATE TABLE Productos_Reparaciones (
    ID_producto INT NOT NULL,
    ID_reparacion INT NOT NULL,
    Cantidad DECIMAL(10,2) NOT NULL DEFAULT 1,
    Precio_unidad DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (ID_producto, ID_reparacion),
    FOREIGN KEY (ID_producto) REFERENCES Inventario(ID),
    FOREIGN KEY (ID_reparacion) REFERENCES Reparaciones(ID)
);
USE GestionTaller;
CREATE TABLE Pagos (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_reparacion INT NOT NULL,
    Precio DECIMAL(12,2) NOT NULL,
    Concepto VARCHAR(200) NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_reparacion) REFERENCES Reparaciones(ID)
);


CREATE TABLE Gastos(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_empleado VARCHAR(50) NOT NULL,
    Precio DECIMAL(12,2) NOT NULL,
    Concepto VARCHAR(200) NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_empleado) REFERENCES Empleados(ID)
);
USE GestionTaller;
CREATE TABLE Coches(
    matricula VARCHAR(40) PRIMARY KEY,
    marca VARCHAR(20) NOT NULL,
    modelo VARCHAR(20) NOT NULL,
    año YEAR NOT NULL,
    DNI_Cliente VARCHAR(9) NOT NULL,
    FOREIGN KEY (DNI_Cliente) REFERENCES Clientes(DNI)
);



USE GestionTaller;
CREATE TABLE Empleados(
    ID VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_contratacion DATETIME NOT NULL,
    salario DECIMAL(10, 2) NOT NULL
);






USE GestionTaller;
CREATE TABLE Inventario(
    ID_Producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
);

