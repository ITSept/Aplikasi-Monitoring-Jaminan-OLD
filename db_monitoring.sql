-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 11, 2022 at 06:40 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

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
-- Table structure for table `tb_jm_kpr`
--

CREATE TABLE `tb_jm_kpr` (
  `no_cif` int(22) NOT NULL,
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
(120, '3525016005650004', 'Agus', '3', 'Akta Usaha', 'SK/20/VII/2020', '-'),
(250, '3525015306780002', 'Ariana', '4', 'Surat Keterangan', 'Nomor 84/2018', '-'),
(453, '3525016501830002', 'Haris', '1', 'Akta tanah', 'SE - 2/PJ/2010', '-'),
(632, '3525011506830001', 'Umar', '2', 'Akta Jual Beli', '2440/KEP.33.11/IV/2012', '-'),
(812, '3525017006650078', 'Dita', '3', 'Akta Jual beli', 'Nomor: 48/2013', '-'),
(1021, '30900019999201', 'Faisal', '2', 'Surat Keterangan', '0011/CN/07/2008', '-'),
(1201, '30122499019912', 'Eka', '3', 'Akta jual beli', '10/2021', '1 rangkap'),
(2031, '3099919992836461', 'Rizky', '2', 'Form Kredit KPR', '0021/CN/09/2021', 'renew'),
(5634, '3525015201880002', 'Fahmi', '1', 'Akta Jual Beli', '24/AJB/2015-', ''),
(5730, '3525010510930001', 'Daffa', '2', 'Akta Nikah', 'DJ.II/1142/2013', '-');

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
('4501090734', '0734', 'Eka', 'Modal Usaha', '20000000', '04-08-2022', 'Fahmi', 'M-08148003-0', '-'),
('4501101747', '1747', 'Septian', 'Modal Kerja', '50000000', '10-08-2022', 'Edo', 'M-01553202-9', 'pengajuan baru'),
('4501111023', '1023', 'Nugraha', 'Modal Kerja', '20000000', '10-08-2022', 'Eka Rizky', '01.60.05.1003.15.78', '-'),
('4501111410', '1410', 'Diana', 'Sekolah', '25000000', '10-08-2022', 'Edo', 'M01564957', '-'),
('4501112447', '2447', 'Savera', 'Biaya Rumah Sakit', '30000000', '10-08-2022', 'Edo', 'M01564957', '-'),
('4501112725', '2725', 'Rachma', 'Renovasi Rumah', '100000000', '10-08-2022', 'Rizky', '01.60.15.1003.15.90', '-'),
('4501113038', '3038', 'Dewi', 'Rekreasi', '10000000', '10-08-2022', 'Fahmi', 'L04773721', '-'),
('4501113143', '3143', 'Arief', 'Renovasi Rumah', '50000000', '10-08-2022', 'Eka Rizky', 'D3041682', '-'),
('4501113229', '3229', 'Nurrahmawan', 'Pernikahan', '35000000', '10-08-2022', 'Edo', '9799177112', '-'),
('4501113725', '3725', 'Daffa', 'Rumah Sakit', '40000000', '10-08-2022', 'Faisal', '01.60.05.1003.15.78', '-');

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
('4501012419', 'PT. MALAYSIA', '200000000', '50000000', 'UKM', '10-08-2022', '1', 'Sawah 2 hektare', '-'),
('4501012621', 'PT. KAMBOJA', '1000000000', '20000000', 'DANA', '10-08-2022', '1', 'Pabrik Popok', '-'),
('4501012857', 'PT. VIETNAM', '2000000000', '100000000', 'DANA', '10-08-2022', '1', 'Villa 2 hektare', '-'),
('4501012951', 'PT. TIMOR LESTE', '500000000', '50000000', 'UKM', '10-08-2022', '2', 'Rumah', '-'),
('4501013208', 'PT. PHILIPINA', '200000000', '100000000', 'DANA', '10-08-2022', '1', 'Mobil Alphard', '-'),
('4501013446', 'PT. BRUNEI DARUSSALAM', '3000000000', '500000000', 'Dana', '10-08-2022', '1', '1 Unit BUS', '-'),
('4501013553', 'PT. SINGAPURA', '500000000', '100000000', 'UKM', '10-08-2022', '1', 'Rumah', '-'),
('4501014625', 'PT. MYANMAR', '200000000', '50000000', 'UKM', '10-08-2022', '1', 'Coffee shop', '-'),
('4501014659', 'PT. LAOS', '300000000', '50000000', 'UKM', '10-08-2022', '1', 'Perkebunan 500 m2', ''),
('4501114730', 'PT. INDONESIA', '100000000', '20000000', 'UKM', '10-08-2022', '0', 'Tanah 5 hektare', '-');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kr_bg`
--

CREATE TABLE `tb_kr_bg` (
  `no_pinjaman_bg` varchar(22) NOT NULL,
  `index_` varchar(22) NOT NULL,
  `nama_debitur_bg` varchar(22) NOT NULL,
  `kode_marketing` varchar(22) NOT NULL,
  `nama_marketing` varchar(22) NOT NULL,
  `jenis_bantex` varchar(22) NOT NULL,
  `jumlah_bantex` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kr_bg`
--

INSERT INTO `tb_kr_bg` (`no_pinjaman_bg`, `index_`, `nama_debitur_bg`, `kode_marketing`, `nama_marketing`, `jenis_bantex`, `jumlah_bantex`) VALUES
('4501022619', 'B.1', 'PT. JAKARTA', 'AO003', 'Eka Rizky', 'JAMINAN', '2'),
('4501022955', 'A.1', 'PT. BANDUNG', 'AO002', 'Faisal', 'ADMK', '1'),
('4501023021', 'A.2', 'PT. BANTEN', 'AO004', 'Edo', 'KREDIT', '1'),
('4501023204', 'A.3', 'PT. SUKABUMI', 'AO004', 'Edo', 'JAMINAN', '2'),
('4501023224', 'A.4', 'PT. CILEGON', 'AO003', 'Eka Rizky', 'JAMINAN', '1'),
('4501023245', 'A.1', 'PT. SERANG', 'AO005', 'Rizky', 'KREDIT', '1'),
('4501023309', 'A.2', 'PT. BEKASI', 'AO003', 'Eka Rizky', 'ADMK', '2'),
('4501023328', 'A.2', 'PT. MARCO', 'AO005', 'Rizky', 'KREDIT', '1'),
('4501023403', 'A.3', 'PT. MIKROTRANS', 'AO003', 'Eka Rizky', 'KREDIT', '1'),
('4501023426', 'A.4', 'PT. ADMINISTRANS', 'AO005', 'Rizky', 'JAMINAN', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kr_ukm`
--

CREATE TABLE `tb_kr_ukm` (
  `no_pinjaman_ukm` varchar(22) NOT NULL,
  `index_` varchar(22) NOT NULL,
  `nama_debitur_ukm` varchar(22) NOT NULL,
  `kode_marketing` varchar(22) NOT NULL,
  `nama_marketing` varchar(22) NOT NULL,
  `jenis_bantex` varchar(22) NOT NULL,
  `jumlah_bantex` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kr_ukm`
--

INSERT INTO `tb_kr_ukm` (`no_pinjaman_ukm`, `index_`, `nama_debitur_ukm`, `kode_marketing`, `nama_marketing`, `jenis_bantex`, `jumlah_bantex`) VALUES
('4501023614', 'D.1', 'Faisal', 'AO004', 'Edo', 'JAMINAN', '1'),
('4501023634', 'D.2', 'Yoriko', 'AO005', 'Rizky', 'ADMK', '2'),
('4501023650', 'D.3', 'Zafran', 'AO003', 'Eka Rizky', 'ADMK', '2'),
('4501023709', 'D.1', 'Jodi', 'AO003', 'Eka Rizky', 'JAMINAN', '1'),
('4501023722', 'D.3', 'Rudi', 'AO004', 'Edo', 'JAMINAN', '1'),
('4501023734', 'D.4', 'Habibi', 'AO005', 'Rizky', 'KREDIT', '2'),
('4501023748', 'D.4', 'Umar', 'AO004', 'Edo', 'ADMK', '2'),
('4501024107', 'D.3', 'Agung', 'AO002', 'Faisal', 'JAMINAN', '3'),
('4501024125', 'E.3', 'Hawariz', 'AO005', 'Rizky', 'ADMK', '1'),
('4501024154', 'E.2', 'Wildi', 'AO005', 'Rizky', 'JAMINAN', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_login`
--

CREATE TABLE `tb_login` (
  `id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `level` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_login`
--

INSERT INTO `tb_login` (`id`, `username`, `password`, `nama`, `level`) VALUES
('ID0001', 'admin', 'admin', 'admin', 'admin'),
('ID0002', 'eka', 'eka', 'eka', 'user'),
('ID0003', 'diana', 'diana', 'diana', 'user'),
('ID0004', 'faisal', 'faisal', 'faisal', 'user'),
('ID0005', 'fahmi', 'fahmi', 'fahmi', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `tb_marketing`
--

CREATE TABLE `tb_marketing` (
  `kode_marketing` varchar(10) NOT NULL,
  `nama_marketing` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_marketing`
--

INSERT INTO `tb_marketing` (`kode_marketing`, `nama_marketing`) VALUES
('AO001', 'Fahmi'),
('AO002', 'Faisal'),
('AO003', 'Eka Rizky'),
('AO004', 'Edo'),
('AO005', 'Rizky');

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE `tb_peminjaman` (
  `no_form` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `nama_marketing` varchar(20) NOT NULL,
  `unit_bisnis` varchar(22) NOT NULL,
  `jumlah_file` varchar(22) NOT NULL,
  `keperluan` varchar(2222) NOT NULL,
  `tanggal_pinjam` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_peminjaman`
--

INSERT INTO `tb_peminjaman` (`no_form`, `nama_debitur`, `nama_marketing`, `unit_bisnis`, `jumlah_file`, `keperluan`, `tanggal_pinjam`) VALUES
('GNS0001', 'Rachma', 'Eka Rizky', 'Legal', '2', 'Cek ulang', '10-08-2022'),
('GNS0002', 'Nugraha', 'Rizky', 'Legal', '3', 'Komite', '10-08-2022'),
('GNS0003', 'PT. KAMBOJA', 'Edo', 'Legal', '1', 'Komite', '10-08-2022'),
('GNS0004', 'PT. TIMOR LESTE', 'Edo', 'Analis', '2', 'Komite', '10-08-2022'),
('GNS0005', 'Haris', 'Fahmi', 'Analis', '2', 'Komite', '10-08-2022'),
('GNS0006', 'Haris', 'Faisal', 'AO', '1', 'Pengembalian telah lunas', '10-08-2022'),
('GNS0007', 'PT. SERANG', 'Faisal', 'Legal', '3', 'komite	', '10-08-2022'),
('GNS0008', 'PT. MIKROTRANS', 'Eka Rizky', 'Manager Operational', '10', 'Komite', '10-08-2022'),
('GNS0009', 'Zafran', 'Rizky', 'Account Operational', '3', 'Pengembalian', '10-08-2022'),
('GNS0010', 'Habibi', 'Edo', 'Legal', '2', 'komite', '10-08-2022');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian`
--

CREATE TABLE `tb_pengembalian` (
  `no_form` varchar(22) NOT NULL,
  `nama_debitur` varchar(22) NOT NULL,
  `nama_marketing` varchar(20) NOT NULL,
  `unit_bisnis` varchar(22) NOT NULL,
  `jumlah_file` varchar(22) NOT NULL,
  `keperluan` varchar(200) NOT NULL,
  `tanggal_kembali` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_pengembalian`
--

INSERT INTO `tb_pengembalian` (`no_form`, `nama_debitur`, `nama_marketing`, `unit_bisnis`, `jumlah_file`, `keperluan`, `tanggal_kembali`) VALUES
('GNS0002', 'Diana', 'Eka Rizky', 'IT', '2', 'trial', '21-07-2022');

--
-- Indexes for dumped tables
--

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
  ADD PRIMARY KEY (`no_pinjaman_bg`);

--
-- Indexes for table `tb_kr_ukm`
--
ALTER TABLE `tb_kr_ukm`
  ADD PRIMARY KEY (`no_pinjaman_ukm`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_marketing`
--
ALTER TABLE `tb_marketing`
  ADD PRIMARY KEY (`kode_marketing`);

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
