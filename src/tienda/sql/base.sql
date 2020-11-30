drop database if exists tiendaMinimo;
create database tiendaMinimo; 
use tiendaMinimo;

-- drop table if exists productos;
-- drop table if exists clientes;
-- drop table if exists vendedores;
-- drop table if exists ventas;
-- drop table if exists detalle_ventas;

create table if not exists productos(
id int auto_increment primary key,
cod_productos int unique,
nombre varchar(50) not null,
precio float not null,
cantidad int not null,
imagen varchar(50),
descripcion varchar(50) default '',
detalles varchar(500),
disponible 	enum('SI','NO') not null,
visitas int default 0,
ventas int default 0

);

create table if not exists clientes(
id int auto_increment primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
dni_cuit varchar(11) not null unique,
pais varchar(50)  default 'Argentina',
provincia varchar(50) default 'CABA',
direccion varchar(50),
cp varchar(10),
telefono varchar(25),
mail varchar(50),
fechaNacimiento varchar(50),
usuario_registrado enum('SI','NO'),
contrasenia varchar(50)
);


create table if not exists vendedores(
id int auto_increment primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
dni_cuit varchar(11) not null unique,
pais varchar(50)  default 'Argentina',
provincia varchar(50) default 'CABA',
direccion varchar(50),
cp varchar(10),
telefono varchar(25),
mail varchar(50),
fechaNacimiento varchar(50),
contrasenia varchar(50),
fecha_ingreso date not null
);


create table if not exists ventas(
id int auto_increment primary key,
id_clientes int not null,
id_vendedor int not null,
fecha_venta date ,
importe float not null,
estado 	enum('PENDIENTE','ENTREGADO') not null,
entrega enum ('RETIRO', 'DOMICILIO')
);
alter table ventas 
add constraint fk_ventas_cliente
foreign key(id_clientes)
references clientes(id)
on delete cascade on update cascade;

alter table ventas 
add constraint fk_ventas_vendedor
foreign key(id_vendedor)
references vendedores(id)
on delete cascade on update cascade;

create table if not exists detalle_ventas(
id int auto_increment primary key,
id_producto int not null,
id_venta int not null
);

alter table detalle_ventas 
add constraint fk_detalle_producto
foreign key(id_producto)
references productos(id);

alter table detalle_ventas 
add constraint fk_detalle_venta
foreign key(id_venta)
references ventas(id);


-- select*from productos;

