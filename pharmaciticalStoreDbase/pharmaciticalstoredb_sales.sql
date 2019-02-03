CREATE DATABASE  IF NOT EXISTS `pharmaciticalstoredb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pharmaciticalstoredb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: pharmaciticalstoredb
-- ------------------------------------------------------
-- Server version	5.5.60-log

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
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `idSales` int(11) NOT NULL AUTO_INCREMENT,
  `SalesDate` datetime DEFAULT NULL,
  `SalesPrice` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Discount` int(11) DEFAULT NULL,
  `IdMedicine` int(11) NOT NULL,
  `IdUser` int(11) NOT NULL,
  `MedicineName` varchar(45) DEFAULT NULL,
  `TransactionID` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSales`),
  KEY `IdMedicine_idx` (`IdMedicine`),
  KEY `IdUser_idx` (`IdUser`),
  CONSTRAINT `id_medicine` FOREIGN KEY (`IdMedicine`) REFERENCES `medicine` (`idMedicine`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_User` FOREIGN KEY (`IdUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (5,'2018-11-15 09:35:50',126,2,3,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',NULL),(8,'2018-11-15 09:55:41',246,3,3,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',NULL),(9,'2018-11-15 10:01:13',1446,2,30,5,2,'Methyldopa Tablets 250 mg, 500 mg',NULL),(10,'2018-11-15 10:50:59',2619,3,27,15,2,'mmmmmmmmmmmmmm',NULL),(11,'2018-11-15 10:50:59',66,3,0,11,2,'FBNDFNKNDFKJ',NULL),(12,'2018-11-15 11:00:05',6536,2,66,18,2,'abinclox',NULL),(13,'2018-11-15 11:00:26',6536,2,66,18,2,'abinclox',NULL),(14,'2018-11-15 11:00:26',55,1,0,14,2,'maloxzelamin capsule',NULL),(15,'2018-11-15 11:51:52',666,3,4,5,2,'Methyldopa Tablets 250 mg, 500 mg',NULL),(16,'2018-11-15 11:51:52',2472,3,52,6,2,'Hydralazine Tablets 25 mg',NULL),(17,'2018-11-15 11:51:52',2896,4,71,8,2,'Silver Sulphadiazine Cream 1%',NULL),(18,'2018-11-16 09:45:52',1665,3,0,14,2,'maloxzelamin capsule',NULL),(19,'2018-11-16 09:45:52',1110,2,0,3,2,'HydrochlorothiazideTablets 25 mg',NULL),(20,'2018-11-16 09:46:38',1665,3,0,14,2,'maloxzelamin capsule',NULL),(21,'2018-11-16 09:46:38',1110,2,0,3,2,'HydrochlorothiazideTablets 25 mg',NULL),(22,'2018-11-16 09:46:38',106,2,2,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',NULL),(23,'2018-11-16 09:47:18',1665,3,0,14,2,'maloxzelamin capsule',NULL),(24,'2018-11-16 09:47:18',1110,2,0,3,2,'HydrochlorothiazideTablets 25 mg',NULL),(25,'2018-11-16 09:47:18',106,2,2,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',NULL),(26,'2018-11-16 09:47:18',846,2,27,16,2,'jisaschbsdkj',NULL),(27,'2018-11-16 09:55:06',56,2,27,6,2,'Hydralazine Tablets 25 mg',NULL),(28,'2018-11-16 09:55:06',1368,2,21,14,2,'maloxzelamin capsule',NULL),(29,'2018-11-16 09:55:51',480,2,15,6,2,'Hydralazine Tablets 25 mg',NULL),(30,'2018-11-16 12:33:36',555,1,0,11,2,'FBNDFNKNDFKJ',NULL),(31,'2018-11-16 01:04:14',10010,22,0,16,2,'jisaschbsdkj',NULL),(32,'2018-11-16 07:36:03',165,3,0,7,2,'Fucidin Intertulle Dressing',NULL),(33,'2018-11-17 09:04:23',5024,2,51,5,2,'Methyldopa Tablets 250 mg, 500 mg',0),(34,'2018-11-17 09:42:45',632,2,6,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',0),(35,'2018-11-17 09:44:08',2214,3,47,11,2,'FBNDFNKNDFKJ',0),(36,'2018-11-17 09:46:18',15582,3,331,17,2,'fusindine tablet',1),(37,'2018-11-17 09:46:18',1584,3,27,7,2,'Fucidin Intertulle Dressing',1),(38,'2018-11-17 09:46:18',2588,4,19,14,2,'maloxzelamin capsule',1),(39,'2018-11-17 09:50:35',1881,3,39,5,2,'Methyldopa Tablets 250 mg, 500 mg',2),(40,'2018-11-18 09:19:15',1584,2,41,5,2,'Methyldopa Tablets 250 mg, 500 mg',3),(41,'2018-11-18 09:19:15',938,2,9,7,2,'Fucidin Intertulle Dressing',3),(42,'2018-11-18 09:19:15',1512,4,378,8,2,'Silver Sulphadiazine Cream 1%',3),(43,'2018-11-18 09:36:27',16824,2,350,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',4),(44,'2018-11-18 09:36:27',2241,3,39,8,2,'Silver Sulphadiazine Cream 1%',4),(45,'2018-11-18 09:36:27',2595,3,26,9,2,'Tetracycline Skin Ointment ',4),(46,'2018-11-18 09:39:51',859,1,17,5,2,'Methyldopa Tablets 250 mg, 500 mg',5),(47,'2018-11-18 09:39:51',2238,3,39,7,2,'Fucidin Intertulle Dressing',5),(48,'2018-11-18 09:39:51',2241,3,15,9,2,'Tetracycline Skin Ointment ',5),(49,'2018-11-18 09:49:30',22305,3,391,8,2,'Silver Sulphadiazine Cream 1%',6),(50,'2018-11-18 09:49:30',22644,3,314,9,2,'Tetracycline Skin Ointment ',6),(51,'2018-11-18 09:49:30',639,3,753,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',6),(52,'2018-11-18 10:19:04',744,3,7,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',8),(53,'2018-11-18 10:19:04',2229,3,39,8,2,'Silver Sulphadiazine Cream 1%',8),(54,'2018-11-18 10:19:04',16806,2,442,9,2,'Tetracycline Skin Ointment ',8),(55,'2018-11-18 10:27:37',162,3,2,8,2,'Silver Sulphadiazine Cream 1%',9),(56,'2018-11-18 10:27:37',7628,4,537,5,2,'Methyldopa Tablets 250 mg, 500 mg',9),(57,'2018-11-18 10:35:58',566,2,5,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',10),(58,'2018-11-18 10:35:58',453,1,0,7,2,'Fucidin Intertulle Dressing',10),(59,'2018-11-18 10:35:58',36255,3,246,4,2,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',10),(60,'2018-11-18 10:36:38',4436,2,116,5,2,'Methyldopa Tablets 250 mg, 500 mg',11),(61,'2018-11-27 01:07:47',172,2,1,20,18,'sssss',12),(62,'2018-11-27 01:07:47',4352,2,44,24,18,'hhjejejejejej',12),(63,'2018-12-01 10:41:56',63,3,1,5,20,'Methyldopa Tablets 250 mg, 500 mg',16),(64,'2018-12-01 10:41:56',12,2,549,6,20,'Hydralazine Tablets 25 mg',16),(65,'2018-12-02 05:28:03',104,2,3,12,20,'dddd',17);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-07 17:28:11
