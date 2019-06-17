-- MySQL dump 10.16  Distrib 10.1.29-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: db_estacionamento
-- ------------------------------------------------------
-- Server version	10.1.29-MariaDB

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
-- Table structure for table `tbl_movimentacao`
--

DROP TABLE IF EXISTS `tbl_movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_movimentacao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modelo` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `data_entrada` datetime NOT NULL,
  `data_saida` datetime DEFAULT NULL,
  `tempo` int(11) NOT NULL,
  `valor_pago` decimal(6,2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_movimentacao`
--

LOCK TABLES `tbl_movimentacao` WRITE;
/*!40000 ALTER TABLE `tbl_movimentacao` DISABLE KEYS */;
INSERT INTO `tbl_movimentacao` VALUES (1,'ABC1234','CORSA','2019-04-15 07:38:00',NULL,0,0.00),(2,'XPT5678','CORCEL II','2019-04-15 08:03:00','2019-04-15 10:19:00',3,14.00),(3,'DEF5678','CORSA','2019-04-22 10:50:00','2019-04-22 15:36:00',5,22.00),(4,'GHI9102','BRASILIA','2019-04-22 17:27:25',NULL,0,0.00),(5,'JKL1129','GOL','2019-04-24 14:14:05','2019-04-24 17:09:47',3,14.00),(6,'MNO3141','CORSA','2019-04-24 14:32:21','2019-04-24 18:57:18',5,22.00),(7,'PQR5161','GOL','2019-04-24 14:56:10',NULL,0,0.00),(8,'STU7189','CORSA','2019-04-24 17:13:56','2019-04-24 18:27:08',2,10.00),(9,'VXY1920','CORSA','2019-04-24 18:29:08',NULL,0,0.00),(10,'ZAB2122','FUSCA','2019-04-24 18:36:23','2019-04-24 18:37:33',0,0.00),(11,'ABC1234','GOL','2019-04-24 18:39:55','2019-04-24 18:41:40',0,0.00),(12,'EAG1234','CORSA','2019-04-29 07:54:09','2019-04-29 17:10:13',10,42.00),(13,'ABC2345','NIMBUS2000','2019-04-29 14:56:26','2019-06-17 08:14:59',1170,4682.00);
/*!40000 ALTER TABLE `tbl_movimentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usuario` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `senha` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'Eduardo A Galvão','gerente','gerente2019'),(2,'Fernando Roberto','operador','operador2019');
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_valor`
--

DROP TABLE IF EXISTS `tbl_valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_valor` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `valor_primeira_hora` decimal(6,2) NOT NULL,
  `valor_demais_horas` decimal(6,2) NOT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_valor`
--

LOCK TABLES `tbl_valor` WRITE;
/*!40000 ALTER TABLE `tbl_valor` DISABLE KEYS */;
INSERT INTO `tbl_valor` VALUES (1,3.00,1.00,'2019-04-13'),(2,6.00,4.00,NULL);
/*!40000 ALTER TABLE `tbl_valor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17  8:31:28
