-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.12-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para exercise06
DROP DATABASE IF EXISTS `exercise06`;
CREATE DATABASE IF NOT EXISTS `exercise06` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `exercise06`;

-- Volcando estructura para tabla exercise06.empleados
DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `id` int(11) DEFAULT NULL,
  `first` char(50) DEFAULT NULL,
  `last` char(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla exercise06.empleados: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` (`id`, `first`, `last`, `age`) VALUES
	(1, 'Pedro', 'Garcia', 32),
	(2, 'Aurora', 'Perez', 31),
	(3, 'Ruben', 'Martín', 21);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
