-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: jobsearch
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `_user`
--

DROP TABLE IF EXISTS `_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_user` (
  `id` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `employer_id` int DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `serial_version_uid` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_user`
--

LOCK TABLES `_user` WRITE;
/*!40000 ALTER TABLE `_user` DISABLE KEYS */;
INSERT INTO `_user` VALUES (1,'jax21@fake.com',NULL,'$2a$10$LraqW2fa3nsbPw31buIw5.klZh7l7RcuVF2WPEvn0CZvJ.WZY/BjC','USER',1234),(2,'jax22@fake.com',NULL,'$2a$10$9R4mB3wTUBL9qm/g0iLnKO01ZiQ7B1ZaoNmqzC6fEZ8ln4pdc7/DG','USER',1234),(3,'jax1@fake.com',1,'$2a$10$NzDc/vAXUMgbgf6J2L/MdeGX1ev/1vCP5tXct82BF2S7eUvccjbSK','EMPLOYER',1234),(4,'jax2@fake.com',2,'$2a$10$dZX313qSkVjcgeLliVHlc.YsG/eur2UMeG0c3cJcaJkrrg0SOPN8C','EMPLOYER',1234);
/*!40000 ALTER TABLE `_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `_user_jobs`
--

DROP TABLE IF EXISTS `_user_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_user_jobs` (
  `applicants_id` int NOT NULL,
  `jobs_id` int NOT NULL,
  PRIMARY KEY (`applicants_id`,`jobs_id`),
  KEY `FKcqdv9i7os3aay74cxw66sn1o3` (`jobs_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_user_jobs`
--

LOCK TABLES `_user_jobs` WRITE;
/*!40000 ALTER TABLE `_user_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `_user_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `_user_seq`
--

DROP TABLE IF EXISTS `_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_user_seq`
--

LOCK TABLES `_user_seq` WRITE;
/*!40000 ALTER TABLE `_user_seq` DISABLE KEYS */;
INSERT INTO `_user_seq` VALUES (101);
/*!40000 ALTER TABLE `_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `id` int NOT NULL AUTO_INCREMENT,
  `applicant_id` int NOT NULL,
  `job_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,1,1),(2,1,4);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (1,'rock'),(2,'paper');
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `employer_id` int NOT NULL,
  `post_date` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'duties',1,'2023-07-13','window washer'),(2,'duties',1,'2023-07-13','construction worker I'),(3,'duties',2,'2023-07-13','computer programmer 3'),(4,'duties',2,'2023-07-13','jelly bean counter'),(5,'duties',2,'2023-07-13','balloon animal entertainer');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` int NOT NULL,
  `expired` bit(1) NOT NULL,
  `revoked` bit(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiblu4cjwvyntq3ugo31klp1c6` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI3MzU2NywiZXhwIjoxNjg5Mjc1MDA3fQ.2PzFlvH3SH4VOBuTTTszTlKtOehmPL_9pObS0FZuIUA','BEARER',1),(2,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMkBmYWtlLmNvbSIsImlhdCI6MTY4OTI3MzU3MywiZXhwIjoxNjg5Mjc1MDEzfQ.K5FNEtjoFLr_z9vrQazqdtVTDrZb5wLN84AaHeaydUg','BEARER',2),(3,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgxQGZha2UuY29tIiwiaWF0IjoxNjg5MjczNTgzLCJleHAiOjE2ODkyNzUwMjN9.ACG9M7bKUeIKBsGcfrS1Qshybtw29qVUQe8K2jHmtBE','BEARER',3),(4,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyQGZha2UuY29tIiwiaWF0IjoxNjg5MjczNTkwLCJleHAiOjE2ODkyNzUwMzB9.LP_oaw1ZtvoLtdKw60TBjIyMLUViCRSjM_Eo4cPHINI','BEARER',4),(5,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI3NDY0MiwiZXhwIjoxNjg5Mjc2MDgyfQ.PFEie5xLEB36h3xXjXiJBNJPhdAWJPe_d99QjcLTnuQ','BEARER',1),(6,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgxQGZha2UuY29tIiwiaWF0IjoxNjg5Mjc0NzYzLCJleHAiOjE2ODkyNzYyMDN9.6OzcanwdxtnrdOuizXl35eSBD0UjMZM1s6YyGWe-4Js','BEARER',3),(7,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI3NDkxMCwiZXhwIjoxNjg5Mjc2MzUwfQ.b2bidKMLowoqGFfgPVESUupPA4KG_2mfMilZ7advXNU','BEARER',1),(8,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI3NDk3NiwiZXhwIjoxNjg5Mjc2NDE2fQ.lv3nkyX-86N90aMmnAwd2_1tEeYgzY1pIJe6qcDkRLU','BEARER',1),(9,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI3NjUwNiwiZXhwIjoxNjg5Mjc3OTQ2fQ.0rmfvQqe9n3B4evPWkaLctmrfJ5VfVD3-BkgecvflEM','BEARER',1),(10,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI3Njg5NCwiZXhwIjoxNjg5Mjc4MzM0fQ.KveDZmM2iw2oDGFuCNYPh5EYVirTYv5nTU3k5oSv2LM','BEARER',1),(11,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI4MDU0NSwiZXhwIjoxNjg5MjgxOTg1fQ.Zxd22y7ZrXlEIYOn7c76mBbDnVKIyFKbM44LMySTEbM','BEARER',1),(12,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI4MTI2MSwiZXhwIjoxNjg5MjgyNzAxfQ.pThI9-Fss4TFnVs32rQfU8QnuidE9ODI0LKah4yh3ss','BEARER',1),(13,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI4MTgyNywiZXhwIjoxNjg5MjgzMjY3fQ.DzyHrZY5daABABNBKZqVu1UvPSxEVO63_RJlJzlC4pI','BEARER',1),(14,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI4MjkzOCwiZXhwIjoxNjg5Mjg0Mzc4fQ.B-XE1j8YGVx1_sfMZ6-3qbcO02pZ_tm91syDUk-ZDUA','BEARER',1),(15,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI4MzQ1MSwiZXhwIjoxNjg5Mjg0ODkxfQ.Bl80R5f3MoNCvEB0g_IQTrnNuzgkK8h0ST5vJorRYdA','BEARER',1),(16,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgxQGZha2UuY29tIiwiaWF0IjoxNjg5MjgzODI1LCJleHAiOjE2ODkyODUyNjV9.tjVywpeIbAzj6SvNkjHH74nu9YkkJ_RRrG1QEpKOnOU','BEARER',3),(17,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyQGZha2UuY29tIiwiaWF0IjoxNjg5MjgzODUxLCJleHAiOjE2ODkyODUyOTF9.pI1gz-DIM9cJVC78ADjcIjOUU-tZl-lj1HFuIONTeUE','BEARER',4),(18,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXgyMUBmYWtlLmNvbSIsImlhdCI6MTY4OTI4MzkxOSwiZXhwIjoxNjg5Mjg1MzU5fQ.mjHau5sjpqms3F-_KfnJX-6HmI0sTzvXboTNhLaqcyA','BEARER',1);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token_seq`
--

DROP TABLE IF EXISTS `token_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token_seq`
--

LOCK TABLES `token_seq` WRITE;
/*!40000 ALTER TABLE `token_seq` DISABLE KEYS */;
INSERT INTO `token_seq` VALUES (101);
/*!40000 ALTER TABLE `token_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-14  0:32:53
