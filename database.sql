-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: trackingvideo
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `user_video`
--

DROP TABLE IF EXISTS `user_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_video` (
  `current_min` float DEFAULT NULL,
  `total_min` float DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `video_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`,`video_id`),
  KEY `FKo7yirkwign93nljjs3t73wyvm` (`video_id`),
  CONSTRAINT `FKo7yirkwign93nljjs3t73wyvm` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`),
  CONSTRAINT `FKrflif1r9laoiwcwhh3imkhfn3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_video`
--

LOCK TABLES `user_video` WRITE;
/*!40000 ALTER TABLE `user_video` DISABLE KEYS */;
INSERT INTO `user_video` VALUES (1045.86,4932.24,'N0MQsiwdpb800jq6A7168aJZUA_EZwsX7DwBle4XjO0','-TLSmChiJxg&t=1042s'),(2.26046,976.381,'N0MQsiwdpb800jq6A7168aJZUA_EZwsX7DwBle4XjO0','5uR_M93VbbY'),(2648.48,12150.9,'N0MQsiwdpb800jq6A7168aJZUA_EZwsX7DwBle4XjO0','QDeznXNIL1g'),(2.28597,103.641,'N0MQsiwdpb800jq6A7168aJZUA_EZwsX7DwBle4XjO0','r0aWFAbZtrY'),(1.8308,811.861,'N0MQsiwdpb800jq6A7168aJZUA_EZwsX7DwBle4XjO0','RVdCm-5qUps'),(4.16107,684.541,'N0MQsiwdpb800jq6A7168aJZUA_EZwsX7DwBle4XjO0','SBI_LJ_HqJI');
/*!40000 ALTER TABLE `user_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('2051052092nhat@ou.edu.vn','N0MQsiwdpb800jq6A7168aJZUA_EZwsX7DwBle4XjO0');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES ('-TLSmChiJxg&t=1042s','(17) PHÂN TÍCH CKTG 2023: GAM VS TW: NỘI CHIẾN VCS TẠI #worlds2023 - GAM LÀ CHÂN MỆNH THIÊN TỬ!,'),('5uR_M93VbbY','(17) video này có những molly tôi chưa từng tiết lộ ?,'),('QDeznXNIL1g','Nối dốc CKTG #worlds2023,'),('r0aWFAbZtrY','(17) Summon Demon || Reincarnated as a Slime || Rimuru,'),('RVdCm-5qUps','(17) Xếp Hạng Sức Mạnh Các Đặc Vụ Valorant Phiên Bản 7.09: Iso Có Phải Là Mạnh Nhất? | Góc Nhìn Gosu #103,'),('SBI_LJ_HqJI','MIỀN TÂY BÁO TRỞ LẠI,');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-17  9:32:17
