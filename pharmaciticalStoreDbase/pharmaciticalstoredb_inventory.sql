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
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `idInventory` int(11) NOT NULL AUTO_INCREMENT,
  `idMedicine` int(11) DEFAULT NULL,
  `MedicineName` varchar(45) DEFAULT NULL,
  `QuantityInStore` int(11) DEFAULT NULL,
  `QuantityNewPurchase` int(11) DEFAULT NULL,
  `PurchasedPrice` int(11) DEFAULT NULL,
  `SalePrice` int(11) DEFAULT NULL,
  `InterestRate` int(11) DEFAULT NULL,
  `dateAdded` datetime DEFAULT NULL,
  `ManufDate` date DEFAULT NULL,
  `ExpDate` date DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idInventory`),
  KEY `idUser_idx` (`idUser`),
  KEY `idMedicine_idx` (`idMedicine`),
  CONSTRAINT `idMedicine` FOREIGN KEY (`idMedicine`) REFERENCES `medicine` (`idMedicine`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (7,4,'Tetracycline Skin Ointment',778,0,0,56,1,'2018-10-23 06:40:49','2018-10-03','2018-10-18',2),(8,4,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',875,589,2323,55,455,'2018-10-23 06:47:44','2018-10-03','2018-10-12',2),(9,4,'Hydralazine Tablets 25 mg',552,365,789,8895,2,'2018-10-23 06:50:13','2018-10-02','2018-10-26',2),(10,4,'Fucidin Intertulle Dressing',584,88,65,886,2,'2018-10-23 06:52:52','2018-10-09','2018-10-19',2),(11,4,'Frusemide Tablets 40 mg',69,126,222,553,1,'2018-10-23 06:54:07','2018-10-03','2018-10-12',2),(12,4,'Frusemide Tablets 40 mg',69,54,12,251,1,'2018-10-23 06:54:51','2018-10-10','2018-10-05',2),(13,4,'Frusemide Tablets 40 mg',9000,1000,2500,2700,24,'2018-10-24 01:21:14','2018-01-09','2018-10-26',2),(14,4,'Fucidin Intertulle Dressing',584,1000,66,4000,20,'2018-10-24 08:44:20','2017-02-02','2018-10-31',2),(15,4,'Tetracycline Skin Ointment ',778,1000,100,222,2,'2018-10-24 08:47:06','2018-10-12','2018-10-13',2),(16,4,'HydrochlorothiazideTablets 25 mg',5155,2,2222,600,8,'2018-10-28 12:47:23','2018-10-11','2018-10-25',2),(17,4,'Bendrofluazide Tablets 2.5 mg, 5 mg',25,25,80,48,1,'2018-10-28 07:51:08','2017-11-06','2018-10-01',2),(18,14,'maloxzelamin capsule',1000,1000,66,79,3,'2018-11-04 04:02:06','2017-10-09','2018-02-24',2),(19,16,'jisaschbsdkj',556,556,336,522,2,'2018-11-04 04:15:39','2017-06-11','2018-07-09',2),(20,17,'fusindine tablet',556,556,212,226,8,'2018-11-04 04:19:08','2017-10-16','2018-11-17',2),(21,18,'abinclox',720,720,600,700,5,'2018-11-05 11:39:50','2018-05-08','2018-11-16',2),(22,4,'abinclox',720,780,600,700,5,'2018-11-15 07:58:26','2018-11-07','2018-11-09',2),(23,4,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',875,785,750,500,3,'2018-11-15 08:27:19','2018-03-13','2018-11-05',2),(24,5,'Methyldopa Tablets 250 mg, 500 mg',455,45,750,800,5,'2018-11-15 08:31:10','2017-12-04','2018-11-16',2),(25,4,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',1660,300,45,50,0,'2018-11-15 08:44:49','2018-11-01','2018-11-09',2),(26,4,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',1960,512,222,550,26,'2018-11-15 08:49:37','2018-11-07','2018-11-16',2),(27,5,'Methyldopa Tablets 250 mg, 500 mg',500,567,456,980,5,'2018-11-15 08:59:35','2018-11-20','2018-11-23',2),(28,4,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',2472,775,236,550,26,'2018-11-15 09:02:33','2018-11-06','2018-11-30',2),(30,22,'kioloxedropin',2,2,236,458,5,'2018-11-27 12:16:44','2018-11-01','2018-11-16',2),(31,11,'FBNDFNKNDFKJ',55,445,457,566,5,'2018-11-27 01:03:14','2018-11-14','2018-11-14',2),(32,5,'Methyldopa Tablets 250 mg, 500 mg',1067,788,142,980,5,'2018-11-27 01:04:33','2018-11-29','2018-11-14',2),(33,10,'DDDDDD',5,555,255,535,5,'2018-11-27 01:05:19','2018-11-13','2018-11-23',2),(34,18,'abinclox',1500,500,800,1000,3,'2018-11-27 01:08:31','2018-11-15','2018-11-22',2),(36,24,'hhjejejejejej',2,2,666,582,4,'2018-11-27 01:03:31','2018-11-21','2018-11-30',20),(37,12,'dddd',5,85,22,2,2,'2018-11-28 04:06:00','2018-11-15','2018-11-25',20);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-07 17:28:10
