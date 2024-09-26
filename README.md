Create table tbMecanico(
id_Mecanico INT GENERATED ALWAYS AS IDENTITY,
nombre_Mecanico VARCHAR2(100),
edad_Mecanico INT,
peso_Mecanico NUMBER(5,2),
correo_Mecanico VARCHAR2(100)
);

insert into tbmecanico (nombre_Mecanico,edad_Mecanico, peso_Mecanico, correo_Mecanico)VALUES ('nombre_Mecanico', 19, 70.2, 'alah@gmail.com' )
