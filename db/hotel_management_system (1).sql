-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2024 at 11:52 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `room_number` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `deposit` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `name` varchar(30) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `company` varchar(30) DEFAULT NULL,
  `brand` varchar(30) DEFAULT NULL,
  `available` varchar(10) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `name` varchar(30) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL,
  `salary` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `personal_identification_number` varchar(30) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_number` varchar(20) DEFAULT NULL,
  `availability` varchar(20) DEFAULT NULL,
  `clean_sttatus` varchar(20) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `bed_type` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
