-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2020 at 04:33 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tb_bpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `sku` varchar(20) NOT NULL,
  `nama_brg` varchar(35) NOT NULL,
  `depart` varchar(50) NOT NULL,
  `h_beli` int(255) NOT NULL,
  `h_jual` int(255) NOT NULL,
  `stok` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`sku`, `nama_brg`, `depart`, `h_beli`, `h_jual`, `stok`) VALUES
('1', 'Rapika', 'House Hold', 30000, 20000, 17),
('2', 'Masker', 'Non Food', 20000, 10000, 12),
('4', 'House Hold', 'null', 30000, 40000, 22),
('5', 'Daia', 'House Hold', 50000, 60000, 22);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `no_penj` varchar(20) NOT NULL,
  `tgl` varchar(30) NOT NULL,
  `nama_brg` varchar(35) NOT NULL,
  `harga` int(255) NOT NULL,
  `qty` int(255) NOT NULL,
  `total` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`sku`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
