-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Jan 2022 pada 06.53
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtoko`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `id_buku` int(11) NOT NULL,
  `no_isbn` varchar(13) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `pengarang` varchar(40) NOT NULL,
  `penerbit` varchar(40) NOT NULL,
  `tahun_terbit` varchar(10) NOT NULL,
  `kategori` varchar(40) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga_pokok` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id_buku`, `no_isbn`, `judul`, `pengarang`, `penerbit`, `tahun_terbit`, `kategori`, `stok`, `harga_pokok`, `harga_jual`) VALUES
(1, '12345678', 'Mentari Pagi', 'Khansa Nanda Tasya', 'Lubna', '2022', 'Sastra', 18, 40000, 45000),
(2, '12345677', 'Kau yang Dulu', 'Athilla Abrar', 'Muhammad', '2020', 'Novel', 15, 50000, 55000),
(3, '12345676', 'Senja', 'Lubna Zianka', 'Keluarga dihilir', '2020', 'Novel', 10, 45000, 48000),
(4, '12345675', 'Akan ku Kejar', 'Riyadh Hafili', 'Keluarga dihilir', '2012', 'Sastra', 5, 20000, 25000),
(7, '12345674', 'Bukan Untuknya', 'Chaca', 'Lisa', '2021', 'Sastra', 8, 30000, 32000),
(9, '12345672', 'Masih Ada', 'Khansa Nanda Tasya', 'Khaidir', '2022', 'Novel', 25, 30000, 36000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kasir`
--

CREATE TABLE `kasir` (
  `id_kasir` int(11) NOT NULL,
  `nama_kasir` varchar(40) NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kasir`
--

INSERT INTO `kasir` (`id_kasir`, `nama_kasir`, `alamat`, `no_telp`, `email`) VALUES
(1, 'athilla', 'Jl.Bintara, No.11', '08734628821', 'athilla10@gmail.com'),
(2, 'nanda', 'Jl. Inpres, No.103', '082258427924', 'nanda11@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `id_transaksi` varchar(20) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `judul` varchar(50) NOT NULL,
  `kategori` varchar(40) NOT NULL,
  `hsatuan` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`id_transaksi`, `id_buku`, `tanggal`, `judul`, `kategori`, `hsatuan`, `jumlah_beli`, `harga`, `bayar`, `kembalian`) VALUES
('F0001', 1, '2020-07-04', 'Pelangi di pagi hari', 'Sastra', 45000, 2, 90000, 100000, 10000),
('F0002', 2, '2020-07-04', 'Kau yang Indah', 'Novel', 55000, 1, 55000, 110000, 5000),
('F0002', 4, '2020-07-04', 'ku kejar', 'Sastra', 25000, 2, 50000, 110000, 5000),
('F0003', 2, '2020-07-05', 'Kau yang Indah', 'Novel', 55000, 1, 55000, 100000, 20000),
('F0003', 4, '2020-07-05', 'ku kejar', 'Sastra', 25000, 1, 25000, 100000, 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan_detail`
--

CREATE TABLE `penjualan_detail` (
  `id_detail` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `kategori` varchar(40) NOT NULL,
  `hsatuan` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Trigger `penjualan_detail`
--
DELIMITER $$
CREATE TRIGGER `batal` AFTER DELETE ON `penjualan_detail` FOR EACH ROW BEGIN
UPDATE buku SET stok = stok + OLD.jumlah_beli
WHERE id_buku = OLD.id_buku;
    END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `beli` AFTER INSERT ON `penjualan_detail` FOR EACH ROW BEGIN
	UPDATE buku SET stok = stok - new.jumlah_beli 
WHERE id_buku = new.`id_buku`; 
    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kategori`
--

CREATE TABLE `tbl_kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_kategori`
--

INSERT INTO `tbl_kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Novel'),
(10, 'Komputer'),
(11, 'Sastra'),
(14, 'Pemrograman'),
(15, 'Simple');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(8) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `level`) VALUES
(1, 'khansa', 'khansa12', 'pemilik'),
(2, 'athilla', 'athilla0', 'kasir'),
(3, 'nanda', 'nanda0', 'kasir'),
(5, 'shafa', 'shafa2', 'kasir'),
(6, 'chaca', 'chaca3', 'pemilik');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indeks untuk tabel `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id_kasir`);

--
-- Indeks untuk tabel `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  ADD PRIMARY KEY (`id_detail`);

--
-- Indeks untuk tabel `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id_kasir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `penjualan_detail`
--
ALTER TABLE `penjualan_detail`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
