-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2024 at 03:02 PM
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

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `number`, `name`, `gender`, `country`, `room_number`, `status`, `deposit`) VALUES
('Personal Identification Number', '111222333444', 'Simona', 'Female', 'Romania', '3009', 'Yes', '40'),
('Passport', '444333222111', 'Enrique', 'Male', 'Spain', '3010', 'Yes', '100'),
('Passport', '222333444111', 'Constantin', 'Male', 'Romania', '3011', 'Yes', '60'),
('Passport', '333444111222', 'Marinela', 'Female', 'Romania', '3011', 'Yes', '70');

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

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`name`, `age`, `gender`, `company`, `brand`, `available`, `location`) VALUES
('Stefan', '30', 'Male', 'Hotel Marriott', 'Audi', 'Yes', 'Bucharest'),
('Robert', '28', 'Male', 'Hotel Marriott', 'BMW', 'Yes', 'Bucharest'),
('Adrian', '', 'Male', 'Hotel Marriott', '', 'Yes', 'Bucharest'),
('Ionut', '45', 'Male', 'Hotel Marriott', 'Mercedes', 'Yes', 'Bucharest'),
('Liviu', '39', 'Male', 'Hotel Marriott', 'Dacia', 'Yes', 'Bucharest');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `name` varchar(30) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `job` varchar(30) DEFAULT NULL,
  `salary` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `personal_identification_number` varchar(30) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`name`, `age`, `gender`, `job`, `salary`, `phone`, `personal_identification_number`, `email`) VALUES
('Elena', '30', 'female', 'Room Service', '600', '0721234567', '2940510453256', 'elena@gmail.com'),
('Madalina', '40', 'female', 'Waiter/Waitress', '550', '077654321', '2990222654875', 'madalina@gmail.com'),
('Cornelia', '40', 'female', 'Kitchen Staff', '1000', '0755123456', '2841028344552', 'cornelia@gmail.com'),
('Daniela', '45', 'female', 'Accountant', '12200', '0787654321', '2790524316245', 'daniela'),
('George', '40', 'null', 'Manager', '1700', '0700012345', '1840322355346', 'george@gmail.com'),
('Razban', '42', 'male', 'Kitchen Staff', '2000', '0712345600', '1860610235645', 'razvan@gmail.com'),
('Monica', '25', 'female', 'Waiter/Waitress', '700', '0722233344', '2990424234564', 'mihaela'),
('Rodica', '24', 'female', 'Housekeeping', '520', '0788012345', '2001028355446', 'rodica@gmail.com'),
('Jeanine', '25', 'female', 'Front Desk Clerks', '600', '0733344555', '2991206235446', 'jeanine@gmail.com');

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
  `clean_status` varchar(20) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `bed_type` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_number`, `availability`, `clean_status`, `price`, `bed_type`) VALUES
('1001', 'Available', 'Cleaned', '100', 'Double Bed'),
('1002', 'Occupied', 'Dirty', '50', 'Single Bed'),
('1003', 'Occupied', 'Cleaned', '60', 'Single Bed'),
('1004', 'Occupied', 'Cleaned', '65', 'Single Bed'),
('2005', 'Occupied', 'Cleaned', '60', 'Single Bed'),
('2006', 'Occupied', 'Cleaned', '100', 'Double Bed'),
('2007', 'Available', 'Dirty', '50', 'Single Bed'),
('2007', 'Available', 'Cleaned', '160', 'Double Bed'),
('3009', 'Occupied', 'Cleaned', '120', 'Double Bed'),
('3010', 'Occupied', 'Cleaned', '70', 'Single Bed'),
('3011', 'Occupied', 'Cleaned', '130', 'Double Bed'),
('3012', 'Available', 'Cleaned', '80', 'Single Bed');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
