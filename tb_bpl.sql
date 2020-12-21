-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Des 2020 pada 05.57
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.2.34

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
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `sku` varchar(20) NOT NULL,
  `nama_brg` varchar(35) NOT NULL,
  `id_kate` varchar(15) NOT NULL,
  `h_beli` int(255) NOT NULL,
  `h_jual` int(255) NOT NULL,
  `stok` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`sku`, `nama_brg`, `id_kate`, `h_beli`, `h_jual`, `stok`) VALUES
('MI-01', 'Mie Indomie Kari Ayam', '1', 1000, 2500, 10),
('MS-01', 'Masker Garnier', '2', 10000, 15000, 15),
('RP-01', 'Rapika', '3', 10000, 15000, 12);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id_kate` varchar(15) NOT NULL,
  `kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kate`, `kategori`) VALUES
('1', 'Food'),
('2', 'Non Food'),
('3', 'House Hold');

-- --------------------------------------------------------

--
-- Struktur dari tabel `laba`
--

CREATE TABLE `laba` (
  `id` int(11) NOT NULL,
  `noresi` varchar(50) CHARACTER SET latin1 NOT NULL,
  `untung` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `laba`
--

INSERT INTO `laba` (`id`, `noresi`, `untung`) VALUES
(1, '004', 3000),
(2, '005', 3000),
(3, '006', 6000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `noresi` varchar(50) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`noresi`, `tanggal`, `username`) VALUES
('001', '21-12-2020', 'admin'),
('002', '21-12-2020', 'admin'),
('003', '21-12-2020', 'admin'),
('004', '21-12-2020', 'admin'),
('005', '21-12-2020', 'admin'),
('006', '21-12-2020', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_detail`
--

CREATE TABLE `transaksi_detail` (
  `id` int(11) NOT NULL,
  `sku` varchar(35) CHARACTER SET utf8mb4 NOT NULL,
  `noresi` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi_detail`
--

INSERT INTO `transaksi_detail` (`id`, `sku`, `noresi`, `jumlah`, `harga`) VALUES
(13, 'MI-01', '001', 2, 5000),
(14, 'MS-01', '002', 3, 45000),
(15, 'RP-01', '003', 4, 60000),
(16, 'MI-01', '004', 2, 5000),
(17, 'MI-01', '005', 2, 5000),
(18, 'MI-01', '006', 4, 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `Username` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `login_terakhir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`Username`, `Email`, `Password`, `login_terakhir`) VALUES
('admin', 'admin@gmail.com', 'admin', '2020-12-21'),
('qwe', 'qwe@', 'qwe', '2020-12-20'),
('sisfo', 'sisfo@gmail.com', 'mnmrk', '2020-12-19'),
('user', 'mhadefpetriza@gmail.com', 'user', '2020-12-17');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`sku`),
  ADD KEY `id_kate` (`id_kate`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kate`);

--
-- Indeks untuk tabel `laba`
--
ALTER TABLE `laba`
  ADD PRIMARY KEY (`id`),
  ADD KEY `noresi` (`noresi`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`noresi`);

--
-- Indeks untuk tabel `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sku` (`sku`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `laba`
--
ALTER TABLE `laba`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_kate`) REFERENCES `kategori` (`id_kate`);

--
-- Ketidakleluasaan untuk tabel `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  ADD CONSTRAINT `transaksi_detail_ibfk_1` FOREIGN KEY (`sku`) REFERENCES `barang` (`sku`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
