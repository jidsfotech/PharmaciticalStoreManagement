SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pharmaciticalstoredb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pharmaciticalstoredb` DEFAULT CHARACTER SET utf8 ;
USE `pharmaciticalstoredb` ;

-- -----------------------------------------------------
-- Table `pharmaciticalstoredb`.`medcategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmaciticalstoredb`.`medcategory` (
  `idMedCategory` INT(11) NOT NULL AUTO_INCREMENT,
  `Category` VARCHAR(45) NULL DEFAULT NULL,
  `Description` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`idMedCategory`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharmaciticalstoredb`.`medgroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmaciticalstoredb`.`medgroup` (
  `idMedGroup` INT(11) NOT NULL AUTO_INCREMENT,
  `MedGroup` VARCHAR(45) NULL DEFAULT NULL,
  `Classification` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idMedGroup`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharmaciticalstoredb`.`medicine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmaciticalstoredb`.`medicine` (
  `idMedicine` INT(11) NOT NULL AUTO_INCREMENT,
  `MedicineName` VARCHAR(45) NULL DEFAULT NULL,
  `QuantityInStore` INT(11) NULL DEFAULT NULL,
  `SalePrice` INT(11) NULL DEFAULT NULL,
  `InterestRate` INT(11) NULL DEFAULT NULL,
  `Manufacturer` VARCHAR(45) NULL DEFAULT NULL,
  `idMedCategory` INT(11) NOT NULL,
  `idMedGroup` INT(11) NOT NULL,
  PRIMARY KEY (`idMedicine`),
  INDEX `idMedGroup_idx` (`idMedGroup` ASC),
  INDEX `idMedCategory_idx` (`idMedCategory` ASC),
  CONSTRAINT `idMedCategory`
    FOREIGN KEY (`idMedCategory`)
    REFERENCES `pharmaciticalstoredb`.`medcategory` (`idMedCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idMedGroup`
    FOREIGN KEY (`idMedGroup`)
    REFERENCES `pharmaciticalstoredb`.`medgroup` (`idMedGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharmaciticalstoredb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmaciticalstoredb`.`user` (
  `idUser` INT(11) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NULL DEFAULT NULL,
  `Firstname` VARCHAR(30) NULL DEFAULT NULL,
  `Lastname` VARCHAR(30) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(45) NULL DEFAULT NULL,
  `Status` VARCHAR(20) NULL DEFAULT NULL,
  `ProfilePictures` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharmaciticalstoredb`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmaciticalstoredb`.`inventory` (
  `idInventory` INT(11) NOT NULL AUTO_INCREMENT,
  `idMedicine` INT(11) NULL DEFAULT NULL,
  `MedicineName` VARCHAR(45) NULL DEFAULT NULL,
  `QuantityInStore` INT(11) NULL DEFAULT NULL,
  `QuantityNewPurchase` INT(11) NULL DEFAULT NULL,
  `PurchasedPrice` INT(11) NULL DEFAULT NULL,
  `SalePrice` INT(11) NULL DEFAULT NULL,
  `InterestRate` INT(11) NULL DEFAULT NULL,
  `dateAdded` DATETIME NULL DEFAULT NULL,
  `ManufDate` DATE NULL DEFAULT NULL,
  `ExpDate` DATE NULL DEFAULT NULL,
  `idUser` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idInventory`),
  INDEX `idUser_idx` (`idUser` ASC),
  INDEX `idMedicine_idx` (`idMedicine` ASC),
  CONSTRAINT `idMedicine`
    FOREIGN KEY (`idMedicine`)
    REFERENCES `pharmaciticalstoredb`.`medicine` (`idMedicine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idUser`
    FOREIGN KEY (`idUser`)
    REFERENCES `pharmaciticalstoredb`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 38
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharmaciticalstoredb`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmaciticalstoredb`.`sales` (
  `idSales` INT(11) NOT NULL AUTO_INCREMENT,
  `SalesDate` DATETIME NULL DEFAULT NULL,
  `SalesPrice` INT(11) NULL DEFAULT NULL,
  `Quantity` INT(11) NULL DEFAULT NULL,
  `Discount` INT(11) NULL DEFAULT NULL,
  `IdMedicine` INT(11) NOT NULL,
  `IdUser` INT(11) NOT NULL,
  `MedicineName` VARCHAR(45) NULL DEFAULT NULL,
  `TransactionID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idSales`),
  INDEX `IdMedicine_idx` (`IdMedicine` ASC),
  INDEX `IdUser_idx` (`IdUser` ASC),
  INDEX `TransactionID_idx` (`TransactionID` ASC),
  CONSTRAINT `id_medicine`
    FOREIGN KEY (`IdMedicine`)
    REFERENCES `pharmaciticalstoredb`.`medicine` (`idMedicine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_User`
    FOREIGN KEY (`IdUser`)
    REFERENCES `pharmaciticalstoredb`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 66
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharmaciticalstoredb`.`transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmaciticalstoredb`.`transactions` (
  `TransactionID` INT(11) NOT NULL AUTO_INCREMENT,
  `TransactionsRefNumber` VARCHAR(45) NULL DEFAULT NULL,
  `DateTime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`TransactionID`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
