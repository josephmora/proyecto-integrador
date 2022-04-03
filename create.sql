DROP TABLE IF EXISTS domicilio;
CREATE TABLE domicilio ( ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE  varchar(200) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL);


DROP TABLE IF EXISTS paciente;
CREATE TABLE paciente (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
EMAIL varchar(100) NOT NULL,
DNI varchar(100) NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL,
ODONTOLOGO_ID INT NOT NULL


);

DROP TABLE IF EXISTS odontologo;
CREATE TABLE odontologo (ID INT AUTO_INCREMENT PRIMARY KEY,
NOMBRE varchar(100) NOT NULL,
APELLIDO VARCHAR(100) NOT NULL,
MATRICULA VARCHAR(100) NOT NULL
);

INSERT INTO domicilio (calle, numero, localidad, provincia)
VALUES ('calle a', 475, 'Zona 1', 'salta');
INSERT INTO domicilio (calle , numero , localidad , provincia)
VALUES ('calle ',222, 'Zona 2', 'salta');

INSERT INTO paciente(apellido, nombre, email, dni, fecha_ingreso, domicilio_id, odontologo_id)
VALUES ('Mora','Ian', 'jhos92@hotmail.com', '12345', '22-03-01',1,1);
INSERT INTO paciente(apellido, nombre, email, dni, fecha_ingreso, domicilio_id, odontologo_id)
VALUES ('Mora', 'Belkis', 's93@hotmail.com', '123225', '22-03-04',2,2);

INSERT INTO odontologo(nombre, apellido, matricula)
VALUES ('Pepito', 'Perez', '12345');
INSERT INTO odontologo(nombre, apellido, matricula)
VALUES ('Juan', 'Maldo', '54555');


