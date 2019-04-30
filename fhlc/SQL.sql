-- MySQL Workbench Synchronization
-- Generated: 2019-04-30 12:23
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Retiro - 02

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `erp_tv`.`programa_item` 
DROP FOREIGN KEY `fk_programa_item_item`;

ALTER TABLE `erp_tv`.`item` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `saida` `saida` TIMESTAMP NOT NULL ;

ALTER TABLE `erp_tv`.`programa_item` 
ADD INDEX `fk_programa_item_programa_idx` (`id_programa` ASC),
ADD INDEX `fk_programa_item_item1_idx` (`id_item` ASC),
DROP INDEX `fk_programa_item_item` ,
DROP INDEX `fk_programa_item_programa` ;
;

ALTER TABLE `erp_tv`.`programa_item` 
DROP FOREIGN KEY `fk_programa_item_programa`;

ALTER TABLE `erp_tv`.`programa_item` ADD CONSTRAINT `fk_programa_item_programa`
  FOREIGN KEY (`id_programa`)
  REFERENCES `erp_tv`.`programa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_programa_item_item`
  FOREIGN KEY (`id_item`)
  REFERENCES `erp_tv`.`item` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
