-- MariaDB dump 10.17  Distrib 10.4.6-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: dbedificio
-- ------------------------------------------------------
-- Server version	10.4.6-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aptos`
--

DROP TABLE IF EXISTS `aptos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aptos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aptos`
--

LOCK TABLES `aptos` WRITE;
/*!40000 ALTER TABLE `aptos` DISABLE KEYS */;
INSERT INTO `aptos` VALUES (1,'9702'),(2,'9703'),(3,'9801'),(4,'9802'),(5,'9803');
/*!40000 ALTER TABLE `aptos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aptos_propietarios`
--

DROP TABLE IF EXISTS `aptos_propietarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aptos_propietarios` (
  `idApto` int(11) NOT NULL,
  `idPropietario` int(11) NOT NULL,
  PRIMARY KEY (`idApto`,`idPropietario`),
  KEY `idPropietario` (`idPropietario`),
  CONSTRAINT `aptos_propietarios_ibfk_1` FOREIGN KEY (`idApto`) REFERENCES `aptos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aptos_propietarios_ibfk_2` FOREIGN KEY (`idPropietario`) REFERENCES `propietarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aptos_propietarios`
--

LOCK TABLES `aptos_propietarios` WRITE;
/*!40000 ALTER TABLE `aptos_propietarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `aptos_propietarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conceptos`
--

DROP TABLE IF EXISTS `conceptos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conceptos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conceptos`
--

LOCK TABLES `conceptos` WRITE;
/*!40000 ALTER TABLE `conceptos` DISABLE KEYS */;
INSERT INTO `conceptos` VALUES (1,'Mantenimiento');
/*!40000 ALTER TABLE `conceptos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conceptos_entidades`
--

DROP TABLE IF EXISTS `conceptos_entidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conceptos_entidades` (
  `idConcepto` int(11) NOT NULL,
  `idEntidad` int(11) NOT NULL,
  PRIMARY KEY (`idConcepto`,`idEntidad`),
  KEY `idEntidad` (`idEntidad`),
  CONSTRAINT `conceptos_entidades_ibfk_1` FOREIGN KEY (`idConcepto`) REFERENCES `conceptos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `conceptos_entidades_ibfk_2` FOREIGN KEY (`idEntidad`) REFERENCES `entidades` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conceptos_entidades`
--

LOCK TABLES `conceptos_entidades` WRITE;
/*!40000 ALTER TABLE `conceptos_entidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `conceptos_entidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entidades`
--

DROP TABLE IF EXISTS `entidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nit` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entidades`
--

LOCK TABLES `entidades` WRITE;
/*!40000 ALTER TABLE `entidades` DISABLE KEYS */;
INSERT INTO `entidades` VALUES (1,'123','Sequal','seq@s.com','123'),(2,'321','Globant','gl@g.com','321');
/*!40000 ALTER TABLE `entidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gastos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` int(11) NOT NULL,
  `fechaPago` date NOT NULL,
  `idConcepto` int(11) NOT NULL,
  `idEntidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idConcepto` (`idConcepto`),
  KEY `idEntidad` (`idEntidad`),
  CONSTRAINT `gastos_ibfk_1` FOREIGN KEY (`idConcepto`) REFERENCES `conceptos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `gastos_ibfk_2` FOREIGN KEY (`idEntidad`) REFERENCES `entidades` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
INSERT INTO `gastos` VALUES (1,123,'2000-10-11',1,1),(2,123,'2000-11-11',1,2);
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` int(11) NOT NULL,
  `fechaPago` date NOT NULL,
  `idApto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`idApto`),
  CONSTRAINT `id` FOREIGN KEY (`idApto`) REFERENCES `aptos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
INSERT INTO `ingresos` VALUES (1,12,'0000-00-00',1),(2,34,'2000-10-08',1);
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietarios`
--

DROP TABLE IF EXISTS `propietarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propietarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietarios`
--

LOCK TABLES `propietarios` WRITE;
/*!40000 ALTER TABLE `propietarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `propietarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_gastos`
--

DROP TABLE IF EXISTS `view_gastos`;
/*!50001 DROP VIEW IF EXISTS `view_gastos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `view_gastos` (
  `id` tinyint NOT NULL,
  `valor` tinyint NOT NULL,
  `fechaPago` tinyint NOT NULL,
  `nombre_concepto` tinyint NOT NULL,
  `nombre_entidad` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_gastos`
--

/*!50001 DROP TABLE IF EXISTS `view_gastos`*/;
/*!50001 DROP VIEW IF EXISTS `view_gastos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_gastos` AS select `gastos`.`id` AS `id`,`gastos`.`valor` AS `valor`,`gastos`.`fechaPago` AS `fechaPago`,`conceptos`.`nombre` AS `nombre_concepto`,`entidades`.`nombre` AS `nombre_entidad` from ((`gastos` join `conceptos` on(`conceptos`.`id` = `gastos`.`idConcepto`)) join `entidades` on(`entidades`.`id` = `gastos`.`idEntidad`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-06 18:11:52
