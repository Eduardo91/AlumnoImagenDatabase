#Creación de la Base de Datos:
DROP DATABASE IF EXISTS alumnosutl;

CREATE DATABASE alumnosutl;

USE alumnosutl;

CREATE TABLE alumno
(
	idAlumno		INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    matricula		VARCHAR(10),
    nombre			VARCHAR(50),
    apellidoPaterno	VARCHAR(50),
    apellidoMaterno	VARCHAR(50),    
    grupo			VARCHAR(20),
    generacion		VARCHAR(15),
    fotografia		LONGTEXT
);

#Inserción de registros de prueba:
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(1, '15001550', 'Gerardo', 'Becerra', 'Muñoz', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(2, '15001326', 'Erick Martín', 'Castillo', 'Araiza', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(3, '15001897', 'Fernanda Marisol', 'Durán', 'Chávez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(4, '15001290', 'José Roberto', 'Gómez', 'García', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(5, '15001274', 'Jorge Luis', 'Gómez', 'Vázquez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(6, '15001466', 'Flor María de los Ángeles', 'González', 'Ramírez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(7, '15001404', 'Oscar Osvaldo', 'Guardado', 'Rea', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(8, '15001285', 'Gustavo Alonso', 'Hernández', 'Pérez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(9, '14002080', 'Luis Eduardo', 'Martínez', 'Espinoza', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(10, '15001299', 'Eliud', 'Montiel', 'Ramírez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(11, '15001560', 'Andrés', 'Moreno', 'Valdez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(12, '15001384', 'Mario Daniel', 'Muro', 'Sánchez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(13, '15001405', 'José Ramón', 'Ramírez', 'García', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(14, '15001530', 'Ramiro', 'Ramírez', 'López', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(15, '15001461', 'Gustavo', 'Saldaña', 'Aguilar', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(16, '15001364', 'Emmanuel', 'Saldívar', 'Segura', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(17, '15001272', 'Guillermo Juan de Dios', 'Sánchez', 'García', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(18, '15001251', 'Braulio César', 'Sorcia', 'Espinoza', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(19, '15001487', 'Christian Alberto', 'Valadez', 'Lira', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(20, '15001894', 'Samuel', 'Valles', 'Sánchez', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(21, '15001479', 'Jiri Karell', 'Villagómez', 'Galván', 'SI-403', '2015-2017', '');
INSERT INTO alumno(idAlumno, matricula, nombre, apellidoPaterno, apellidoMaterno, grupo, generacion, fotografia) VALUES(22, '15001363', 'Guillermo', 'Uribe', 'Martínez', 'SI-403', '2015-2017', '');