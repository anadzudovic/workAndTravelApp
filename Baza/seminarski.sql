-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2019 at 11:10 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `seminarski`
--

-- --------------------------------------------------------

--
-- Table structure for table `agent`
--

CREATE TABLE `agent` (
  `sifraAgent` int(11) NOT NULL,
  `korisnickoIme` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lozinka` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `imeIPrezime` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `agent`
--

INSERT INTO `agent` (`sifraAgent`, `korisnickoIme`, `lozinka`, `imeIPrezime`) VALUES
(1, 'ana', '123', 'Ana Dzudovic'),
(2, 'milica', '789', 'Milica Peric');

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

CREATE TABLE `angazovanje` (
  `sifraAngazovanje` int(11) NOT NULL,
  `besplatanSmestaj` tinyint(1) DEFAULT NULL,
  `besplatanObrok` tinyint(1) DEFAULT NULL,
  `StatusUgovora` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sifraStudent` int(11) DEFAULT NULL,
  `sifraRM` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `angazovanje`
--

INSERT INTO `angazovanje` (`sifraAngazovanje`, `besplatanSmestaj`, `besplatanObrok`, `StatusUgovora`, `sifraStudent`, `sifraRM`) VALUES
(9, 0, 0, 'vazeci', 14, 11),
(10, 0, 0, 'vazeci', 18, 9),
(11, 0, 0, 'vazeci', 19, 9),
(12, 0, 0, 'vazeci', 3, 11),
(13, 0, 0, 'vazeci', 4, 9),
(14, 0, 0, 'vazeci', 16, 10),
(15, 0, 0, 'vazeci', 20, 11);

-- --------------------------------------------------------

--
-- Table structure for table `drzava`
--

CREATE TABLE `drzava` (
  `sifraDrzava` int(11) NOT NULL,
  `nazivDrzava` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `drzava`
--

INSERT INTO `drzava` (`sifraDrzava`, `nazivDrzava`) VALUES
(1, 'Republika Srbija'),
(2, 'New York'),
(3, 'California'),
(4, 'Florida');

-- --------------------------------------------------------

--
-- Table structure for table `grad`
--

CREATE TABLE `grad` (
  `sifraGrad` int(11) NOT NULL,
  `nazivGrad` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sifraDrzava` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `grad`
--

INSERT INTO `grad` (`sifraGrad`, `nazivGrad`, `sifraDrzava`) VALUES
(4, 'New York', 2),
(5, 'Buffalo', 2),
(6, 'Albany', 2),
(7, 'Los Angeles', 3),
(8, 'San Diego', 3),
(9, 'Tampa', 4),
(10, 'Jacksonville', 4);

-- --------------------------------------------------------

--
-- Table structure for table `poslodavac`
--

CREATE TABLE `poslodavac` (
  `sifraPoslodavac` int(11) NOT NULL,
  `nazivKompanije` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `imeiprezimevlasnik` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `kontaktelefon` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `elektronskaposta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sifraGrad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `poslodavac`
--

INSERT INTO `poslodavac` (`sifraPoslodavac`, `nazivKompanije`, `imeiprezimevlasnik`, `kontaktelefon`, `elektronskaposta`, `sifraGrad`) VALUES
(3, 'Start Hotel', 'Mark Hanson', '+397454545', 'starhotel@yahoo.com', 6),
(9, 'Beach Sun Resort', 'Tina Ferry', '+789456123', 'beachsun@gmail.com', 8),
(10, 'Big Blue Resort', 'Lena Headly', '+78789645', 'bb@gmail.com', 7),
(11, 'Caffee Mochiato', 'Marie Genie', '+789145555', 'coffeforfun@yahoo.com', 9),
(12, 'BendsAndDJs', 'Layza  Pablin', '+351789471', 'bdj@yahoo.com', 7);

-- --------------------------------------------------------

--
-- Table structure for table `radnomesto`
--

CREATE TABLE `radnomesto` (
  `sifraRadnomesto` int(255) NOT NULL,
  `opisRadnoMesto` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mogucaNapojnica` tinyint(1) DEFAULT NULL,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  `satnica` double NOT NULL,
  `ukupanBrojIzvrsioca` int(11) NOT NULL,
  `preostaoBrojIzvrsioca` int(11) DEFAULT NULL,
  `sifraTipRM` int(11) DEFAULT NULL,
  `sifraPoslodavac` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `radnomesto`
--

INSERT INTO `radnomesto` (`sifraRadnomesto`, `opisRadnoMesto`, `mogucaNapojnica`, `datumOd`, `datumDo`, `satnica`, `ukupanBrojIzvrsioca`, `preostaoBrojIzvrsioca`, `sifraTipRM`, `sifraPoslodavac`) VALUES
(9, 'Na ovom mestu ocekuje se nadgledanje bazena za decu i bazena za odrasle. Dogovor sa poslodavcem o smenama.', 0, '2019-06-05', '2019-09-28', 18, 4, 1, 1, 9),
(10, 'Spremanje alkoholnih i bezalkoholnih pica.', 1, '2019-07-15', '2019-09-28', 13, 3, 2, 2, 3),
(11, 'Muckanje alkoholnih bica u beach baru!', 0, '2019-05-13', '2019-08-11', 22, 5, 2, 2, 12);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sifraStudent` int(11) NOT NULL,
  `imeIPrezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datumRodjenja` date DEFAULT NULL,
  `kontaktTelefon` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `elektronskaPosta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jmbg` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `brojLicneKarte` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `brojPasosa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sifraStudent`, `imeIPrezime`, `datumRodjenja`, `kontaktTelefon`, `elektronskaPosta`, `jmbg`, `brojLicneKarte`, `brojPasosa`, `adresa`) VALUES
(1, 'Ana Dzudovic', '2018-05-08', '0644559828', 'ana@gmail.com', '2402996785812', '1212121', '1212', 'Rimska 6, Novi Sad'),
(3, 'Ana Colovic', '1995-01-10', '067898987', 'colke@gmail.com', '7814967852312', '787878', '123456', 'Rimska 4, Beograd'),
(4, 'Marina Stanic', '2019-01-28', '067454545', 'mars@gmail.com', '78787878', '4545454545', '121212', 'Pariska 7, Novi Sad'),
(13, 'Marija Sretenovic', '2019-02-10', '064789525', 'maki@gmail.com', '787845621', '1111111', '1236547', 'Velikomoravska 11, Beograd'),
(14, 'Jovana Mitrovic', '1989-02-02', '0644226347', 'jolecar@gmail.com', '2701996789654', '7814520', '0001478952', 'Cetinjska7,Beograd'),
(16, 'Jelisaveta Sapsaj', '1997-04-16', '0647825139', 'lizaa@gmail.com', '1402997454512', '45454545', '7896321', 'Ustanicka 9, Beograd'),
(17, 'Lena Dzudovic', '2000-03-26', '0645891235', 'lenadzudovic@gmail.com', '2603007891236', '', '', ''),
(18, 'Marko Jokanovic', '1997-02-17', '067898988', 'marko@yahoo.com', '1234567893333', '333222', '222333', 'Strahinjica Bana 38, Beograd'),
(19, 'Stefan Jokanovic', '1995-01-30', '067412536', 'stefan@yahoo.com', '1234569871236', '12121212', '58585858', 'Strahinjica Bana 38, Beograd'),
(20, 'Aleksandra Rakic', '1996-02-05', '067898989', 'aleks@gmail.com', '4545454545456', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tipradnogmesta`
--

CREATE TABLE `tipradnogmesta` (
  `sifraTipRadnogMesta` int(11) NOT NULL,
  `nazivTipRadnogMesta` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tipradnogmesta`
--

INSERT INTO `tipradnogmesta` (`sifraTipRadnogMesta`, `nazivTipRadnogMesta`) VALUES
(1, 'spasilac'),
(2, 'sanker'),
(3, 'dj'),
(4, 'konobar'),
(5, 'radnik u kuhinji'),
(6, 'kuvar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`sifraAgent`);

--
-- Indexes for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD PRIMARY KEY (`sifraAngazovanje`),
  ADD KEY `sifraStudent` (`sifraStudent`),
  ADD KEY `sifraRM` (`sifraRM`);

--
-- Indexes for table `drzava`
--
ALTER TABLE `drzava`
  ADD PRIMARY KEY (`sifraDrzava`);

--
-- Indexes for table `grad`
--
ALTER TABLE `grad`
  ADD PRIMARY KEY (`sifraGrad`),
  ADD KEY `sifraDrzava` (`sifraDrzava`);

--
-- Indexes for table `poslodavac`
--
ALTER TABLE `poslodavac`
  ADD PRIMARY KEY (`sifraPoslodavac`),
  ADD KEY `sifraGrad` (`sifraGrad`);

--
-- Indexes for table `radnomesto`
--
ALTER TABLE `radnomesto`
  ADD PRIMARY KEY (`sifraRadnomesto`),
  ADD KEY `sifraTipRM` (`sifraTipRM`),
  ADD KEY `sifraPoslodavac` (`sifraPoslodavac`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`sifraStudent`);

--
-- Indexes for table `tipradnogmesta`
--
ALTER TABLE `tipradnogmesta`
  ADD PRIMARY KEY (`sifraTipRadnogMesta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agent`
--
ALTER TABLE `agent`
  MODIFY `sifraAgent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `angazovanje`
--
ALTER TABLE `angazovanje`
  MODIFY `sifraAngazovanje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `drzava`
--
ALTER TABLE `drzava`
  MODIFY `sifraDrzava` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `grad`
--
ALTER TABLE `grad`
  MODIFY `sifraGrad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `poslodavac`
--
ALTER TABLE `poslodavac`
  MODIFY `sifraPoslodavac` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `radnomesto`
--
ALTER TABLE `radnomesto`
  MODIFY `sifraRadnomesto` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `sifraStudent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tipradnogmesta`
--
ALTER TABLE `tipradnogmesta`
  MODIFY `sifraTipRadnogMesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD CONSTRAINT `angazovanje_ibfk_1` FOREIGN KEY (`sifraStudent`) REFERENCES `student` (`sifraStudent`),
  ADD CONSTRAINT `angazovanje_ibfk_2` FOREIGN KEY (`sifraRM`) REFERENCES `radnomesto` (`sifraRadnomesto`);

--
-- Constraints for table `grad`
--
ALTER TABLE `grad`
  ADD CONSTRAINT `grad_ibfk_1` FOREIGN KEY (`sifraDrzava`) REFERENCES `drzava` (`sifraDrzava`);

--
-- Constraints for table `poslodavac`
--
ALTER TABLE `poslodavac`
  ADD CONSTRAINT `poslodavac_ibfk_1` FOREIGN KEY (`sifraGrad`) REFERENCES `grad` (`sifraGrad`);

--
-- Constraints for table `radnomesto`
--
ALTER TABLE `radnomesto`
  ADD CONSTRAINT `radnomesto_ibfk_1` FOREIGN KEY (`sifraTipRM`) REFERENCES `tipradnogmesta` (`sifraTipRadnogMesta`),
  ADD CONSTRAINT `radnomesto_ibfk_2` FOREIGN KEY (`sifraPoslodavac`) REFERENCES `poslodavac` (`sifraPoslodavac`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
