# scheme "teamproject"



CREATE TABLE `teamproject`.`customer` (
  `id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NULL,
  `email` VARCHAR(30) NULL,
  `name` VARCHAR(10) NULL,
  `phone_number` VARCHAR(11) NOT NULL,
  `type` VARCHAR(5) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `teamproject`.`book` (
  `isbn` VARCHAR(13) NOT NULL,
  `title` VARCHAR(60) NULL,
  `author` VARCHAR(45) NOT NULL,
  `publisher` VARCHAR(45) NOT NULL,
  `is_borrow` INTEGER(10) NULL,
  `customer_id` VARCHAR(20) NULL,
  PRIMARY KEY (`isbn`),
  INDEX `book_fk_idx` (`customer_id` ASC),
  CONSTRAINT `book_fk`
    FOREIGN KEY (`customer_id`)
    REFERENCES `teamproject`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `teamproject`.`borrow` (
  `borrow_number` INT(10) NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(13) NULL,
  `title` VARCHAR(60) NULL,
  `customer_id` VARCHAR(20) NULL,
  `borrow_date` DATETIME NULL,
  `return_date` DATETIME NULL,
  `is_return` INT(10) NULL,
  PRIMARY KEY (`borrow_number`),
  INDEX `borrowFK_isbn_idx` (`isbn` ASC),
  INDEX `borrowFK_customer_id_idx` (`customer_id` ASC),
  CONSTRAINT `borrowFK_isbn`
    FOREIGN KEY (`isbn`) 
    REFERENCES `teamproject`.`book` (`isbn`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `borrowFK_customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `teamproject`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `teamproject`.`reservation` (
  `customer_id` VARCHAR(20) NOT NULL,
  `isbn` VARCHAR(13) NOT NULL,
  `reserv_date` DATETIME NULL,
  PRIMARY KEY (`customer_id`, `isbn`),
  INDEX `reservFK_isbn_idx` (`isbn` ASC),
  CONSTRAINT `reservFK_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `teamproject`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `reservFK_isbn`
    FOREIGN KEY (`isbn`)
    REFERENCES `teamproject`.`book` (`isbn`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
SET FOREIGN_KEY_CHECKS = 0;
alter table teamproject.book convert to charset utf8;
alter table teamproject.borrow convert to charset utf8;
alter table teamproject.customer convert to charset utf8;
alter table teamproject.reservation convert to charset utf8;
SET FOREIGN_KEY_CHECKS = 1;
