CREATE DATABASE  IF NOT EXISTS `ecodb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ecodb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
<<<<<<< HEAD
-- Host: localhost    Database: aa
=======
-- Host: localhost    Database: ecodb
>>>>>>> dd5cbe0de0798db6fb10e5a8def592c8d306245d
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
  `pin` float DEFAULT NULL,
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
INSERT INTO `bike` VALUES (1,'xe đạp đua ajinomoto',0,1,1,1),(2,'xe đạp mini thống nhất',0,1,2,2),(3,'xe đạp đôi g3c yamaha',0,1,3,1),(4,'xe đạp điện suzuki',80,1,4,2);
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
INSERT INTO `category` VALUES (1,'Xe Đạp Đua',25000,1,2),(2,'Xe Đạp Thường',15000,2,2),(3,'Xe Đạp Đôi',30000,2,4),(4,'Xe Đạp Điện',35000,2,0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
<<<<<<< HEAD
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
=======
>>>>>>> dd5cbe0de0798db6fb10e5a8def592c8d306245d
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'dora','/','số 1 trần duy hưng'),(2,'nobi','/','số 1 trần đại nghĩa');
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
<<<<<<< HEAD
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
=======
  `rented_duration` float DEFAULT NULL,
  `user_id` int NOT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_transaction_user1_idx` (`user_id`),
>>>>>>> dd5cbe0de0798db6fb10e5a8def592c8d306245d
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
INSERT INTO `user` VALUES (1,'tandb','tandb@gmail.com','2022-01-04 17:38:28','0123456789'),(2,'longnd','longnd@gmail.com','2022-01-04 17:38:28','0213456789'),(3,'khanhdn','khanhdn@gmail.com','2022-01-04 17:38:28','0312456789');
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

<<<<<<< HEAD
-- Dump completed on 2022-01-05 12:14:00
=======
-- Dump completed on 2022-01-05 21:13:20
>>>>>>> dd5cbe0de0798db6fb10e5a8def592c8d306245d
