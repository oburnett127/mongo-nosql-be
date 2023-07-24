-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: socialmedia
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
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
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
INSERT INTO `_user` VALUES (1,'rbailey@fake.com','Richard','Bailey','$2a$10$uTdDOqFWOl2j2DIQFHcbye2vLweQbD2/OHZmvG9rDxKcK5OmGcgVO','USER',1234),(2,'wtaylor@fake.com','William','Taylor','$2a$10$dj85ydFgvxkddUB2RRM1gOD8RqMH6dMYVZ086IsKcExm9uSGVdGD6','USER',1234),(3,'jsampson@fake.com','Jeremiah','Sampson','$2a$10$zUyEXJp07Q.zlNSb4iUh9OUeJxHyuZENEsUi/PHfTAEfclXl3rB8q','USER',1234),(52,'wsmith@fake.com','William','Smith','$2a$10$zTSaFUZ9Yg18t.I7RB1laeUbwbBLD9HybrpOkGI1ubX87uDWlJqpC','USER',1234);
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
INSERT INTO `_user_seq` VALUES (151);
/*!40000 ALTER TABLE `_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `block`
--

DROP TABLE IF EXISTS `block`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `block` (
  `block_id` int NOT NULL AUTO_INCREMENT,
  `blocked_user_id` int NOT NULL,
  `blocker_user_id` int NOT NULL,
  PRIMARY KEY (`block_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block`
--

LOCK TABLES `block` WRITE;
/*!40000 ALTER TABLE `block` DISABLE KEYS */;
INSERT INTO `block` VALUES (9,52,2);
/*!40000 ALTER TABLE `block` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `text` varchar(255) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friend` (
  `friend_id` int NOT NULL AUTO_INCREMENT,
  `from_user_id` int NOT NULL,
  `status` smallint NOT NULL,
  `to_user_id` int NOT NULL,
  PRIMARY KEY (`friend_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` VALUES (13,3,0,1);
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(255) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'hello',1),(2,'a long long time ago',1),(3,'This is post num 1 by Jeremiah',3),(4,'This is Jeremiah\'s second post.',3);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
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
INSERT INTO `token` VALUES (1,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjg5OTMzNDg5LCJleHAiOjE2ODk5MzQ5Mjl9.R0W1-OtgecN9v0Kltu6nyrd1xHZME3BfF0a0JI4IwzI','BEARER',1),(2,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3dGF5bG9yQGZha2UuY29tIiwiaWF0IjoxNjg5OTYwNDkwLCJleHAiOjE2ODk5NjE5MzB9.H49qi6zcxvhf60FZLLgWmX5sD10sUNV3E7rFo0v5-XU','BEARER',2),(3,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk2MDUxNywiZXhwIjoxNjg5OTYxOTU3fQ.etD_pYwbiECZHJFzVr4qZZl5n4sYpeyMu4U3svOjKBs','BEARER',3),(52,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk2MjI1NiwiZXhwIjoxNjg5OTYzNjk2fQ.eAfE5sihA4BeY1yMOpxio_pv3kL4uU2JEufJW5QAoFE','BEARER',3),(102,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk2NDU0NiwiZXhwIjoxNjg5OTY1OTg2fQ.S_HpB7mdmFSWTXaizqmCIdYdy2A5T1wM4Vl2ZkpzgkI','BEARER',3),(103,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk2NTI2NCwiZXhwIjoxNjg5OTY2NzA0fQ.xM8FtD-p-wPYckKuxeBRX2naUlXY25q42OarqlBXvCQ','BEARER',3),(152,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjg5OTY2NTgzLCJleHAiOjE2ODk5NjgwMjN9.COQZZXI67bKg2Ng6cjGL7qKnDX-e_0KaKjKefaRVotM','BEARER',1),(153,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk2NjYyNSwiZXhwIjoxNjg5OTY4MDY1fQ.yivMuE-23XTqBhHP7n0QFzpevNIXGFTm5uJ_sLVWlp0','BEARER',3),(202,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk2NzAzNywiZXhwIjoxNjg5OTY4NDc3fQ.6SsNTQ2d4PhuMXfBS2zsiMcGyHTJZKMak--bw7okkS8','BEARER',3),(252,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk3MjA2MywiZXhwIjoxNjg5OTczNTAzfQ.p33t_o3obiM6IMCnS1Lv3U3CYtYHF97CWlhT1tl3yOo','BEARER',3),(302,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY4OTk3MjI3OCwiZXhwIjoxNjg5OTczNzE4fQ.5O-ocAza_JZ0fGfV06JMUkFO0y46KGzO9-0o-p4QKvQ','BEARER',3),(352,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjg5OTcyNDY5LCJleHAiOjE2ODk5NzM5MDl9.o_FoHQ6XdKZwUyOxAcnQeYnEcLZwMfgl9TX3kj0ag9o','BEARER',1),(402,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDAxNjE0NywiZXhwIjoxNjkwMDE3NTg3fQ.9TLxoAh1--9wRnUVHrkFcjjq8-4GpYpRHT_sEtk1EnY','BEARER',3),(452,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDAzODgwMSwiZXhwIjoxNjkwMDQwMjQxfQ.ClhP3ub47id8h4rKdCK5ULgouAKvZurV03Hxyy0waQM','BEARER',3),(453,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDAzOTMyMiwiZXhwIjoxNjkwMDQwNzYyfQ.RxbQHC8q3OuYZimq1hg4z_7X0EVa8fAv7jcjo-aQ6ec','BEARER',3),(454,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0MDIwNiwiZXhwIjoxNjkwMDQxNjQ2fQ.UJaFZ5252PNTXMTi_MAC5glZzFfM8EIf-mEOG00Db5U','BEARER',3),(455,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0MjM2MSwiZXhwIjoxNjkwMDQzODAxfQ.QbKnxbP9Qf_8h4Ix1S0zcDw4beV5XvbrA0PWQQjWdrE','BEARER',3),(456,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0Mjc3MiwiZXhwIjoxNjkwMDQ0MjEyfQ.Oz0uNWAXVJX5wST00Y0yht2DHTwfuaDcQqUXrSCgusg','BEARER',3),(457,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0MzIzMiwiZXhwIjoxNjkwMDQ0NjcyfQ.FJ_Y8LWMp0UPJLmarufAkLnYl3LeVpTk-G9_LVri4tw','BEARER',3),(458,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0NDY5MSwiZXhwIjoxNjkwMDQ2MTMxfQ.GZ7xvL08iNl8o7PAYg7Kw8eIodVbOjUVvZIXkleVIUA','BEARER',3),(459,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0NDczNCwiZXhwIjoxNjkwMDQ2MTc0fQ.SvjVP6NnjSzR5B4GLIlFljY1zyP9IovwgpOUSZXnge0','BEARER',3),(460,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0NzM2NSwiZXhwIjoxNjkwMDQ4ODA1fQ.4vMuCZF6nFAg6O66XVpHnwoJ-pO3tKVyjGcaFnNn-c4','BEARER',3),(461,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0ODUxMywiZXhwIjoxNjkwMDQ5OTUzfQ.Dx26OMTXz1MVXFXktI21_fOFwVKtvKn3W863g1x404U','BEARER',3),(462,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0ODg1MywiZXhwIjoxNjkwMDUwMjkzfQ.1LAUOgLTyIv86ba23y0dnqUgZXtq14fld6pGzVNsC9Y','BEARER',3),(463,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA0ODkzMSwiZXhwIjoxNjkwMDUwMzcxfQ.Rsjymoowa77pRhpeWxkbBblpAnLwAfpyXsTfRdw10_E','BEARER',3),(464,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3c21pdGhAZmFrZS5jb20iLCJpYXQiOjE2OTAwNDk5MzIsImV4cCI6MTY5MDA1MTM3Mn0.9ULEeOGlPO_e5unlQWGk2O_EoB_Ja-MCzBfxQc_NpUU','BEARER',52),(502,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA1MTM3NywiZXhwIjoxNjkwMDUyODE3fQ.E6NXo08_Qh53au9A5I8gyS62iCmMaFYCWYWIM6JwR0s','BEARER',3),(552,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA1Mzg4OCwiZXhwIjoxNjkwMDU1MzI4fQ.P7o49nnO_3s4rwJSbHnoB4-qzyGaPrLWUuU_diDoV24','BEARER',3),(602,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA1NDcwNCwiZXhwIjoxNjkwMDU2MTQ0fQ.DsPfcmW6JLOk9IpqX0lf0kZD2UIiAGvF9KEMvm2FzKM','BEARER',3),(603,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3c21pdGhAZmFrZS5jb20iLCJpYXQiOjE2OTAwNTU1ODYsImV4cCI6MTY5MDA1NzAyNn0.OTlOKUdnjP3c_ZO5BrjclsxJTWfHji6RhFkvvGmHSkE','BEARER',52),(604,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjkwMDU1NjY4LCJleHAiOjE2OTAwNTcxMDh9.mcUoF4Z0E7fmgGgS8Is6m1KaUdQ2dAA-8rf1BECdgOM','BEARER',1),(652,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA2MjMwNCwiZXhwIjoxNjkwMDYzNzQ0fQ.dbsWX4iqHheS50FkQGX6Ck6Xe_-DSFy1w1Pkxy1yJDE','BEARER',3),(702,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA3MDM5OCwiZXhwIjoxNjkwMDcxODM4fQ.zkd2t8p9sZL8uhBFrN_AW_0CVcyrRCHje8d-7_C2R0A','BEARER',3),(703,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA3MTA4MSwiZXhwIjoxNjkwMDcyNTIxfQ.IAvIUOeNOVCG6qL0iH4eyPhQ3NtJf_gNQjGqm9DvA4M','BEARER',3),(704,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA3NDA0MiwiZXhwIjoxNjkwMDc1NDgyfQ.J5tK_IrOPGHqJzaMdXQh0pM8SlZLhQUcFXgk5WCUXxM','BEARER',3),(705,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDA3NDkwNiwiZXhwIjoxNjkwMDc2MzQ2fQ.mHZs1N1jUnXVZgEjxwUxl7aQVzycXfHnKZ1HkhSZp70','BEARER',3),(752,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEwNzI4MywiZXhwIjoxNjkwMTA4NzIzfQ.wrehhjFmcUrct9i4chu-DC9WkxKEv6CoIadvYW667Vk','BEARER',3),(802,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEwODQ0MCwiZXhwIjoxNjkwMTA5ODgwfQ.9vPTCZ5EfSWNf81XE8GREsxxR187Lhmsgn2IJBPeSJM','BEARER',3),(803,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyMDQxOSwiZXhwIjoxNjkwMTIxODU5fQ.WD0OqYNjo1sKZLhYF4Mo5SNX5vvZlCjKcipzzH4elCo','BEARER',3),(804,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyMDUwNCwiZXhwIjoxNjkwMTIxOTQ0fQ.ura6Eafjl1FoXbqzRC_E7HNlf3_dGNETHwcdyTNA8Po','BEARER',3),(805,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyMTA2OSwiZXhwIjoxNjkwMTIyNTA5fQ.lvUyBb8v_rafyoJSpE4tY1N1AQRVp9zS-LkLhwKBPFU','BEARER',3),(806,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyNTI1MCwiZXhwIjoxNjkwMTI2NjkwfQ.fPo-D1_yhuTpvgk60w2ot8FMwrtjCZGgrTabI46xyxc','BEARER',3),(807,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyNTc3OSwiZXhwIjoxNjkwMTI3MjE5fQ.EWr1tvacOvqHQ_JGdnPrjVg53sF5jg2FcaD3GPLbtkU','BEARER',3),(808,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyNjUxMywiZXhwIjoxNjkwMTI3OTUzfQ.476D54S73JP6d1-R4l-owpGAcrQ3dapp17FeCiKBk9g','BEARER',3),(809,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyNjc0MywiZXhwIjoxNjkwMTI4MTgzfQ.L4nI6TudmqTvg18rLe1jfuUDDj2DA9DkgSh5F4K20xU','BEARER',3),(810,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEyNjk4MSwiZXhwIjoxNjkwMTI4NDIxfQ.-FDWNMWGvVdhYlKXgqQfunc4Mk3nyb8XnmPzh9CNd8M','BEARER',3),(811,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEzMjU5MCwiZXhwIjoxNjkwMTM0MDMwfQ.WoeXxSH_vG_dS8V5_75NH639BB9JXCtUjeBKeBCu3Gk','BEARER',3),(852,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjkwMTM1NzA1LCJleHAiOjE2OTAxMzcxNDV9.z8lmgi1NhjhMT0cP3fVOtFwV3jLO8j2PceiplUjUnOA','BEARER',1),(902,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDEzNjcyNiwiZXhwIjoxNjkwMTM4MTY2fQ.cJ3JPDC5XZbuw0UHATv0-kpqx42P3sA5RYcEBOczIcs','BEARER',3),(952,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDE1MDYxMiwiZXhwIjoxNjkwMTUyMDUyfQ.hkdFoQdiShxT2w2RlPOGmV2AlgPYofZM1-WT-2m9nwo','BEARER',3),(953,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDE1MTU3MCwiZXhwIjoxNjkwMTUzMDEwfQ.SbBhffBYaqb66zKR92p1-2GXDs-6jQhCmVtpYMgUmMo','BEARER',3),(1002,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDE5MTg5OCwiZXhwIjoxNjkwMTkzMzM4fQ.53O4DAmFRknHS_GTWUbNrnxC4fel1_a48KT22_A5FxA','BEARER',3),(1003,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDE5Mjg2MCwiZXhwIjoxNjkwMTk0MzAwfQ.G3kScGNop1waxckCtjZoKm3jL6DHj17zoGW3nnAZBbA','BEARER',3),(1004,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDE5MjkwMywiZXhwIjoxNjkwMTk0MzQzfQ.PSeHeaV6oszZHWB70ql0eaGJtV4q2zrkWbGBwfhncPI','BEARER',3),(1052,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDE5NDIwMywiZXhwIjoxNjkwMTk1NjQzfQ.6uX8GzCXXVvFrB-ndcu4FHeWLSQ9aN6xgVzR57NZahs','BEARER',3),(1053,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3c21pdGhAZmFrZS5jb20iLCJpYXQiOjE2OTAxOTUwNTIsImV4cCI6MTY5MDE5NjQ5Mn0.h9k_ncE_nxXYdbDFbpp4OGWc0yZK02muqfYUatsZsaQ','BEARER',52),(1054,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDE5NTA4NCwiZXhwIjoxNjkwMTk2NTI0fQ.VKFGmMlt2rWFV9mMqarwKKWPky660xCEMFuJ1kLbUlY','BEARER',3),(1055,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3dGF5bG9yQGZha2UuY29tIiwiaWF0IjoxNjkwMjExNTQ5LCJleHAiOjE2OTAyMTI5ODl9.m4Bbh81eFC9cekcAA3EXZL4B30BZ8B2ff6IciDrDkZs','BEARER',2),(1102,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDIyMTIxNSwiZXhwIjoxNjkwMjIyNjU1fQ.B9-XchMQ_34lxG0DJ4jtGhXaDBX80CE6TkTUp4--96M','BEARER',3),(1152,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjkwMjI0MjQ1LCJleHAiOjE2OTAyMjU2ODV9.tUQnqAyml9JtU_GAZCEhLtwO7DoSopbBTnM7ssCNerw','BEARER',1),(1202,_binary '',_binary '','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjkwMjI3ODY2LCJleHAiOjE2OTAyMjkzMDZ9.VXtFNdJ-UInsvUtgAyoYil9OWJbA418ndyhgWZqiuNE','BEARER',1),(1203,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3dGF5bG9yQGZha2UuY29tIiwiaWF0IjoxNjkwMjI3OTA0LCJleHAiOjE2OTAyMjkzNDR9.w9kePrMZtaFhk6zZoOEKzFhzqnemQSZ-Zo7yAB8ml0o','BEARER',2),(1252,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYmFpbGV5QGZha2UuY29tIiwiaWF0IjoxNjkwMjI4Njc0LCJleHAiOjE2OTAyMzAxMTR9.kypES-bc23tBb393zrSYUs1U-eD_sUeCtkuG6kQd0Pg','BEARER',1),(1253,_binary '\0',_binary '\0','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqc2FtcHNvbkBmYWtlLmNvbSIsImlhdCI6MTY5MDIyODcyMiwiZXhwIjoxNjkwMjMwMTYyfQ.eDlOAGWyRka-WY5ynSnqEJ5DTS3CXrhumthSXZ3b4PY','BEARER',3);
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
INSERT INTO `token_seq` VALUES (1351);
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

-- Dump completed on 2023-07-24 15:14:28
