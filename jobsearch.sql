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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_user`
--

LOCK TABLES `_user` WRITE;
/*!40000 ALTER TABLE `_user` DISABLE KEYS */;
INSERT INTO `_user` VALUES (1,'rbailey@fakeemail.com',1,'$2a$10$mSUN7Qh8fQbwIxQLEcr3f.Y4m0PXo6gyI7QegTJ38536OaT/599YC','EMPLOYER'),(2,'twaffles@fakeemail.com',2,'$2a$10$AOV9s4TqvuT3cCGE4Y84rOPmHj8mzLsXpD8JSyHNRFU5JWLYPf7Gi','EMPLOYER'),(3,'eiglesias@fake.com',3,'$2a$10$c/r2gXQ.20fBx/9mBPt1w.CIr24ATZE/zZKpMEzsnaleDK13E3aB2','EMPLOYER'),(52,'jsampson@fakeemail.com',NULL,'$2a$10$zA3w5OcMxW9RoWy.C8qpieEJx/bodWTIkpPJ9woatO9FcSOcHIxQe','USER'),(53,'hstottlemeyer@fake.com',4,'$2a$10$lKLbazG8OrCFiQsS495nneDfrTj2sKFtK049ooxbqJi2l5c9TIoo6','EMPLOYER'),(102,'dwalters@fake.com',5,'$2a$10$XoB.p9Xp.n5OHwJQ8EbSCedcD6bQF7KNy.q5ws/mmaj5UwSOC.I1u','EMPLOYER');
/*!40000 ALTER TABLE `_user` ENABLE KEYS */;
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
INSERT INTO `_user_seq` VALUES (201);
/*!40000 ALTER TABLE `_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `is_admin` bit(1) NOT NULL,
  `is_employer` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (1,'Jessicas Ballet Studio'),(2,'Francis Tag Agency'),(3,'Fast Lane Bowling Alley'),(4,'Clear as mud consulting'),(19,'Walmart');
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
  `post_date` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `employer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnjbsumt44u8xps6yg5f16ynig` (`employer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (3,'duties of table buser','2023-04-22','table buser',2),(4,'duties of fast food worker','2023-04-23','Fast food worker 1',3),(21,'duties','2023-04-23','checkers player',2),(22,'duties','2023-04-23','chess player',2),(23,'duties','2023-04-23','monopoly player',2),(24,'duties','2023-04-23','memory player',2),(25,'duties','2023-04-23','majong player',2),(26,'duties','2023-04-23','sorry player',2),(27,'duties','2023-04-23','scrabble player',2),(29,'duties of computer imaging expert','2023-04-24','computer imaging expert',2),(30,'duties of story reader','2023-04-24','story reader',3),(31,'duties of badge officer','2023-04-24','badge officer',3),(32,'duties of security analyst','2023-04-24','security analyst',3),(33,'duties of architecture analyst','2023-04-24','architecture analyst',3),(34,'duties of architecture analyst 2','2023-04-24','architecture analyst 2',3),(35,'duties of architecture analyst 3','2023-04-24','architecture analyst 3',3);
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
INSERT INTO `token` VALUES (1,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2VlbWFpbC5jb20iLCJpYXQiOjE2ODIxMjEyMjcsImV4cCI6MTY4MjEyMjY2N30.hacnhNu1n2xjrb1kNqPevVVtGwPTp5eFeD9YG_TITqM','BEARER',1),(2,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTIxMzM5LCJleHAiOjE2ODIxMjI3Nzl9.nb2kIbRxXQ8rsq6oaiCGwRC18WW6K58sVaY_YdCa6LM','BEARER',2),(3,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWdsZXNpYXNAZmFrZS5jb20iLCJpYXQiOjE2ODIxMjYzNzIsImV4cCI6MTY4MjEyNzgxMn0._BUtM6kFrzx2Z6AjsJzZCo3G47kcpOyk88cpxKaRGuY','BEARER',3),(52,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTI3Mjg2LCJleHAiOjE2ODIxMjg3MjZ9.VLutdTWQgaH34YJbFeOMdTW01GscEY7imuccHidNpDo','BEARER',52),(53,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoc3RvdHRsZW1leWVyQGZha2UuY29tIiwiaWF0IjoxNjgyMTI3MzM1LCJleHAiOjE2ODIxMjg3NzV9.TCnTb5ELHmTjWufu7vng9wd8Fjy1UerszX9nLJwRC4c','BEARER',53),(102,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWdsZXNpYXNAZmFrZS5jb20iLCJpYXQiOjE2ODIxNDQ3NTcsImV4cCI6MTY4MjE0NjE5N30.8GiTMj1Q6OqMYcZGyjrua5_GleoNIMBTVP89p9Qd6cM','BEARER',3),(103,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTQ0ODIyLCJleHAiOjE2ODIxNDYyNjJ9.LoaslQ2whwbJVDlZVZ75h1Rik_WFjEfiovCZQ6zD66c','BEARER',2),(104,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTQ0ODg5LCJleHAiOjE2ODIxNDYzMjl9.lG65kD-hZxFsYgXtbRKlkeldChGRsbUWPQLn4tKO4wU','BEARER',52),(105,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTQ0ODk0LCJleHAiOjE2ODIxNDYzMzR9.SVEpC7QJGjqK47D89AQ0qInDap87ifGteYhD13THW6U','BEARER',52),(106,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTQ1MjQ1LCJleHAiOjE2ODIxNDY2ODV9.SjmVaEWh-1rdwdwm-EU4VCdyGmkTARhip5x8xqxUPfg','BEARER',2),(107,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTQ3MTU3LCJleHAiOjE2ODIxNDg1OTd9.5rU1ed6eKgOfjdfV0O7_NN_nWvDbDfVIZujzDWX2V2Y','BEARER',52),(108,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoc3RvdHRsZW1leWVyQGZha2UuY29tIiwiaWF0IjoxNjgyMTQ3NzE4LCJleHAiOjE2ODIxNDkxNTh9.wDRz3mVgZZto2H2WGq7p5Vr9TI2KHmgGdA6kP1CL7JU','BEARER',53),(109,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTQ4ODg5LCJleHAiOjE2ODIxNTAzMjl9.ijx5ZDrtGDsba5TONhgjZ7K8-F-w6vtGmmoi9wNmSh4','BEARER',2),(152,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTUxMTUzLCJleHAiOjE2ODIxNTI1OTN9.UFDramw0G9XrRFU-0p2rQOY8Gcnop4af3sJNe1To5bs','BEARER',2),(202,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTUyMzgwLCJleHAiOjE2ODIxNTM4MjB9.PNjSXNBQTRbLzYfiI_WoKPKDXwkZuQNqlhReg2ncKBY','BEARER',2),(252,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTUyNzcxLCJleHAiOjE2ODIxNTQyMTF9.S-kL6jSIJP558aCIMmcXLSliSZbhcNNfE7Ja7EG-BAg','BEARER',2),(302,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTY1MjA0LCJleHAiOjE2ODIxNjY2NDR9.r4eSDskJee8jpteN5bXlJ0ym-8qdtoqNkkapXvUq-iQ','BEARER',2),(303,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTY4MTM2LCJleHAiOjE2ODIxNjk1NzZ9.llpJpLy0ebl3K_WU_s-jrq5GXWetbXuE5ljnyZUixXA','BEARER',2),(352,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTc4MjA4LCJleHAiOjE2ODIxNzk2NDh9.YIAFEwDEmrM84LuRflgLJb0tBngeqQa5hlAViSSCBr8','BEARER',2),(402,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMTk5NjU3LCJleHAiOjE2ODIyMDEwOTd9.npRsKo_jqyZZ9EV1A1hphDLJzB4n0xY7_iQFfPg_6Ts','BEARER',2),(452,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjEzNzQ5LCJleHAiOjE2ODIyMTUxODl9.fHf0Y5VuQwWRnZB9kh4Wsi3elCmKtnQbJA3pf5JyBSI','BEARER',2),(502,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQwNzg5LCJleHAiOjE2ODIyNDIyMjl9.FO2ixgxFXoLTGSwML67ld9xmITMTjvRfM_erMxaVE-I','BEARER',2),(552,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQyMjE0LCJleHAiOjE2ODIyNDM2NTR9.NmUfFXHY8A21GHvLc5xV34se2oLk8OdMNghCNPd8ow8','BEARER',2),(602,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQzMTY3LCJleHAiOjE2ODIyNDQ2MDd9.qw8ZSWKe_Xecb7_lRtw1NzTHf1JPYs7JAQBxaLyjOQ8','BEARER',2),(652,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQzNjk3LCJleHAiOjE2ODIyNDUxMzd9.U0hxImREl_EPQmuJf_QHvdBlxocBaxEYeAgjzLXfeNg','BEARER',2),(702,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQ0NDQ1LCJleHAiOjE2ODIyNDU4ODV9.OID5UKBh3v6q8Z5hxZMr-j9hmQ56h-bMEnP7HD9B5rw','BEARER',2),(752,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQ1MjE1LCJleHAiOjE2ODIyNDY2NTV9.ED517qcokUTavxBQu3vHAX_ZFcOKXwDujIa7P92tUjk','BEARER',2),(753,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQ2OTA1LCJleHAiOjE2ODIyNDgzNDV9.j4VfW1KOrakRp3QXrkOzEC25QQg2WNLiaUuNQVVmc90','BEARER',2),(802,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQ4NjEwLCJleHAiOjE2ODIyNTAwNTB9.3UOLOCh38VoYhQw86JekFgWuoixnGqd8LQovi7NEJKI','BEARER',2),(803,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjQ5MDg0LCJleHAiOjE2ODIyNTA1MjR9.YZsCna4UlIPtW39bbVk_pU7QUxjltxeZyJEFGHn_468','BEARER',2),(852,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjY5MzUyLCJleHAiOjE2ODIyNzA3OTJ9.N7Ym7MiGfhkxdyOBRzAMIBZlEXmRw-Q1MTIGDnZAfwQ','BEARER',2),(902,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjczMDYwLCJleHAiOjE2ODIyNzQ1MDB9.NbKy1Aw4fhn7KcYIQOJgrK2jTIMkoTiYsuXet19TXk8','BEARER',2),(952,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjc2MDIxLCJleHAiOjE2ODIyNzc0NjF9.FVFxM6H-vOok-qGqClyUy8MWe2lzWU6Q36rPCNW1v5E','BEARER',2),(1002,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjc3NTg4LCJleHAiOjE2ODIyNzkwMjh9.I4jpzqKY5SvqRmk1SDVcU9zeLbWpYJWiu097-8wpwRY','BEARER',2),(1052,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjg1OTQxLCJleHAiOjE2ODIyODczODF9.yhx12a1HSmrGe62kBR3SAH_wHtCGa1bMO-FUjqu-PpM','BEARER',2),(1102,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjg3OTI3LCJleHAiOjE2ODIyODkzNjd9.zpe9ngwzBPOUg7uswtCJlOSy2CXYuap6sdcfq6_WZrQ','BEARER',2),(1152,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjg5OTkzLCJleHAiOjE2ODIyOTE0MzN9.mx_I9586md1_MZLc2Tak_U0fJSVv73aEbarVxmcOJKA','BEARER',2),(1202,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjkyMTg1LCJleHAiOjE2ODIyOTM2MjV9.P44NOjTYhRionU8APKSmqenc0IfFKHGYFaQcKsU6ZyM','BEARER',2),(1203,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMjkzMDg5LCJleHAiOjE2ODIyOTQ1Mjl9.HPOiWY-GdUv1jfz6AjonUpZIEItA-cFmc8kvOfsX63g','BEARER',2),(1252,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMzEzMzE1LCJleHAiOjE2ODIzMTQ3NTV9.BRPtgtaAMiPb6yB1bZNVrmTWibg1xzVolwWQKO_Ti3A','BEARER',2),(1253,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMzE0MjA1LCJleHAiOjE2ODIzMTU2NDV9.vBVMnff_t54v2M4RaHPe6WF7Yvx1vWsJVNVDyKnX-lA','BEARER',2),(1254,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMzE1MTAyLCJleHAiOjE2ODIzMTY1NDJ9.L219UOYDpzpHLMMobNvjP5aoD1cPGVzFbsC7XO2PmC8','BEARER',2),(1255,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaWdsZXNpYXNAZmFrZS5jb20iLCJpYXQiOjE2ODIzMTc1NDEsImV4cCI6MTY4MjMxODk4MX0.FJF0YRAxANIxhO-ZIOT4FcWE5u9WfaW9amo5CV5Yl1g','BEARER',3),(1256,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMzE4NjcwLCJleHAiOjE2ODIzMjAxMTB9.A9nOS3QT0bHpBRF22wqL0LhG2WiNS3bCVwF9KKNq3J0','BEARER',2),(1257,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyMzE5MzY4LCJleHAiOjE2ODIzMjA4MDh9.MKawiUauyV36LvjdVkU4_o7ZlMdZ0INKVxK1ye5n1k8','BEARER',2),(1302,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkd2FsdGVyc0BmYWtlLmNvbSIsImlhdCI6MTY4MjM1OTYwNywiZXhwIjoxNjgyMzYxMDQ3fQ.e39Wmklmf-YS7-D_gcAqmeOCfYgoItcbt2iIOsuNDno','BEARER',102),(1352,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDA1Mjk1LCJleHAiOjE2ODI0MDY3MzV9.Q8P10q70i3sGBTLz9AsCIV7NSjiA13qoBspmK1er0pY','BEARER',2),(1353,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDA2MjQwLCJleHAiOjE2ODI0MDc2ODB9.KLeNq0X-OZ8TnimScHW46OFDh5F47hjFZzDHo8ZhnPI','BEARER',2),(1402,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDYyMDcyLCJleHAiOjE2ODI0NjM1MTJ9.HQ_ePMEjauW-cT0sUvVCsXgO2Ko-jOf_pbTni30OSu8','BEARER',2),(1403,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDY0MjAwLCJleHAiOjE2ODI0NjU2NDB9.WJr10wrcwUB6jwyvohrgIyoydZwFyVvaq-efX1W3srw','BEARER',2),(1404,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDY0NDgyLCJleHAiOjE2ODI0NjU5MjJ9.WfdCQjG5s0vy16flgjUIAkEI2s68l6CWp1W1pe9tQ_A','BEARER',2),(1405,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDY1OTM2LCJleHAiOjE2ODI0NjczNzZ9.iUGT_sOdBIHugzaAT_5SNjWM3lySQHeg9HfRflS1yH8','BEARER',2),(1452,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0d2FmZmxlc0BmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDY3Njg0LCJleHAiOjE2ODI0NjkxMjR9.Y-u26QZzhmR7AYc_e0x14TkCbMqMtUTwD31nl4mvH5Q','BEARER',2),(1453,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoc3RvdHRsZW1leWVyQGZha2UuY29tIiwiaWF0IjoxNjgyNDY3NzQ5LCJleHAiOjE2ODI0NjkxODl9.MG4aaCqW7rBojTPG9SjXKpIypLqyLL2Zoh109cZSWyc','BEARER',53),(1502,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDcwOTQ5LCJleHAiOjE2ODI0NzIzODl9.6xFKPJoJJr55PIXtMRaoatNvqEABru1WB1zyi9vUI_8','BEARER',52),(1503,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDcxMjg5LCJleHAiOjE2ODI0NzI3Mjl9.aJGFW0znOuN8aClTzi4aeaavDqSaO-mdJaDtVitcgaw','BEARER',52),(1504,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDcxNTAzLCJleHAiOjE2ODI0NzI5NDN9.cqcOGl7ERWCvHfCsanoN94eHoCJHhDbuwsxIU4qJKms','BEARER',52),(1552,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDkwMjA0LCJleHAiOjE2ODI0OTE2NDR9.C0y5FgJnwiRMOCYzZIChtCchhpjF56iCf0C_bdBukQ4','BEARER',52),(1553,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDkwMjk3LCJleHAiOjE2ODI0OTE3Mzd9.Zmcw-yFreC3KRzCLm_SJpsk1CkyM1DluBd9TeW0RtzQ','BEARER',52),(1554,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDkyNjQzLCJleHAiOjE2ODI0OTQwODN9.ZVyZ-eMJWinjfIOof0NFfLi7noA_TG_XCUUq3eRGhdw','BEARER',52),(1555,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDkzNTAxLCJleHAiOjE2ODI0OTQ5NDF9.clk2xomuklrmEAyvPFZ1D6KLUOYnR_5rd3rtrWfxmmw','BEARER',52),(1556,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDk0MTIyLCJleHAiOjE2ODI0OTU1NjJ9.DR3wCwb8eJeWpRkkSyUHRG97NK1TlNmA64D0iG7rY3c','BEARER',52),(1602,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDk3MTA2LCJleHAiOjE2ODI0OTg1NDZ9.0tV3JIJVF4_1Yjk9Vco50i89xNxb_Of5MFSUuXRHQxE','BEARER',52),(1603,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDk3NTkxLCJleHAiOjE2ODI0OTkwMzF9.UDMWBdRf28b747QdBOzvkDblFt8GmZbAM1pBJEFCX88','BEARER',52),(1604,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlZW1haWwuY29tIiwiaWF0IjoxNjgyNDk5MzA5LCJleHAiOjE2ODI1MDA3NDl9.Kv9bgOOkiJzFpRyBDKYNvM9fyimwqtv86c-U2_7kFVA','BEARER',52);
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
INSERT INTO `token_seq` VALUES (1701);
/*!40000 ALTER TABLE `token_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_job`
--

DROP TABLE IF EXISTS `user_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_job` (
  `user_id` int NOT NULL,
  `job_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`job_id`),
  KEY `FKia2o1pm0plymfbt26ps56ox5l` (`job_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_job`
--

LOCK TABLES `user_job` WRITE;
/*!40000 ALTER TABLE `user_job` DISABLE KEYS */;
INSERT INTO `user_job` VALUES (2,22),(52,4),(52,21);
/*!40000 ALTER TABLE `user_job` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-26 11:34:23
