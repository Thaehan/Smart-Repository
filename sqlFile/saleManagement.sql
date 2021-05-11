-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2021 at 02:19 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salemanagement`
--
CREATE DATABASE IF NOT EXISTS `salemanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `salemanagement`;

-- --------------------------------------------------------

--
-- Table structure for table `adminuser`
--

DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `ID` int(11) NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminuser`
--

INSERT INTO `adminuser` (`ID`, `account`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `export`
--

DROP TABLE IF EXISTS `export`;
CREATE TABLE `export` (
  `exportCode` int(11) NOT NULL,
  `productCode` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date` date NOT NULL,
  `destination` varchar(50) NOT NULL,
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `export`
--

INSERT INTO `export` (`exportCode`, `productCode`, `quantity`, `date`, `destination`, `note`) VALUES
(1, 'RTX-3060', 25, '2021-05-02', 'Newyork', 'Some company supply\'s'),
(2, 'AB-125', 10, '2021-05-02', '', 'Bán lẻ'),
(3, 'AB-A320', 1, '2021-05-03', 'sd;f;a', ''),
(4, 'AB-A320', 1, '2021-05-03', 'sdflsl', ''),
(5, 'AB-125', 10, '2021-05-05', 'Hà Nội', ''),
(6, 'AMD-RX570', 100, '2021-05-05', 'Hà Nội', '');

-- --------------------------------------------------------

--
-- Table structure for table `import`
--

DROP TABLE IF EXISTS `import`;
CREATE TABLE `import` (
  `importCode` int(11) NOT NULL,
  `productCode` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date` date NOT NULL,
  `source` varchar(50) NOT NULL,
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `import`
--

INSERT INTO `import` (`importCode`, `productCode`, `quantity`, `date`, `source`, `note`) VALUES
(1, 'AB-125', 15, '2021-05-03', 'NVIDIA', 'Portable goods'),
(2, 'AB-125', 10, '2021-05-03', 'Honda HN', 'Rơi rớt'),
(3, 'AB-125', 10, '2021-05-03', 'Honda Thái Nguyên', 'Nhập từ dưới quê'),
(4, 'AB-125', 41, '2021-05-03', 'Newyork', ''),
(5, 'AB-125', 10, '2021-05-05', 'Nhật Bản', ''),
(6, 'AB-125', 5, '2021-05-05', 'Nhật Bản', '');

-- --------------------------------------------------------

--
-- Table structure for table `productlines`
--

DROP TABLE IF EXISTS `productlines`;
CREATE TABLE `productlines` (
  `productLine` varchar(50) NOT NULL,
  `textDescription` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productlines`
--

INSERT INTO `productlines` (`productLine`, `textDescription`) VALUES
('Airplane', 'Vehicle capable of flight'),
('Car', '4 wheels vehicle'),
('Electronics', 'Electronic devices'),
('Motorbike', '2 wheels vehicle');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `productCode` varchar(50) NOT NULL,
  `productName` varchar(50) NOT NULL,
  `productLine` varchar(50) NOT NULL,
  `unitPrice` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `measure` varchar(50) NOT NULL,
  `details` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productCode`, `productName`, `productLine`, `unitPrice`, `quantity`, `measure`, `details`) VALUES
('AB-125', 'Honda AirBlade 125CC', 'Motorbike', 2100, 86, 'pcs', 'A common scooter of Honda'),
('AB-A320', 'Airbus a320', 'Airplane', 1000000, 0, 'pcs', 'Máy bay dân dụng được các hãng hàng không tin tưởng sử dụng.'),
('AMD-RX570', 'AMD Radeon RX-570', 'Electronics', 120, 400, 'pcs', 'Một chiếc card đồ họa quen thuộc đến từ đội Đỏ'),
('RTX-3060', 'Geforce-RTX 3060', 'Electronics', 1300, 200, 'pcs', 'Graphic card for gaming of  NVIDIA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminuser`
--
ALTER TABLE `adminuser`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `export`
--
ALTER TABLE `export`
  ADD PRIMARY KEY (`exportCode`),
  ADD KEY `productCode` (`productCode`);

--
-- Indexes for table `import`
--
ALTER TABLE `import`
  ADD PRIMARY KEY (`importCode`),
  ADD KEY `productCode` (`productCode`);

--
-- Indexes for table `productlines`
--
ALTER TABLE `productlines`
  ADD PRIMARY KEY (`productLine`),
  ADD KEY `productLine` (`productLine`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productCode`),
  ADD KEY `productLine` (`productLine`),
  ADD KEY `productCode` (`productCode`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminuser`
--
ALTER TABLE `adminuser`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `export`
--
ALTER TABLE `export`
  MODIFY `exportCode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `import`
--
ALTER TABLE `import`
  MODIFY `importCode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `export`
--
ALTER TABLE `export`
  ADD CONSTRAINT `productCodeExport_FK` FOREIGN KEY (`productCode`) REFERENCES `products` (`productCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `import`
--
ALTER TABLE `import`
  ADD CONSTRAINT `productCodeImport_FK` FOREIGN KEY (`productCode`) REFERENCES `products` (`productCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `productLine_FK` FOREIGN KEY (`productLine`) REFERENCES `productlines` (`productLine`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
