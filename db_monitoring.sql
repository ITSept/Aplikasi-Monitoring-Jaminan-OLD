-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2021 at 04:42 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_monitoring`
--

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

CREATE TABLE `level` (
  `id_level` varchar(2) NOT NULL,
  `nama_level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `level`
--

INSERT INTO `level` (`id_level`, `nama_level`) VALUES
('1', 'Admin'),
('2', 'Frontliner');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jm_kpr`
--

CREATE TABLE `tb_jm_kpr` (
  `no_cif` varchar(22) NOT NULL,
  `no_ktp` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `no_vault` varchar(222) NOT NULL,
  `nama_dokumen` varchar(22) NOT NULL,
  `no_dokumen` varchar(22) NOT NULL,
  `keterangan` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jm_kpr`
--

INSERT INTO `tb_jm_kpr` (`no_cif`, `no_ktp`, `nama_debitur`, `no_vault`, `nama_dokumen`, `no_dokumen`, `keterangan`) VALUES
('0091', '30900019999201', 'Faisal', '2', 'Surat Keterangan', '0011/CN/07/2008', '-'),
('0123', '3099919992836461', 'Faisal', '2', 'Form Kredit KPR', '0021/CN/09/2021', 'renew'),
('1201', '30122499019912', 'Eka', '3', 'Akta jual beli', '10/2021', '1 rangkap');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jm_personal`
--

CREATE TABLE `tb_jm_personal` (
  `no_pinjaman` varchar(20) NOT NULL,
  `no_cif` varchar(10) NOT NULL,
  `nama_debitur` varchar(25) DEFAULT NULL,
  `jenis_pinjaman` varchar(25) DEFAULT NULL,
  `plafon` varchar(25) DEFAULT NULL,
  `tanggal` varchar(10) DEFAULT NULL,
  `nama_marketing` varchar(25) DEFAULT NULL,
  `no_dokumen` varchar(25) DEFAULT NULL,
  `keterangan` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jm_personal`
--

INSERT INTO `tb_jm_personal` (`no_pinjaman`, `no_cif`, `nama_debitur`, `jenis_pinjaman`, `plafon`, `tanggal`, `nama_marketing`, `no_dokumen`, `keterangan`) VALUES
('01', '4512', 'Eka', 'New', '20000000', '05-04-2021', 'Ergin', 'no.sk.0012/041', 'Revisi'),
('02', '0912', 'Diana', 'Top Up', '15000000', '04-05-2021', 'Udir', 'no.sk.0012/001', ''),
('03', '9982', 'Savera', 'Take Over', '20000000', '03-05-2021', 'Erin', 'no.sk.0212/002', '-');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jm_ukm`
--

CREATE TABLE `tb_jm_ukm` (
  `no_pinjaman` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `plafon` varchar(22) NOT NULL,
  `outstanding` varchar(22) NOT NULL,
  `jenis_kredit` varchar(22) NOT NULL,
  `jangka_waktu` varchar(22) NOT NULL,
  `coll` varchar(22) NOT NULL,
  `jaminan` varchar(22) NOT NULL,
  `keterangan` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jm_ukm`
--

INSERT INTO `tb_jm_ukm` (`no_pinjaman`, `nama_debitur`, `plafon`, `outstanding`, `jenis_kredit`, `jangka_waktu`, `coll`, `jaminan`, `keterangan`) VALUES
('PJKM001', 'Bintang Timur, CV', '20000000', '5000000', 'UKM', '04-06-2021', '2', 'Ruko 3 lantai', '-'),
('PJKM002', 'Rans United', '1000000000', '50000000', 'Dana', '04-06-2021', '1', 'Rumah', '-'),
('PJKM003', 'PQR, PT', '60000000', '5000000', 'UKM', '04-06-2021', '2', 'Villa 1 unit', '-');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kr_bg`
--

CREATE TABLE `tb_kr_bg` (
  `no_pinjaman` varchar(22) NOT NULL,
  `index_` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `kode_marketing` varchar(22) NOT NULL,
  `nama_marketing` varchar(22) NOT NULL,
  `jenis_bantex` varchar(22) NOT NULL,
  `jumlah_bantex` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kr_bg`
--

INSERT INTO `tb_kr_bg` (`no_pinjaman`, `index_`, `nama_debitur`, `kode_marketing`, `nama_marketing`, `jenis_bantex`, `jumlah_bantex`) VALUES
('PJBG001', 'A.1', 'ABC, PT', '0123', 'Fahmi', 'JAMINAN', '2'),
('PJBG002', 'A.2', 'XYZ, PT', '0123', 'Fahmi', 'ADMK', '3'),
('PJBG003', 'A.3', 'MNO, PT', '0123', 'Fahmi', 'JAMINAN', '2');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kr_ukm`
--

CREATE TABLE `tb_kr_ukm` (
  `no_pinjaman` varchar(22) NOT NULL,
  `index_` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `kode_marketing` varchar(22) NOT NULL,
  `nama_marketing` varchar(22) NOT NULL,
  `jenis_bantex` varchar(22) NOT NULL,
  `jumlah_bantex` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kr_ukm`
--

INSERT INTO `tb_kr_ukm` (`no_pinjaman`, `index_`, `nama_debitur`, `kode_marketing`, `nama_marketing`, `jenis_bantex`, `jumlah_bantex`) VALUES
('KRKM001', '9.1', 'Arief', '3144', 'Ruslan', 'ADMK', '5'),
('KRKM002', 'G.1', 'Dimas', '3144', 'Ruslan', 'ADMK', '4'),
('KRKM003', 'D.7', 'Kokom', '2520', 'Kiki', 'KREDIT', '2');

-- --------------------------------------------------------

--
-- Table structure for table `tb_login`
--

CREATE TABLE `tb_login` (
  `nip` varchar(20) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama_user` varchar(20) NOT NULL,
  `id_level` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_login`
--

INSERT INTO `tb_login` (`nip`, `user_id`, `password`, `nama_user`, `id_level`) VALUES
('01', 'admin', 'admin', 'Administrator', '2'),
('98192104', 'IT450101', 'admin', 'Eka Septian Nugraha', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE `tb_peminjaman` (
  `no_form` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `unit_bisnis` varchar(22) NOT NULL,
  `jumlah_file` varchar(22) NOT NULL,
  `keperluan` varchar(2222) NOT NULL,
  `tanggal_pinjam` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_peminjaman`
--

INSERT INTO `tb_peminjaman` (`no_form`, `nama_debitur`, `unit_bisnis`, `jumlah_file`, `keperluan`, `tanggal_pinjam`) VALUES
('GNS0001', 'Eka', 'Analis', '3', 'Komite', '04-06-2021');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian`
--

CREATE TABLE `tb_pengembalian` (
  `no_form` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `unit_bisnis` varchar(22) NOT NULL,
  `jumlah_file` varchar(22) NOT NULL,
  `keperluan` varchar(2222) NOT NULL,
  `tanggal_kembali` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pengembalian`
--

INSERT INTO `tb_pengembalian` (`no_form`, `nama_debitur`, `unit_bisnis`, `jumlah_file`, `keperluan`, `tanggal_kembali`) VALUES
('GNS0001', 'Eka', 'Analis', '3', 'Komite', '07-06-2021');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `tb_jm_kpr`
--
ALTER TABLE `tb_jm_kpr`
  ADD PRIMARY KEY (`no_cif`);

--
-- Indexes for table `tb_jm_personal`
--
ALTER TABLE `tb_jm_personal`
  ADD PRIMARY KEY (`no_pinjaman`);

--
-- Indexes for table `tb_jm_ukm`
--
ALTER TABLE `tb_jm_ukm`
  ADD PRIMARY KEY (`no_pinjaman`);

--
-- Indexes for table `tb_kr_bg`
--
ALTER TABLE `tb_kr_bg`
  ADD PRIMARY KEY (`no_pinjaman`);

--
-- Indexes for table `tb_kr_ukm`
--
ALTER TABLE `tb_kr_ukm`
  ADD PRIMARY KEY (`no_pinjaman`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`nip`),
  ADD KEY `id_level` (`id_level`);

--
-- Indexes for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD PRIMARY KEY (`no_form`);

--
-- Indexes for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  ADD PRIMARY KEY (`no_form`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
