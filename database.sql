-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mobile_ebay
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mobile_ebay
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mobile_ebay` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mobile_ebay` ;

-- -----------------------------------------------------
-- Table `mobile_ebay`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`customers` (
  `customerid` VARCHAR(11) NOT NULL,
  `account_created` DATETIME(6) NULL DEFAULT NULL,
  `enable` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`customerid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`product_owners`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`product_owners` (
  `product_ownerid` BIGINT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `enable` INT NOT NULL,
  `rating` INT NOT NULL,
  `sales_made` INT NOT NULL,
  `customerid` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`product_ownerid`),
  INDEX `FKn1yl1s1dagsnqh17e4c3vwaa7` (`customerid` ASC) VISIBLE,
  CONSTRAINT `FKn1yl1s1dagsnqh17e4c3vwaa7`
    FOREIGN KEY (`customerid`)
    REFERENCES `mobile_ebay`.`customers` (`customerid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`departments` (
  `department_id` BIGINT NOT NULL,
  `department_name` VARCHAR(30) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `enable` INT NOT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`products` (
  `productsid` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `end_bid` DATE NOT NULL,
  `image_path` VARCHAR(255) NULL DEFAULT NULL,
  `item_path` VARCHAR(255) NOT NULL,
  `start_bid` DATE NOT NULL,
  `state` VARCHAR(30) NOT NULL,
  `title` VARCHAR(30) NOT NULL,
  `department_id` BIGINT NOT NULL,
  `product_ownerid` BIGINT NOT NULL,
  `enable` INT NOT NULL,
  PRIMARY KEY (`productsid`),
  INDEX `FKc9stuqei39x9kx3pcty55aj08` (`department_id` ASC) VISIBLE,
  INDEX `FK4cw3s1sksvtq33cp5wv3xdd6s` (`product_ownerid` ASC) VISIBLE,
  CONSTRAINT `FK4cw3s1sksvtq33cp5wv3xdd6s`
    FOREIGN KEY (`product_ownerid`)
    REFERENCES `mobile_ebay`.`product_owners` (`product_ownerid`),
  CONSTRAINT `FKc9stuqei39x9kx3pcty55aj08`
    FOREIGN KEY (`department_id`)
    REFERENCES `mobile_ebay`.`departments` (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`bids`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`bids` (
  `bidid` BIGINT NOT NULL,
  `bid_quantity` INT NOT NULL,
  `bid_time_set` DATE NOT NULL,
  `customerid` VARCHAR(11) NOT NULL,
  `productsid` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`bidid`),
  INDEX `FKprpn4afqj5hvs3ee00mirss1p` (`productsid` ASC) VISIBLE,
  INDEX `FK8dwlj2l3swxt3gcdugwj14ae9` (`customerid` ASC) VISIBLE,
  CONSTRAINT `FK8dwlj2l3swxt3gcdugwj14ae9`
    FOREIGN KEY (`customerid`)
    REFERENCES `mobile_ebay`.`customers` (`customerid`),
  CONSTRAINT `FKprpn4afqj5hvs3ee00mirss1p`
    FOREIGN KEY (`productsid`)
    REFERENCES `mobile_ebay`.`products` (`productsid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`products_customerid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`products_customerid` (
  `products_productsid` VARCHAR(255) NOT NULL,
  `customerid_bidid` BIGINT NOT NULL,
  UNIQUE INDEX `UK_nsqj0klmfr12cdnb26o8xvevh` (`customerid_bidid` ASC) VISIBLE,
  INDEX `FKaegi6f85tgpl9erv2hk88f2wc` (`products_productsid` ASC) VISIBLE,
  CONSTRAINT `FKaegi6f85tgpl9erv2hk88f2wc`
    FOREIGN KEY (`products_productsid`)
    REFERENCES `mobile_ebay`.`products` (`productsid`),
  CONSTRAINT `FKeyq8wwkgtcm4m90h1d7elkcd7`
    FOREIGN KEY (`customerid_bidid`)
    REFERENCES `mobile_ebay`.`bids` (`bidid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`sales` (
  `salesid` BIGINT NOT NULL,
  `transaction_time` DATE NOT NULL,
  `buyer_customerid` VARCHAR(11) NULL DEFAULT NULL,
  `selled_product_productsid` VARCHAR(255) NULL DEFAULT NULL,
  `seller_product_ownerid` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`salesid`),
  INDEX `FKfo6gxau42ck1hmxecdscm2klq` (`buyer_customerid` ASC) VISIBLE,
  INDEX `FK9o4mflcl28w2ujwkn65qgkmlc` (`selled_product_productsid` ASC) VISIBLE,
  INDEX `FK72neo4c48epkr4mp9mek51d8u` (`seller_product_ownerid` ASC) VISIBLE,
  CONSTRAINT `FK72neo4c48epkr4mp9mek51d8u`
    FOREIGN KEY (`seller_product_ownerid`)
    REFERENCES `mobile_ebay`.`product_owners` (`product_ownerid`),
  CONSTRAINT `FK9o4mflcl28w2ujwkn65qgkmlc`
    FOREIGN KEY (`selled_product_productsid`)
    REFERENCES `mobile_ebay`.`products` (`productsid`),
  CONSTRAINT `FKfo6gxau42ck1hmxecdscm2klq`
    FOREIGN KEY (`buyer_customerid`)
    REFERENCES `mobile_ebay`.`customers` (`customerid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mobile_ebay
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mobile_ebay
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mobile_ebay` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mobile_ebay` ;

-- -----------------------------------------------------
-- Table `mobile_ebay`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`customers` (
  `customerid` VARCHAR(11) NOT NULL,
  `account_created` DATETIME(6) NULL DEFAULT NULL,
  `enable` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`customerid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`product_owners`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`product_owners` (
  `product_ownerid` BIGINT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `enable` INT NOT NULL,
  `rating` INT NOT NULL,
  `sales_made` INT NOT NULL,
  `customerid` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`product_ownerid`),
  INDEX `FKn1yl1s1dagsnqh17e4c3vwaa7` (`customerid` ASC) VISIBLE,
  CONSTRAINT `FKn1yl1s1dagsnqh17e4c3vwaa7`
    FOREIGN KEY (`customerid`)
    REFERENCES `mobile_ebay`.`customers` (`customerid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`departments` (
  `department_id` BIGINT NOT NULL,
  `department_name` VARCHAR(30) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `enable` INT NOT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`products` (
  `productsid` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `end_bid` DATE NOT NULL,
  `image_path` VARCHAR(255) NULL DEFAULT NULL,
  `item_path` VARCHAR(255) NOT NULL,
  `start_bid` DATE NOT NULL,
  `state` VARCHAR(30) NOT NULL,
  `title` VARCHAR(30) NOT NULL,
  `department_id` BIGINT NOT NULL,
  `product_ownerid` BIGINT NOT NULL,
  `enable` INT NOT NULL,
  PRIMARY KEY (`productsid`),
  INDEX `FKc9stuqei39x9kx3pcty55aj08` (`department_id` ASC) VISIBLE,
  INDEX `FK4cw3s1sksvtq33cp5wv3xdd6s` (`product_ownerid` ASC) VISIBLE,
  CONSTRAINT `FK4cw3s1sksvtq33cp5wv3xdd6s`
    FOREIGN KEY (`product_ownerid`)
    REFERENCES `mobile_ebay`.`product_owners` (`product_ownerid`),
  CONSTRAINT `FKc9stuqei39x9kx3pcty55aj08`
    FOREIGN KEY (`department_id`)
    REFERENCES `mobile_ebay`.`departments` (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`bids`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`bids` (
  `bidid` BIGINT NOT NULL,
  `bid_quantity` INT NOT NULL,
  `bid_time_set` DATE NOT NULL,
  `customerid` VARCHAR(11) NOT NULL,
  `productsid` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`bidid`),
  INDEX `FKprpn4afqj5hvs3ee00mirss1p` (`productsid` ASC) VISIBLE,
  INDEX `FK8dwlj2l3swxt3gcdugwj14ae9` (`customerid` ASC) VISIBLE,
  CONSTRAINT `FK8dwlj2l3swxt3gcdugwj14ae9`
    FOREIGN KEY (`customerid`)
    REFERENCES `mobile_ebay`.`customers` (`customerid`),
  CONSTRAINT `FKprpn4afqj5hvs3ee00mirss1p`
    FOREIGN KEY (`productsid`)
    REFERENCES `mobile_ebay`.`products` (`productsid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`products_customerid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`products_customerid` (
  `products_productsid` VARCHAR(255) NOT NULL,
  `customerid_bidid` BIGINT NOT NULL,
  UNIQUE INDEX `UK_nsqj0klmfr12cdnb26o8xvevh` (`customerid_bidid` ASC) VISIBLE,
  INDEX `FKaegi6f85tgpl9erv2hk88f2wc` (`products_productsid` ASC) VISIBLE,
  CONSTRAINT `FKaegi6f85tgpl9erv2hk88f2wc`
    FOREIGN KEY (`products_productsid`)
    REFERENCES `mobile_ebay`.`products` (`productsid`),
  CONSTRAINT `FKeyq8wwkgtcm4m90h1d7elkcd7`
    FOREIGN KEY (`customerid_bidid`)
    REFERENCES `mobile_ebay`.`bids` (`bidid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mobile_ebay`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile_ebay`.`sales` (
  `salesid` BIGINT NOT NULL,
  `transaction_time` DATE NOT NULL,
  `buyer_customerid` VARCHAR(11) NULL DEFAULT NULL,
  `selled_product_productsid` VARCHAR(255) NULL DEFAULT NULL,
  `seller_product_ownerid` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`salesid`),
  INDEX `FKfo6gxau42ck1hmxecdscm2klq` (`buyer_customerid` ASC) VISIBLE,
  INDEX `FK9o4mflcl28w2ujwkn65qgkmlc` (`selled_product_productsid` ASC) VISIBLE,
  INDEX `FK72neo4c48epkr4mp9mek51d8u` (`seller_product_ownerid` ASC) VISIBLE,
  CONSTRAINT `FK72neo4c48epkr4mp9mek51d8u`
    FOREIGN KEY (`seller_product_ownerid`)
    REFERENCES `mobile_ebay`.`product_owners` (`product_ownerid`),
  CONSTRAINT `FK9o4mflcl28w2ujwkn65qgkmlc`
    FOREIGN KEY (`selled_product_productsid`)
    REFERENCES `mobile_ebay`.`products` (`productsid`),
  CONSTRAINT `FKfo6gxau42ck1hmxecdscm2klq`
    FOREIGN KEY (`buyer_customerid`)
    REFERENCES `mobile_ebay`.`customers` (`customerid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
