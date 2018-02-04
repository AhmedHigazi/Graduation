-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2017 at 12:26 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vlab`
--

-- --------------------------------------------------------

--
-- Table structure for table `assistantfactor`
--

CREATE TABLE `assistantfactor` (
  `assFa_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assistantfactor`
--

INSERT INTO `assistantfactor` (`assFa_id`, `name`) VALUES
(7, 'aaa');

-- --------------------------------------------------------

--
-- Table structure for table `efffective`
--

CREATE TABLE `efffective` (
  `eff_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `AssFactor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `equation`
--

CREATE TABLE `equation` (
  `equation_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `input` varchar(50) NOT NULL,
  `result` varchar(50) NOT NULL,
  `AssFactor_id` int(11) NOT NULL,
  `Reverse_Equation` tinyint(1) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `equation_matrale`
--

CREATE TABLE `equation_matrale` (
  `matrale_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `equation_tool`
--

CREATE TABLE `equation_tool` (
  `equation_id` int(11) NOT NULL,
  `tool_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `matrale`
--

CREATE TABLE `matrale` (
  `matrale_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `color` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `consuming_quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matrale`
--

INSERT INTO `matrale` (`matrale_id`, `name`, `color`, `state`, `quantity`, `consuming_quantity`) VALUES
(5, 'sod', 'white', 'd', 50, 70),
(6, 'wter', 'red', 'lqu', 30, 20);

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `path` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`project_id`, `name`, `path`) VALUES
(1, 'aa', 'wwww'),
(2, 'dddd', '///bjkbjkbh');

-- --------------------------------------------------------

--
-- Table structure for table `tool`
--

CREATE TABLE `tool` (
  `tool_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `size` int(50) NOT NULL,
  `path` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tool`
--

INSERT INTO `tool` (`tool_id`, `name`, `size`, `path`) VALUES
(1, 'vlok', 40, ' ajzsaZ');

-- --------------------------------------------------------

--
-- Table structure for table `tool_matrale`
--

CREATE TABLE `tool_matrale` (
  `id` int(11) NOT NULL,
  `matrale_id` int(11) NOT NULL,
  `tool_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assistantfactor`
--
ALTER TABLE `assistantfactor`
  ADD PRIMARY KEY (`assFa_id`);

--
-- Indexes for table `efffective`
--
ALTER TABLE `efffective`
  ADD PRIMARY KEY (`eff_id`),
  ADD KEY `AssFactor_id` (`AssFactor_id`);

--
-- Indexes for table `equation`
--
ALTER TABLE `equation`
  ADD PRIMARY KEY (`equation_id`),
  ADD KEY `AssFactor_id` (`AssFactor_id`),
  ADD KEY `AssFactor_id_2` (`AssFactor_id`),
  ADD KEY `project_id` (`project_id`);

--
-- Indexes for table `equation_matrale`
--
ALTER TABLE `equation_matrale`
  ADD KEY `matrale_id` (`matrale_id`),
  ADD KEY `project_id` (`project_id`);

--
-- Indexes for table `equation_tool`
--
ALTER TABLE `equation_tool`
  ADD KEY `equation_id` (`equation_id`),
  ADD KEY `tool_id` (`tool_id`);

--
-- Indexes for table `matrale`
--
ALTER TABLE `matrale`
  ADD PRIMARY KEY (`matrale_id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`project_id`);

--
-- Indexes for table `tool`
--
ALTER TABLE `tool`
  ADD PRIMARY KEY (`tool_id`);

--
-- Indexes for table `tool_matrale`
--
ALTER TABLE `tool_matrale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `matrale_id` (`matrale_id`),
  ADD KEY `tool_id` (`tool_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assistantfactor`
--
ALTER TABLE `assistantfactor`
  MODIFY `assFa_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `efffective`
--
ALTER TABLE `efffective`
  MODIFY `eff_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `equation`
--
ALTER TABLE `equation`
  MODIFY `equation_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `matrale`
--
ALTER TABLE `matrale`
  MODIFY `matrale_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `project_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tool`
--
ALTER TABLE `tool`
  MODIFY `tool_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tool_matrale`
--
ALTER TABLE `tool_matrale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
