-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: Charity
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `charity`
--

DROP TABLE IF EXISTS `charity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `charity` (
  `charityId` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `charityName` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postcode` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`charityId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `charity`
--

LOCK TABLES `charity` WRITE;
/*!40000 ALTER TABLE `charity` DISABLE KEYS */;
INSERT INTO `charity` VALUES (1,5,'Great Ormond Street Hospital','40 Bernard Street, London','WC1N 1LE'),(2,4,'GBritish Heart Foundation','Greater London House, 180 Hampstead Road, London','NW1 7AW'),(3,3,'Macmillan Cancer Support','89 Albert Embankment, London ','SE1 7UQ'),(4,6,'Cancer Research UK','Cancer Research UK\r\nPO BOX 1561\r\nOxford \r\n','OX4 9GZ'),(5,1,'St. John Ambulance','St John\'s Gate, Clerkenwell, London','EC1M 4DA'),(6,2,'Guide Dogs','Hillfields, Burghfield Common, Reading, Berkshire','RG7 3YG');
/*!40000 ALTER TABLE `charity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donation`
--

DROP TABLE IF EXISTS `donation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donation` (
  `donationId` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `projectId` int DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`donationId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation`
--

LOCK TABLES `donation` WRITE;
/*!40000 ALTER TABLE `donation` DISABLE KEYS */;
INSERT INTO `donation` VALUES (1,1,3,'test1',10,'2020-04-23'),(2,1,3,'test1',10,'2020-04-24'),(3,1,3,'test1',30,'2020-04-25'),(4,1,3,'test1',10,'2020-04-27'),(5,2,6,'123',10,'2020-04-29'),(6,1,3,'test1',10,'2020-05-03'),(7,1,5,'hello',10,'2020-05-05'),(8,1,2,'test',10,'2020-05-05'),(9,1,2,'test',10,'2020-05-05'),(10,1,2,'test',10,'2020-05-05'),(11,1,2,'test',10,'2020-05-05'),(12,1,4,'123213',10,'2020-05-07');
/*!40000 ALTER TABLE `donation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `projectId` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `charityId` int DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `expireDate` date DEFAULT NULL,
  `targetMoney` double DEFAULT NULL,
  `totalMoney` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,1,3,'test','2020-03-21','2020-04-01',3000,0,'1','1','https://twitter.com/share?text=123&url=http://localhost:8080/#/fundraise'),(2,3,3,'test','2020-03-30','2020-03-31',123,111,'0','123','https://twitter.com/share?text=test'),(3,3,3,'test1','2020-03-29','2020-06-17',123,350,'0','123','https://twitter.com/tweet?text=test1'),(4,3,3,'123213','2020-03-30','2020-06-28',123,180,'0','123','https://twitter.com/intent/tweet?text=123213'),(5,3,3,'hello','2020-04-23','2020-05-25',3000,60,'0','123','https://twitter.com/intent/tweet?text=hello'),(6,3,1,'123','2020-04-25','2020-05-18',11000,30,'0','123','https://twitter.com/intent/tweet?text=123');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleid` int NOT NULL AUTO_INCREMENT,
  `role` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_manager','manager'),(2,'ROLE_volunteer','volunteer'),(3,'ROLE_user','user'),(4,'ROLE_charity','charity');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription` (
  `subscriptionId` int NOT NULL AUTO_INCREMENT,
  `charityId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  `cycle` varchar(255) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`subscriptionId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (1,1,1,'MONTH','12','5','2020-05-06'),(2,3,1,'MONTH','12','5','2020-05-06'),(3,5,1,'MONTH','12','10','2020-05-05'),(4,6,1,'MONTH','12','3','2020-05-06');
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `roleId` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'zzhou','male','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm','7738427156','zzhou53@sheffield.ac.uk'),(2,2,'user','Male','$2a$10$y5HFs8ANdteysqJZxre0quDHUsb8xHnq.VfDSTSGfjNJbMUECv6pW','123','zzhou53@sheffield.ac.uk'),(3,4,'charity','Male','$2a$10$4sZOI4w3z5cmvLkKV.LHYOnZXbddemaaJSFkj3myW8pd0LkF00JWq','7738427156','zzhou53@sheffield.ac.uk'),(4,4,'test2','Male','$2a$10$6zgLJu/WRnYOOGlbCKNr0uMqRvk4hJSe7G4hbXr1ifwtjU4UPmox2','123','zzhou53@sheffield.ac.uk'),(5,3,'zzzhou','Male','$2a$10$0liIkeN.lCTQYN.wn.nrduGHHJroscmAaAlEtSlJ16DlMa9V7oGVS','7738427111','zzz@sheffield.ac.uk');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer` (
  `volunteerId` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `charityId` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `charityName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`volunteerId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES (1,2,3,'user1','test'),(2,2,3,'user2','Great Ormond Street Hospital'),(3,2,3,'user3','Great Ormond Street Hospital'),(4,2,3,'user4','Great Ormond Street Hospital'),(5,2,3,'user5','GBritish Heart Foundation'),(6,2,3,'user6','GBritish Heart Foundation'),(7,2,2,'user7','GBritish Heart Foundation'),(8,2,3,'user8','Macmillan Cancer Support');
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'Charity'
--

--
-- Dumping routines for database 'Charity'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-07 11:02:32
