DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios ( ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE  varchar(200) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL);


DROP TABLE IF EXISTS pacientes;
CREATE TABLE pacientes (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
EMAIL varchar(100) NOT NULL,
DNI INT NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL
);

INSERT INTO domicilios (calle, numero, localidad, provincia)
VALUES ('calle a', 475, 'Zona 1', 'salta');
INSERT INTO domicilios (calle , numero , localidad , provincia)
VALUES ('calle ',222, 'Zona 2', 'salta');

INSERT INTO pacientes(apellido, nombre, email, dni, fecha_ingreso, domicilio_id)
VALUES ('Mora','Ian', 'jhos92@hotmail.com', 12345, '22-03-01',1);
INSERT INTO pacientes(apellido, nombre, email, dni, fecha_ingreso, domicilio_id)
VALUES ('Mora', 'Belkis', 's93@hotmail.com', 123225, '22-03-04',2);

