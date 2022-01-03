CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike` (
  `id` int NOT NULL,
  `bike_name` varchar(255) NOT NULL,
  `pin` float NOT NULL,
  `status` tinyint(1) NOT NULL,
  `category_id` int NOT NULL,
  `station_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bike_category1_idx` (`category_id`),
  KEY `fk_bike_station1_idx` (`station_id`),
  CONSTRAINT `fk_bike_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_bike_station1` FOREIGN KEY (`station_id`) REFERENCES `station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES (1,'Xe Đạp Đua 700c Maruishi Touring Master',80,1,24,1);
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `costs_per_hour` float DEFAULT NULL,
  `n_seats` int DEFAULT NULL,
  `n_pedals` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (24,'hai banh mot ban dap',24000,NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent` (
  `id` int NOT NULL,
  `startTime` timestamp NOT NULL,
  `endTime` timestamp NOT NULL,
  `user_id` int NOT NULL,
  `bike_id` int NOT NULL,
  `debit` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rentId_UNIQUE` (`id`),
  KEY `fk_rent_user1_idx` (`user_id`),
  KEY `fk_rent_bike1_idx` (`bike_id`),
  CONSTRAINT `fk_rent_bike1` FOREIGN KEY (`bike_id`) REFERENCES `bike` (`id`),
  CONSTRAINT `fk_rent_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station` (
  `id` int NOT NULL,
  `station_name` varchar(255) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `walkingTime` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'japan','abc','số 1 trần đại nghĩa',20),(2,'japan','abc','số 1 trần đại nghĩa',20);
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL,
  `total_payment` float DEFAULT NULL,
  `bike_name` varchar(45) DEFAULT NULL,
  `rented_duration` float DEFAULT NULL,
  `user_id` int NOT NULL,
  `rent_id` int NOT NULL,
  `bike_id` int NOT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_transaction_user1_idx` (`user_id`),
  KEY `fk_transaction_rent1_idx` (`rent_id`),
  KEY `fk_transaction_bike1_idx` (`bike_id`),
  CONSTRAINT `fk_transaction_bike1` FOREIGN KEY (`bike_id`) REFERENCES `bike` (`id`),
  CONSTRAINT `fk_transaction_rent1` FOREIGN KEY (`rent_id`) REFERENCES `rent` (`id`),
  CONSTRAINT `fk_transaction_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_phone_uindex` (`phone`),
  UNIQUE KEY `user_email_uindex` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-03 13:02:08
