-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.45-community - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for thirdproject
CREATE DATABASE IF NOT EXISTS `thirdproject` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `thirdproject`;

-- Dumping structure for table thirdproject.ad_keys
CREATE TABLE IF NOT EXISTS `ad_keys` (
  `id` varchar(50) DEFAULT NULL,
  `Filename` varchar(50) DEFAULT NULL,
  `Keys` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.ad_upload
CREATE TABLE IF NOT EXISTS `ad_upload` (
  `id` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `displaysize` varchar(100) DEFAULT NULL,
  `processorname` varchar(50) DEFAULT NULL,
  `hard_disk_cap` varchar(50) DEFAULT NULL,
  `RAM_size` varchar(50) DEFAULT NULL,
  `Model_name` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `security_num` varchar(50) DEFAULT NULL,
  `RAM_Type` varchar(50) DEFAULT NULL,
  `warranty` varchar(50) DEFAULT NULL,
  `Touchscreen` varchar(50) DEFAULT NULL,
  `graphic_processor` varchar(200) DEFAULT NULL,
  `suitable` varchar(300) DEFAULT NULL,
  `speaker` varchar(300) DEFAULT NULL,
  `screen_type` varchar(500) DEFAULT NULL,
  `power_supply` varchar(300) DEFAULT NULL,
  `Keyboard` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cl_chooseplan
CREATE TABLE IF NOT EXISTS `cl_chooseplan` (
  `name` varchar(50) DEFAULT NULL,
  `service` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  `validity` varchar(50) DEFAULT NULL,
  `storage` varchar(50) DEFAULT NULL,
  `security` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cl_file
CREATE TABLE IF NOT EXISTS `cl_file` (
  `id` longtext,
  `clientname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cl_payment
CREATE TABLE IF NOT EXISTS `cl_payment` (
  `name` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  `cdnumber` varchar(50) DEFAULT NULL,
  `cdname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cl_query
CREATE TABLE IF NOT EXISTS `cl_query` (
  `name` varchar(50) DEFAULT NULL,
  `fid` varchar(50) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `cloumn id` varchar(50) DEFAULT NULL,
  `Question` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cl_register
CREATE TABLE IF NOT EXISTS `cl_register` (
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `cpass` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `org` varchar(50) DEFAULT NULL,
  `pcode` varchar(50) DEFAULT NULL,
  `add` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cl_upload
CREATE TABLE IF NOT EXISTS `cl_upload` (
  `id` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `displaysize` varchar(100) DEFAULT NULL,
  `processorname` varchar(50) DEFAULT NULL,
  `hard_disk_cap` varchar(50) DEFAULT NULL,
  `RAM_size` varchar(50) DEFAULT NULL,
  `Model_name` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `security_num` varchar(50) DEFAULT NULL,
  `RAM_Type` varchar(50) DEFAULT NULL,
  `warranty` varchar(50) DEFAULT NULL,
  `Touchscreen` varchar(50) DEFAULT NULL,
  `graphic_processor` varchar(200) DEFAULT NULL,
  `suitable` varchar(300) DEFAULT NULL,
  `speaker` varchar(300) DEFAULT NULL,
  `screen_type` varchar(500) DEFAULT NULL,
  `power_supply` varchar(300) DEFAULT NULL,
  `Keyboard` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cv_dec
CREATE TABLE IF NOT EXISTS `cv_dec` (
  `id` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `displaysize` varchar(100) DEFAULT NULL,
  `processorname` varchar(50) DEFAULT NULL,
  `hard_disk_cap` varchar(50) DEFAULT NULL,
  `RAM_size` varchar(50) DEFAULT NULL,
  `Model_name` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `security_num` varchar(50) DEFAULT NULL,
  `RAM_Type` varchar(50) DEFAULT NULL,
  `warranty` varchar(50) DEFAULT NULL,
  `Touchscreen` varchar(50) DEFAULT NULL,
  `graphic_processor` varchar(200) DEFAULT NULL,
  `suitable` varchar(300) DEFAULT NULL,
  `speaker` varchar(300) DEFAULT NULL,
  `screen_type` varchar(500) DEFAULT NULL,
  `power_supply` varchar(300) DEFAULT NULL,
  `Keyboard` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cv_planupdate
CREATE TABLE IF NOT EXISTS `cv_planupdate` (
  `service` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  `validity` varchar(50) DEFAULT NULL,
  `storage` varchar(50) DEFAULT NULL,
  `security` varchar(50) DEFAULT NULL,
  `annual` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cv_register
CREATE TABLE IF NOT EXISTS `cv_register` (
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `cpass` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `org` varchar(50) DEFAULT NULL,
  `pcode` varchar(50) DEFAULT NULL,
  `add` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cv_updatefile
CREATE TABLE IF NOT EXISTS `cv_updatefile` (
  `id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `file` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.cv_updateplan
CREATE TABLE IF NOT EXISTS `cv_updateplan` (
  `name` varchar(50) DEFAULT NULL,
  `service` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  `validty` varchar(50) DEFAULT NULL,
  `storage` varchar(50) DEFAULT NULL,
  `security` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.or_enc
CREATE TABLE IF NOT EXISTS `or_enc` (
  `id` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `displaysize` varchar(100) DEFAULT NULL,
  `processorname` varchar(50) DEFAULT NULL,
  `hard_disk_cap` varchar(50) DEFAULT NULL,
  `RAM_size` varchar(50) DEFAULT NULL,
  `Model_name` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `security_num` varchar(50) DEFAULT NULL,
  `RAM_Type` varchar(50) DEFAULT NULL,
  `warranty` varchar(50) DEFAULT NULL,
  `Touchscreen` varchar(50) DEFAULT NULL,
  `graphic_processor` varchar(200) DEFAULT NULL,
  `suitable` varchar(300) DEFAULT NULL,
  `speaker` varchar(300) DEFAULT NULL,
  `screen_type` varchar(500) DEFAULT NULL,
  `power_supply` varchar(300) DEFAULT NULL,
  `Keyboard` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.or_register
CREATE TABLE IF NOT EXISTS `or_register` (
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `cpass` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `org` varchar(50) DEFAULT NULL,
  `pcode` varchar(50) DEFAULT NULL,
  `add` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table thirdproject.or_sendtocv
CREATE TABLE IF NOT EXISTS `or_sendtocv` (
  `id` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `displaysize` varchar(100) DEFAULT NULL,
  `processorname` varchar(50) DEFAULT NULL,
  `hard_disk_cap` varchar(50) DEFAULT NULL,
  `RAM_size` varchar(50) DEFAULT NULL,
  `Model_name` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `security_num` varchar(50) DEFAULT NULL,
  `RAM_Type` varchar(50) DEFAULT NULL,
  `warranty` varchar(50) DEFAULT NULL,
  `Touchscreen` varchar(50) DEFAULT NULL,
  `graphic_processor` varchar(200) DEFAULT NULL,
  `suitable` varchar(300) DEFAULT NULL,
  `speaker` varchar(300) DEFAULT NULL,
  `screen_type` varchar(500) DEFAULT NULL,
  `power_supply` varchar(300) DEFAULT NULL,
  `Keyboard` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
