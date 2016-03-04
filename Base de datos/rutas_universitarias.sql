SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rutas_universitarias` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `rutas_universitarias` ;

-- -----------------------------------------------------
-- Table `rutas_universitarias`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_universitarias`.`roles` (
  `id_rol` INT NOT NULL AUTO_INCREMENT,
  `nombre_rol` VARCHAR(50) NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `rutas_universitarias`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_universitarias`.`personas` (
  `id_persona` BIGINT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(100) NULL,
  `apellidos` VARCHAR(100) NULL,
  `correo_electronico` VARCHAR(255) NULL,
  `direccion` VARCHAR(100) NULL,
  `telefono` INT(10) NULL,
  `roles_id_rol` INT NOT NULL,
  PRIMARY KEY (`id_persona`),
  INDEX `fk_personas_roles_idx` (`roles_id_rol` ASC),
  CONSTRAINT `fk_personas_roles`
    FOREIGN KEY (`roles_id_rol`)
    REFERENCES `rutas_universitarias`.`roles` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `rutas_universitarias`.`buses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_universitarias`.`buses` (
  `id_bus` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(20) NULL,
  `numero_placa` VARCHAR(7) NULL,
  `id_conductor` BIGINT NOT NULL,
  PRIMARY KEY (`id_bus`),
  INDEX `fk_buses_personas1_idx` (`id_conductor` ASC),
  CONSTRAINT `fk_buses_personas1`
    FOREIGN KEY (`id_conductor`)
    REFERENCES `rutas_universitarias`.`personas` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `rutas_universitarias`.`rutas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_universitarias`.`rutas` (
  `id_ruta` BIGINT NOT NULL AUTO_INCREMENT,
  `codigo_ruta` VARCHAR(10) NULL,
  `nombre_ruta` VARCHAR(20) NULL,
  `id_bus_responsable_ruta` INT NOT NULL,
  `cantidad_puestos` INT NULL,
  `puestos_disponibles` INT NULL,
  PRIMARY KEY (`id_ruta`),
  INDEX `fk_rutas_buses1_idx` (`id_bus_responsable_ruta` ASC),
  CONSTRAINT `fk_rutas_buses1`
    FOREIGN KEY (`id_bus_responsable_ruta`)
    REFERENCES `rutas_universitarias`.`buses` (`id_bus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `rutas_universitarias`.`apartado_puestos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_universitarias`.`apartado_puestos` (
  `id_apartado_puesto` INT NOT NULL AUTO_INCREMENT,
  `id_persona` BIGINT NOT NULL,
  `id_ruta` BIGINT NOT NULL,
  `cantidad_puestos_apartados` INT NULL,
  PRIMARY KEY (`id_apartado_puesto`),
  INDEX `fk_apartado_puestos_personas1_idx` (`id_persona` ASC),
  INDEX `fk_apartado_puestos_rutas1_idx` (`id_ruta` ASC),
  CONSTRAINT `fk_apartado_puestos_personas1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `rutas_universitarias`.`personas` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_apartado_puestos_rutas1`
    FOREIGN KEY (`id_ruta`)
    REFERENCES `rutas_universitarias`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
