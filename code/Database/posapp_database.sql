-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2017 at 01:56 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posapp_database`
--
CREATE DATABASE IF NOT EXISTS `posapp_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci;
USE `posapp_database`;

-- --------------------------------------------------------

--
-- Table structure for table `company_members`
--

CREATE TABLE `company_members` (
  `id` int(11) NOT NULL,
  `company_name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `company_tel` varchar(25) CHARACTER SET latin1 NOT NULL,
  `company_address1` varchar(255) CHARACTER SET latin1 NOT NULL,
  `company_address2` varchar(255) CHARACTER SET latin1 NOT NULL,
  `company_address3` varchar(255) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Dumping data for table `company_members`
--

INSERT INTO `company_members` (`id`, `company_name`, `company_tel`, `company_address1`, `company_address2`, `company_address3`) VALUES
(11, 'ABC Ltd.', '12-3456789', '123 ABC Street', 'Alphabet Town', 'Letterland');

-- --------------------------------------------------------

--
-- Table structure for table `employee_details`
--

CREATE TABLE `employee_details` (
  `company_id` int(11) NOT NULL,
  `employee_pps` varchar(11) NOT NULL,
  `employee_name` varchar(255) NOT NULL,
  `employee_tel` varchar(255) NOT NULL,
  `employee_email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `account_type` tinyint(1) NOT NULL COMMENT '0=employer, 1=employee'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_details`
--

INSERT INTO `employee_details` (`company_id`, `employee_pps`, `employee_name`, `employee_tel`, `employee_email`, `password`, `account_type`) VALUES
(11, '1234567L', 'James Blair', '12-6547893', 'jamesblair@hotmail.com', '12051994', 1),
(11, '3215674P', 'Adam Doyle', '23-4567891', 'adamdoyle@gmail.com', '12061998', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employers_details`
--

CREATE TABLE `employers_details` (
  `employer_id` int(11) NOT NULL COMMENT 'AKA Company ID',
  `employer_name` varchar(255) NOT NULL,
  `employer_tel` varchar(255) DEFAULT NULL,
  `employers_email` varchar(255) NOT NULL,
  `employers_address1` varchar(255) DEFAULT NULL,
  `employers_address2` varchar(255) DEFAULT NULL,
  `employers_address3` varchar(255) DEFAULT NULL,
  `employers_password` varchar(255) NOT NULL,
  `account_type` int(11) NOT NULL DEFAULT '0' COMMENT '0=employer, 1=employee'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employers_details`
--

INSERT INTO `employers_details` (`employer_id`, `employer_name`, `employer_tel`, `employers_email`, `employers_address1`, `employers_address2`, `employers_address3`, `employers_password`, `account_type`) VALUES
(11, 'John Smith', '01-12-9873456', 'johnsmith@example.ie', '321 ABC Street', 'Alphabet Town', 'Letterland', '123Testing', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `company_members`
--
ALTER TABLE `company_members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_details`
--
ALTER TABLE `employee_details`
  ADD PRIMARY KEY (`company_id`,`employee_pps`);

--
-- Indexes for table `employers_details`
--
ALTER TABLE `employers_details`
  ADD PRIMARY KEY (`employer_id`,`employer_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company_members`
--
ALTER TABLE `company_members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee_details`
--
ALTER TABLE `employee_details`
  ADD CONSTRAINT `company_restraint` FOREIGN KEY (`company_id`) REFERENCES `company_members` (`id`);

--
-- Constraints for table `employers_details`
--
ALTER TABLE `employers_details`
  ADD CONSTRAINT `company_id` FOREIGN KEY (`employer_id`) REFERENCES `company_members` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
