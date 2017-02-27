-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2017 at 03:57 PM
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
  `employee_pps` int(11) NOT NULL,
  `employee_name` varchar(255) NOT NULL,
  `employee_tel` varchar(255) NOT NULL,
  `employee_email` varchar(255) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `account_type` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employers_details`
--

CREATE TABLE `employers_details` (
  `employers_id` int(11) NOT NULL,
  `employer_name` varchar(255) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `employer_tel` varchar(255) DEFAULT NULL,
  `employers_email` varchar(255) NOT NULL,
  `employers_address1` varchar(255) DEFAULT NULL,
  `employers_address2` varchar(255) DEFAULT NULL,
  `employers_address3` varchar(255) DEFAULT NULL,
  `employers_password` varchar(255) NOT NULL,
  `account_type` int(11) NOT NULL DEFAULT '0' COMMENT '0=employer, 1=manager, 2=employee'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employers_details`
--

INSERT INTO `employers_details` (`employers_id`, `employer_name`, `company_name`, `employer_tel`, `employers_email`, `employers_address1`, `employers_address2`, `employers_address3`, `employers_password`, `account_type`) VALUES
(4, 'John Smith', 'ABC Ltd.', '12-9876543', 'johnsmith@example.ie', '123 DEF Street', 'Alphabet Town', 'Letterland', '123456Employer', 0);

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
  ADD PRIMARY KEY (`employee_pps`);

--
-- Indexes for table `employers_details`
--
ALTER TABLE `employers_details`
  ADD PRIMARY KEY (`employers_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company_members`
--
ALTER TABLE `company_members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `employers_details`
--
ALTER TABLE `employers_details`
  MODIFY `employers_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
