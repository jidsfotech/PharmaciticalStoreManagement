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
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `idMedicine` int(11) NOT NULL AUTO_INCREMENT,
  `MedicineName` varchar(45) DEFAULT NULL,
  `QuantityInStore` int(11) DEFAULT NULL,
  `SalePrice` int(11) DEFAULT NULL,
  `InterestRate` int(11) DEFAULT NULL,
  `Manufacturer` varchar(45) DEFAULT NULL,
  `idMedCategory` int(11) NOT NULL,
  `idMedGroup` int(11) NOT NULL,
  PRIMARY KEY (`idMedicine`),
  KEY `idMedGroup_idx` (`idMedGroup`),
  KEY `idMedCategory_idx` (`idMedCategory`),
  CONSTRAINT `idMedCategory` FOREIGN KEY (`idMedCategory`) REFERENCES `medcategory` (`idMedCategory`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idMedGroup` FOREIGN KEY (`idMedGroup`) REFERENCES `medgroup` (`idMedGroup`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'Bendrofluazide Tablets 2.5 mg, 5 mg',50,48,1,'jidsfotech',1,1),(2,'Frusemide Tablets 40 mg',10000,2700,24,'dulyxinternayional',1,1),(3,'HydrochlorothiazideTablets 25 mg',5157,600,8,'sabeb',1,1),(4,'Bendrofluazide 5mg/Reserpine 0.15 mg Tabs. ',3247,550,26,'kentlab',2,2),(5,'Methyldopa Tablets 250 mg, 500 mg',1855,980,5,'masantes',2,2),(6,'Hydralazine Tablets 25 mg',552,86,NULL,'flavera',2,2),(7,'Fucidin Intertulle Dressing',2372,4000,20,'blagaga',3,3),(8,'Silver Sulphadiazine Cream 1%',845,23,NULL,'jidsfotech',3,3),(9,'Tetracycline Skin Ointment ',2333,222,2,'sabeb',3,3),(10,'DDDDDD',560,535,5,'DDDDDD',2,2),(11,'FBNDFNKNDFKJ',500,566,5,',NB,MNBFGN.',2,1),(12,'dddd',90,2,2,'sss',1,1),(13,'tetratcycline ',500,80,5,'alabama pharmacitical ltd.',3,1),(14,'maloxzelamin capsule',1000,79,3,'krox paharmacitical ltd.',2,2),(15,'mmmmmmmmmmmmmm',562,225,23,'mdddkksdlmmmmmmmmb.bdsnf.',4,3),(16,'jisaschbsdkj',556,522,2,'kjsdkkfhshlkhglnnjklj',2,3),(17,'fusindine tablet',556,226,8,'fusma international limiited ',3,1),(18,'abinclox',2000,1000,3,'lamadraskang international limited ',2,1),(19,'exiplon expectorant',700,540,5,'expiloiraty internationa',3,2),(20,'sssss',333,222,333,'ssss',1,3),(21,'lafagastinayvlilo',4,258,2,'hlogstack international ',2,2),(22,'kioloxedropin',2,458,5,'maigraticolo inernational ',3,2),(23,'majajakiaoanshs',5,789,4,'nhxhdhdhgdgfdb',3,1),(24,'hhjejejejejej',2,582,4,'nncbcbchchcbcbchc',2,3);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
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
