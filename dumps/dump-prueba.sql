-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: tiendaMinimo
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni_cuit` varchar(11) NOT NULL,
  `pais` varchar(50) DEFAULT 'Argentina',
  `provincia` varchar(50) DEFAULT 'CABA',
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `fechaNacimiento` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_cuit` (`dni_cuit`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'juan','perez','12345678','Argentina','CABA','peru 323','44444444','juan@mail','1990-11-12','1234444448'),(2,'carlos','torres','11111111','Argentina','CABA','chile 320','44455555','carlos@mail','1990-10-11','12345678'),(3,'laura','gomez','22222222','Argentina','CABA','san juan 420','44446666','laura@mail','1991-01-03','12345678'),(4,'jorge','lope','33333333','Argentina','CABA','lavalle 770','44447777','jorge@mail','1983-03-03','12345678'),(5,'maria','lopez','44444444','Argentina','CABA','mexico 150','44448888','maria@mail','1998-04-05','12345678');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ventas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `id_venta` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_detalle_producto` (`id_producto`),
  KEY `fk_detalle_venta` (`id_venta`),
  CONSTRAINT `fk_detalle_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`),
  CONSTRAINT `fk_detalle_venta` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas`
--

LOCK TABLES `detalle_ventas` WRITE;
/*!40000 ALTER TABLE `detalle_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cod_productos` int DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int NOT NULL,
  `imagen` varchar(100) DEFAULT NULL,
  `descripcion` varchar(1000) DEFAULT '',
  `detalles` varchar(1000) DEFAULT '',
  `disponible` enum('SI','NO') NOT NULL,
  `visitas` int DEFAULT '0',
  `ventas` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cod_productos` (`cod_productos`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,1021,'Rosa lila',1700,10,'../img/rosaLila.jpg','Paquete por 25 un','Importadas Ecuador','SI',10,100),(2,1022,'Rosa roja',1500,10,'../img/rosaRoja.jpg','Paquete por 25 un','Importadas Ecuador','SI',12,10),(3,1023,'Rosa blanca',1800,10,'../img/rosaBlanca.jpg','Paquete por 25 un','Importadas Ecuador','SI',40,90),(4,1024,'Rosa rosada',1300,10,'../img/rosaRosa.jpeg','Paquete por 25 un','Importadas Ecuador','SI',30,80),(5,1025,'Rosa tenida',1700,10,'../img/rosaTenida.jpg','Paquete por 25 un','Importadas Ecuador','SI',40,70),(6,1026,'Rosa azul',1900,10,'../img/rosaAzul.jpg','Paquete por 25 un','Importadas Ecuador','SI',40,70);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `tipoUsuario` enum('VENDEDOR','ADMINISTRADOR') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Susana','Mercado','mercado@mail','mercado','VENDEDOR'),(2,'Julio','Lope','lope@mail','lope','VENDEDOR'),(3,'Sergio','Korn','korn@mail','korn','ADMINISTRADOR'),(4,'Juan','Gomez','gomez@mail','gomez','VENDEDOR');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_clientes` int NOT NULL,
  `id_usuarios` int NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `importe` float NOT NULL,
  `estado` enum('PENDIENTE','ENTREGADO','CANCELADO') NOT NULL,
  `entrega` enum('RETIRO','DOMICILIO') DEFAULT NULL,
  `dir_entrega` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ventas_cliente` (`id_clientes`),
  KEY `fk_ventas_usuarios` (`id_usuarios`),
  CONSTRAINT `fk_ventas_cliente` FOREIGN KEY (`id_clientes`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ventas_usuarios` FOREIGN KEY (`id_usuarios`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,1,1,'2020-11-02',2500,'PENDIENTE','RETIRO',NULL),(2,2,1,'2020-11-02',2300,'PENDIENTE','RETIRO',NULL),(3,3,1,'2020-11-02',3300,'PENDIENTE','RETIRO',NULL),(4,2,2,'2020-11-02',3300,'PENDIENTE','RETIRO',NULL),(5,4,1,'2020-11-02',4300,'PENDIENTE','RETIRO',NULL);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-30 12:20:53
