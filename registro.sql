drop database if exists registro;
create database registro;
use registro;

create table Alumnos(
matricula int,
nombre varchar(20),
grupo varchar(20),
carrera varchar(20),
primary key (matricula)
);

INSERT INTO Alumnos VALUES (12455,'juan','se234','turismo');