CREATE TABLE Coches(
    matricula VARCHAR(7) PRIMARY KEY,
    marca VARCHAR(20) NOT NULL,
    modelo VARCHAR(20) NOT NULL,
    año INT NOT NULL,
    DNI_Cliente VARCHAR(9) NOT NULL
);

CREATE TABLE Empleados(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    telefono VARCHAR(9) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
);

CREATE TABLE Inventario(
    ID_Producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
);

