-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: domus
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `propiedad`
--

DROP TABLE IF EXISTS `propiedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propiedad` (
  `id_propiedad` int NOT NULL AUTO_INCREMENT,
  `medidas` varchar(45) DEFAULT NULL,
  `antiguedad` int DEFAULT NULL,
  `amueblado` varchar(30) DEFAULT NULL,
  `artefactos` varchar(100) DEFAULT NULL,
  `servicios` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `tipo` varchar(20) NOT NULL,
  `ubicacion` int NOT NULL,
  `monto` int NOT NULL,
  `propietario` int DEFAULT NULL,
  PRIMARY KEY (`id_propiedad`),
  KEY `propietario_idx` (`propietario`),
  KEY `ubicacion_idx` (`ubicacion`),
  CONSTRAINT `propietario` FOREIGN KEY (`propietario`) REFERENCES `propietario` (`id_propietario`),
  CONSTRAINT `ubicacion` FOREIGN KEY (`ubicacion`) REFERENCES `ubicacion` (`ubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propiedad`
--

LOCK TABLES `propiedad` WRITE;
/*!40000 ALTER TABLE `propiedad` DISABLE KEYS */;
INSERT INTO `propiedad` VALUES (10,'40x40',121121,'SI','ads','addsa','Disponible','Alquiler',10,212121,1),(11,'40x40',333,'SI','dadsda','dassdad','Disponible','Alquiler',11,2222,1),(12,'50x40',121121,'SI','ads','addsa','Disponible','Alquiler',12,212121,2),(13,'200x200',212112,'SI','kashakhs','shaksha','No Disponible','Alquiler',13,212121,1),(14,'250x32',21212,'SI','sasdsadas','sdsadsada','Disponible','Alquiler',14,212121,1),(15,'40x30',12121,'SI','addsa','sdadsaasd','Disponible','Alquiler',15,212123,2),(16,'2000x2000',21121,'SI','sabjsanba','assajsajsa','Disponible','Alquiler',16,12122,2),(17,'30x20',2222,'SI','wjkqjkwqjk','kjwqjkwqj','No Disponible','Alquiler',17,2222,2),(18,'10x10',55555,'SI','kjkjk','hhhjhjhj','Disponible','Alquiler',18,7777,2),(19,'345x234',2121,'SI','jkjkdjks','jdajkdakj','No Disponible','Alquiler',19,21212,2),(20,'21x21',12121,'2','sajksjkakj','kjsajksajksa','Disponible','Alquiler',20,12121,1),(21,'1000x1000',121212,'SI','sasa','dasdada','Disponible','Alquiler',21,2112121,1),(25,'20x20',10,'SI','jskasjk','jajksjakj','Disponible','Venta',25,10000,1),(26,'20x25',28,'NO','Nada','Agua, Luz, Gas, Internet','Disponible','Venta',26,10000000,3),(27,'200x400',10,'NO','Nada','Nada','Disponible','Venta',27,30000000,2);
/*!40000 ALTER TABLE `propiedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propietario` (
  `id_propietario` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `dni` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` int NOT NULL,
  PRIMARY KEY (`id_propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
INSERT INTO `propietario` VALUES (1,'Franco','Insaurralde',41444545,'franco@mail.com',12345),(2,'Leo','Messi',12345678,'messi@mail',12345),(3,'Axel','Encina',42484341,'axelencina@gmail.com',12345);
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ubicacion` (
  `ubicacion` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `barrio` varchar(45) DEFAULT NULL,
  `piso` varchar(45) DEFAULT NULL,
  `dpto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicacion`
--

LOCK TABLES `ubicacion` WRITE;
/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
INSERT INTO `ubicacion` VALUES (10,'Argentina','Corrientes','Corrientes','9 de julio','1222','dasdadsa','2121','adasd'),(11,'Argentina','Corrientes','Corrientes','Rioja','211','sdaadsda','1212','dasdsadas'),(12,'Argentina','Chaco','Resistencia','25 de Mayo','888','dsdssad','1222','dsassa'),(13,'Argentina','Chaco','Barranqueras','España','234','jksajkasjksjak','2121','222as'),(14,'Argentina','Chaco','Barranqueras','Colombia','222','kjwqjkwqjkjwk','2','jksjka'),(15,'Argentina','Corrientes','Corrientes','9 de julio','998','jhhjhjhj','78877','212'),(16,'Argentina','Corrientes','Corrientes','3 de abril','2121','jnknjjk','21212','21221'),(17,'Argentina','Corrientes','Corrientes','Córdoba','334','guemes','222','s22'),(18,'Argentina','Corrientes','Corrientes','9 de julio','121','dadsa','1121','21212'),(19,'Argentina','Corrientes','Corrientes','Junin','777','sdasdasd','22233','sasas'),(20,'Argentina','Formosa','Formosa','La plata','654',NULL,NULL,NULL),(21,'Argentina','Córdoba','Cordoba','Lavalle','487',NULL,NULL,NULL),(25,'Argentina','Formosa','Colorado','3 de Abril','1878',NULL,NULL,NULL),(26,'Argentina','Chaco','Juan José Casteri','Rivadavia','765',NULL,NULL,NULL),(27,'Argentina','Santa Fé','Rosario','Maradona','1201',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `email` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `role` char(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'inmb@domus.com','1234imb','Inmobiliario');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-01 11:22:52
