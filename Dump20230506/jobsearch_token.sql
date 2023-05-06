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
INSERT INTO `token` VALUES (1,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlLmNvbSIsImlhdCI6MTY4MzQwNDY3MiwiZXhwIjoxNjgzNDA2MTEyfQ.oyeAW29z69kP3qA0tYcUWfdd0IiuiLdLEl8IQ7kq48A','BEARER',1),(2,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgzNDA0NzAwLCJleHAiOjE2ODM0MDYxNDB9.4EOV2GQs_VvNWEdNGCPbQQRxa5OuX8s4WBnvjwj8nU4','BEARER',2),(3,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlLmNvbSIsImlhdCI6MTY4MzQwNDkyNSwiZXhwIjoxNjgzNDA2MzY1fQ._cPx7VTI_4zz6LER5ECqQWGJV6SNMIvvmjXOhbhla40','BEARER',1),(4,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlLmNvbSIsImlhdCI6MTY4MzQwNDk2MSwiZXhwIjoxNjgzNDA2NDAxfQ.pZxLOpaXxFcS11k6Vde8UsiR34QxFO_fyO6qmBKgdRQ','BEARER',1),(5,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlLmNvbSIsImlhdCI6MTY4MzQwNDk5NywiZXhwIjoxNjgzNDA2NDM3fQ.7Tr72hzsD4UXRkdQiMJuZJsOogDVd8b5au8Uv_XCdTY','BEARER',1),(6,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgzNDA1MDQwLCJleHAiOjE2ODM0MDY0ODB9.RnRP0HhfEatp7-xvGPAiZxIR1n3KaAtu9u_Q8bRF4Qo','BEARER',2),(7,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlLmNvbSIsImlhdCI6MTY4MzQwNTA3MSwiZXhwIjoxNjgzNDA2NTExfQ.PzJB4qniRH0Ikv4GSWzAwit3i6cyT8wkXU8mpFsBGPM','BEARER',1);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-06 17:31:15
