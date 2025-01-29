CREATE DATABASE  IF NOT EXISTS `ITC114_Assessment_4_SQL` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_bin */;
USE `ITC114_Assessment_4_SQL`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: assignment4
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CUS_CODE` int(11) DEFAULT NULL,
  `CUS_LNAME` varchar(15) COLLATE latin1_bin DEFAULT NULL,
  `CUS_FNAME` varchar(15) COLLATE latin1_bin DEFAULT NULL,
  `CUS_INITIAL` varchar(1) COLLATE latin1_bin DEFAULT NULL,
  `CUS_AREACODE` varchar(3) COLLATE latin1_bin DEFAULT NULL,
  `CUS_PHONE` varchar(8) COLLATE latin1_bin DEFAULT NULL,
  `CUS_BALANCE` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (10010,'Ramas','Alfred','A','615','844-2573',0),(10011,'Dunne','Leona','K','713','894-1238',0),(10012,'Smith','Kathy','W','615','894-2285',345.86),(10013,'Olowski','Paul','F','615','894-2180',536.75),(10014,'Orlando','Myron','','615','222-1672',0),(10015,'O\'Brian','Amy','B','713','442-3381',0),(10016,'Brown','James','G','615','297-1228',221.19),(10017,'Williams','George','','615','290-2556',768.93),(10018,'Farriss','Anne','G','713','382-7185',216.55),(10019,'Smith','Olette','K','615','297-3809',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `EMP_NUM` int(11) DEFAULT NULL,
  `EMP_TITLE` varchar(4) COLLATE latin1_bin DEFAULT NULL,
  `EMP_LNAME` varchar(15) COLLATE latin1_bin DEFAULT NULL,
  `EMP_FNAME` varchar(15) COLLATE latin1_bin DEFAULT NULL,
  `EMP_INITIAL` varchar(1) COLLATE latin1_bin DEFAULT NULL,
  `EMP_DOB` date DEFAULT NULL,
  `EMP_HIRE_DATE` date DEFAULT NULL,
  `EMP_AREACODE` varchar(3) COLLATE latin1_bin DEFAULT NULL,
  `EMP_PHONE` varchar(8) COLLATE latin1_bin DEFAULT NULL,
  `EMP_MGR` char(3) COLLATE latin1_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (100,'Mr.','Kolmycz','George','D','1942-06-15','1985-03-15','615','324-5456',''),(101,'Ms.','Lewis','Rhonda','G','1965-03-19','1986-04-25','615','324-4472','100'),(102,'Mr.','VanDam','Rhett','','1958-11-14','1990-12-20','901','675-8993','100'),(103,'Ms.','Jones','Anne','M','1974-10-16','1994-08-28','615','898-3456','100'),(104,'Mr.','Lange','John','P','1971-11-08','1994-10-20','901','504-4430','105'),(105,'Mr.','Williams','Robert','D','1975-03-14','1998-11-08','615','890-3220',''),(106,'Mrs.','Smith','Jeanine','K','1968-02-12','1989-01-05','615','324-7883','105'),(107,'Mr.','Diante','Jorge','D','1974-08-21','1994-07-02','615','890-4567','105'),(108,'Mr.','Wiesenbach','Paul','R','1966-02-14','1992-11-18','615','897-4358',''),(109,'Mr.','Smith','George','K','1961-06-18','1989-04-14','901','504-3339','108'),(110,'Mrs.','Genkazi','Leighla','W','1970-05-19','1990-12-01','901','569-0093','108'),(111,'Mr.','Washington','Rupert','E','1966-01-03','1993-06-21','615','890-4925','105'),(112,'Mr.','Johnson','Edward','E','1961-05-14','1983-12-01','615','898-4387','100'),(113,'Ms.','Smythe','Melanie','P','1970-09-15','1999-05-11','615','324-9006','105'),(114,'Ms.','Brandon','Marie','G','1956-11-02','1979-11-15','901','882-0845','108'),(115,'Mrs.','Saranda','Hermine','R','1972-07-25','1993-04-23','615','324-5505','105'),(116,'Mr.','Smith','George','A','1965-11-08','1988-12-10','615','890-2984','108');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `INV_NUMBER` int(11) DEFAULT NULL,
  `CUS_CODE` int(11) DEFAULT NULL,
  `INV_DATE` date DEFAULT NULL,
  `INV_SUBTOTAL` float DEFAULT NULL,
  `INV_TAX` float DEFAULT NULL,
  `INV_TOTAL` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1001,10014,'2008-01-16',24.9,1.99,26.89),(1002,10011,'2008-01-16',9.98,0.8,10.78),(1003,10012,'2008-01-16',153.85,12.31,166.16),(1004,10011,'2008-01-17',34.97,2.8,37.77),(1005,10018,'2008-01-17',70.44,5.64,76.08),(1006,10014,'2008-01-17',397.83,31.83,429.66),(1007,10015,'2008-01-17',34.97,2.8,37.77),(1008,10011,'2008-01-17',399.15,31.93,431.08);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line`
--

DROP TABLE IF EXISTS `line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `line` (
  `INV_NUMBER` int(11) DEFAULT NULL,
  `LINE_NUMBER` int(11) DEFAULT NULL,
  `P_CODE` varchar(10) COLLATE latin1_bin DEFAULT NULL,
  `LINE_UNITS` float DEFAULT NULL,
  `LINE_PRICE` float DEFAULT NULL,
  `LINE_TOTAL` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `line`
--

LOCK TABLES `line` WRITE;
/*!40000 ALTER TABLE `line` DISABLE KEYS */;
INSERT INTO `line` VALUES (1001,1,'13-Q2/P2',1,14.99,14.99),(1001,2,'23109-HB',1,9.95,9.95),(1002,1,'54778-2T',2,4.99,9.98),(1003,1,'2238/QPD',1,38.95,38.95),(1003,2,'1546-QQ2',1,39.95,39.95),(1003,3,'13-Q2/P2',5,14.99,74.95),(1004,1,'54778-2T',3,4.99,14.97),(1004,2,'23109-HB',2,9.95,19.9),(1005,1,'PVC23DRT',12,5.87,70.44),(1006,1,'SM-18277',3,6.99,20.97),(1006,2,'2232/QTY',1,109.92,109.92),(1006,3,'23109-HB',1,9.95,9.95),(1006,4,'89-WRE-Q',1,256.99,256.99),(1007,1,'13-Q2/P2',2,14.99,29.98),(1007,2,'54778-2T',1,4.99,4.99),(1008,1,'PVC23DRT',5,5.87,29.35),(1008,2,'WR3/TT3',3,119.95,359.85),(1008,3,'23109-HB',1,9.95,9.95);
/*!40000 ALTER TABLE `line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `P_CODE` varchar(10) COLLATE latin1_bin DEFAULT NULL,
  `P_DESCRIPT` varchar(35) COLLATE latin1_bin DEFAULT NULL,
  `P_INDATE` date DEFAULT NULL,
  `P_QOH` int(11) DEFAULT NULL,
  `P_MIN` int(11) DEFAULT NULL,
  `P_PRICE` float DEFAULT NULL,
  `P_DISCOUNT` float DEFAULT NULL,
  `V_CODE` char(5) COLLATE latin1_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('23114-AA','Sledge hammer, 12 lb.','2008-01-02',8,5,14.4,0.05,''),('54778-2T','Rat-tail file, 1/8-in. fine','2007-12-15',43,20,4.99,0,'21344'),('89-WRE-Q','Hicut chain saw, 16 in.','2008-02-07',11,5,256.99,0.05,'24288'),('PVC23DRT','PVC pipe, 3.5-in., 8-ft','2008-02-20',188,75,5.87,0,''),('SM-18277','1.25-in. metal screw, 25','2008-03-01',172,75,6.99,0,'21225'),('SW-23116','2.5-in. wd. screw, 50','2008-02-24',237,100,8.45,0,'21231'),('WR3/TT3','Steel matting, 4\'x8\'x1/6\", .5\" mesh','2008-01-17',18,5,119.95,0.1,'25595'),('11QER/31','Power painter, 15 psi., 3-nozzle','2007-11-03',8,5,109.99,0,'25595'),('13-Q2/P2','7.25-in. pwr. saw blade','2007-12-13',32,15,14.99,0.05,'21344'),('14-Q1/L3','9.00-in. pwr. saw blade','2007-11-13',18,12,17.49,0,'21344'),('1546-QQ2','Hrd. cloth, 1/4-in., 2x50','2008-01-15',15,8,39.95,0,'23119'),('1558-QW1','Hrd. cloth, 1/2-in., 3x50','2008-01-15',23,5,43.99,0,'23119'),('2232/QTY','B&D jigsaw, 12-in. blade','2007-12-15',8,5,109.92,0.05,'24288'),('2232/QWE','B&D jigsaw, 8-in. blade','2007-12-24',6,5,99.87,0.05,'24288'),('2238/QPD','B&D cordless drill, 1/2-in.','2008-01-20',12,5,38.95,0.05,'25595'),('23109-HB','Claw hammer','2008-01-20',23,10,9.95,0.1,'21225'),('23114-AA','Sledge hammer, 12 lb.','2008-01-02',8,5,14.4,0.05,'');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `V_CODE` int(11) DEFAULT NULL,
  `V_NAME` varchar(15) COLLATE latin1_bin DEFAULT NULL,
  `V_CONTACT` varchar(50) COLLATE latin1_bin DEFAULT NULL,
  `V_AREACODE` varchar(3) COLLATE latin1_bin DEFAULT NULL,
  `V_PHONE` varchar(8) COLLATE latin1_bin DEFAULT NULL,
  `V_STATE` varchar(2) COLLATE latin1_bin DEFAULT NULL,
  `V_ORDER` varchar(1) COLLATE latin1_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (21225,'Bryson, Inc.','Smithson','615','223-3234','TN','Y'),(21226,'SuperLoo, Inc.','Flushing','904','215-8995','FL','N'),(21231,'D&E Supply','Singh','615','228-3245','TN','Y'),(21344,'Gomez Bros.','Ortega','615','889-2546','KY','N'),(22567,'Dome Supply','Smith','901','678-1419','GA','N'),(23119,'Randsets Ltd.','Anderson','901','678-3998','GA','Y'),(24004,'Brackman Bros.','Browning','615','228-1410','TN','N'),(24288,'ORDVA, Inc.','Hakford','615','898-1234','TN','Y'),(25443,'B&K, Inc.','Smith','904','227-0093',NULL,'N'),(25501,'Damal Supplies','Smythe','615','890-3529','TN','N'),(25595,'Rubicon Systems','Orton','904','456-0092','FL','Y');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'assignment5'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-11 14:05:25
