-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2026 at 08:58 PM
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
-- Database: `db_perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `item_perpustakaan`
--

CREATE TABLE `item_perpustakaan` (
  `id` int(11) NOT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `judul` varchar(100) DEFAULT NULL,
  `tahun_terbit` int(11) DEFAULT NULL,
  `pengarang` varchar(100) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `edisi` varchar(50) DEFAULT NULL,
  `penerbit` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `item_perpustakaan`
--

INSERT INTO `item_perpustakaan` (`id`, `jenis`, `judul`, `tahun_terbit`, `pengarang`, `isbn`, `edisi`, `penerbit`) VALUES
(5, 'Buku', 'Hilmy Milan', 2021, 'Nadia Ristivani', '9786022204237', '', ''),
(7, 'Majalah', 'Bobo', 2023, '', '', 'Edisi Anak Kreatif', 'Gramedia'),
(9, 'Buku', 'Algoritma dan Struktur Data', 2021, 'Rinaldi Munir', '9786021514537', '', ''),
(10, 'Buku', 'Bumi Manusia', 1980, 'Pramoedya Ananta', '9789793062794', '', ''),
(11, 'Buku', 'Hello, Cello', 2022, 'Nadia Ristivani', '9786022204381', '', ''),
(12, 'Majalah', 'National Geographic', 2024, '', '', 'Edisi Januari', 'National Geographic Society'),
(13, 'Buku', 'Atomic Habits', 2018, 'James Clear', '9780735211292', '', ''),
(14, 'Buku', 'Laskar Pelangi', 2005, 'Andrea Hirata', '9789793062794', '', ''),
(15, 'Majalah', 'Forbes Indonesia', 2024, '', '', 'Edisi Bisnis Digital', 'Forbes'),
(16, 'Majalah', 'Tempo', 2024, '', '', 'Edisi Politik', 'Tempo Media');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` int(11) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `item_id`, `username`, `tanggal_pinjam`, `tanggal_kembali`, `status`) VALUES
(1, 4, 'vania123', '2026-05-16', '2026-05-16', 'DIKEMBALIKAN'),
(2, 5, 'vania123', '2026-05-16', '2026-05-16', 'DIKEMBALIKAN'),
(3, 6, 'bella', '2026-05-16', NULL, 'DIPINJAM'),
(4, 11, 'vania123', '2026-05-17', '2026-05-17', 'DIKEMBALIKAN'),
(5, 5, 'vania123', '2026-05-17', '2026-05-17', 'DIKEMBALIKAN'),
(6, 11, 'bella', '2026-05-17', '2026-05-17', 'DIKEMBALIKAN'),
(7, 11, 'karin', '2026-05-17', NULL, 'DIPINJAM'),
(9, 13, 'karin', '2026-05-17', '2026-05-17', 'DIKEMBALIKAN'),
(10, 14, 'vania123', '2026-05-17', '2026-05-17', 'DIKEMBALIKAN'),
(11, 10, 'karin', '2026-05-17', NULL, 'DIPINJAM');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nama_lengkap` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `nama_lengkap`, `username`, `password`) VALUES
(1, 'vania', 'vania123', 'vania123'),
(2, 'Christabella', 'bella', 'bella123'),
(3, 'Karina', 'karin', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item_perpustakaan`
--
ALTER TABLE `item_perpustakaan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item_perpustakaan`
--
ALTER TABLE `item_perpustakaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
