-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2024 at 01:53 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_ds`
--

-- --------------------------------------------------------

--
-- Table structure for table `quartos`
--

CREATE TABLE `quartos` (
  `N_Quarto` int(3) NOT NULL,
  `acomoda` int(2) NOT NULL,
  `varanda` tinyint(1) DEFAULT NULL,
  `microondas` tinyint(1) DEFAULT NULL,
  `frigobar` tinyint(1) DEFAULT NULL,
  `tv` tinyint(1) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `ocupado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quartos`
--

INSERT INTO `quartos` (`N_Quarto`, `acomoda`, `varanda`, `microondas`, `frigobar`, `tv`, `cpf`, `ocupado`) VALUES
(101, 4, 1, 0, 1, 1, NULL, 0),
(102, 4, 0, 0, 1, 1, '54355686841', 1),
(103, 2, 1, 1, 0, 0, NULL, 0),
(104, 5, 0, 0, 0, 1, '', 0),
(201, 4, 0, 1, 1, 0, '', 0);

--
-- Triggers `quartos`
--
DELIMITER $$
CREATE TRIGGER `update_cpf` BEFORE UPDATE ON `quartos` FOR EACH ROW BEGIN
    IF NEW.ocupado = 0 THEN
        SET NEW.cpf = null;
    END IF;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quartos`
--
ALTER TABLE `quartos`
  ADD PRIMARY KEY (`N_Quarto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
