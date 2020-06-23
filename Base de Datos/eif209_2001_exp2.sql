SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema eif209_2001_exp2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eif209_2001_exp2` ;

-- -----------------------------------------------------
-- Schema eif209_2001_exp2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eif209_2001_exp2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci ;
USE `eif209_2001_exp2` ;

-- -----------------------------------------------------
-- Table `eif209_2001_exp2`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eif209_2001_exp2`.`usuario` ;

CREATE TABLE IF NOT EXISTS `eif209_2001_exp2`.`usuario` (
  `correo` VARCHAR(40) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`correo`))
ENGINE = InnoDB;

DROP TABLE IF EXISTS `eif209_2001_exp2`.`correo` ;

-- -----------------------------------------------------
-- Table `eif209_2001_exp2`.`correo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2001_exp2`.`correo` (
  `id_correo` INT NOT NULL AUTO_INCREMENT,
  `emisor` VARCHAR(45) NOT NULL,
  `destinatario` VARCHAR(45) NOT NULL,
  `asunto` VARCHAR(20) NOT NULL,
  `mensaje` VARCHAR(50) NULL,
  `estado` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_correo`),
  INDEX `fk_emisor_idx` (`emisor` ASC),
  INDEX `fk_destinatario_idx` (`destinatario` ASC),
  CONSTRAINT `fk_emisor`
    FOREIGN KEY (`emisor`)
    REFERENCES `eif209_2001_exp2`.`usuario` (`correo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_destinatario`
    FOREIGN KEY (`destinatario`)
    REFERENCES `eif209_2001_exp2`.`usuario` (`correo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `eif209_2001_exp2`.`usuario`
	(`correo`, `password`)
	VALUES
		('georges.alfaro@eif209.una.ac.cr', 'georges123'),
		('carolina.salazar@eif209.una.ac.cr', 'carolina123'),
		('carlos.mora@alla.lejos.com', 'carlos123')
	;
    
INSERT INTO `eif209_2001_exp2`.`correo`
	(`emisor`, `destinatario`, `asunto`, `mensaje`, `estado`)
	VALUES
		('georges.alfaro@eif209.una.ac.cr', 'carolina.salazar@eif209.una.ac.cr', 'saludo', 'hola, espero que te encuentres bien.', 1),
		('carolina.salazar@eif209.una.ac.cr', 'georges.alfaro@eif209.una.ac.cr',  'respuesta', 'hola, gracias, saludos.', 1),
		('georges.alfaro@eif209.una.ac.cr', 'carlos.mora@alla.lejos.com', 'solicitud', 'Favor enviar el documento.', 0)
	;
    
select * from usuario;
select * from correo;