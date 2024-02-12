-- Schema reserve_mysql

CREATE SCHEMA IF NOT EXISTS reserve_mysql DEFAULT CHARACTER SET utf8 ;
USE reserve_mysql ;

-- Table reserve_mysql.user

CREATE TABLE IF NOT EXISTS reserve_mysql.user (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(45) NOT NULL,
    created_at VARCHAR(45) NULL,
    PRIMARY KEY (user_id))
    ENGINE = InnoDB;

-- Table reserve_mysql.location

CREATE TABLE IF NOT EXISTS reserve_mysql.location (
    location_id INT NOT NULL AUTO_INCREMENT,
    location_name VARCHAR(45) NULL,
    PRIMARY KEY (location_id))
    ENGINE = InnoDB;

-- Table reserve_mysql.chair

CREATE TABLE IF NOT EXISTS reserve_mysql.chair (
    chair_id INT NOT NULL AUTO_INCREMENT,
    chair_name VARCHAR(45) NOT NULL,
    status VARCHAR(45) NULL,
    location_id INT NULL,
    PRIMARY KEY (chair_id),
    INDEX location_id_idx (location_id ASC) VISIBLE,
    CONSTRAINT location_id
    FOREIGN KEY (location_id)
    REFERENCES reserve_mysql.location (location_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

-- Table reserve_mysql.reservation

CREATE TABLE IF NOT EXISTS reserve_mysql.reservation (
    reservation_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NULL,
    reservation_datetime DATETIME NULL,
    chair_id INT NULL,
    createad_at DATETIME NULL,
    location_id INT NULL,
    PRIMARY KEY (reservationId),
    INDEX user_id_idx (user_id ASC) VISIBLE,
    INDEX chair_id_idx (chair_id ASC) VISIBLE,
    INDEX location_id_idx (location_id ASC) VISIBLE,
    CONSTRAINT user_id
    FOREIGN KEY (user_id)
    REFERENCES reserve_mysql.user (user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT chair_id
    FOREIGN KEY (chair_id)
    REFERENCES reserve_mysql.chair (chair_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT location_id
    FOREIGN KEY (location_id)
    REFERENCES reserve_mysql.location (location_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS reserve_mysql.time_slot (
    time_slot_id INT NOT NULL AUTO_INCREMENT,
    times TIME,
    PRIMARY KEY (time_slot_id))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS reserve_mysql.access_token (
    token VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY token(token))
    ENGINE = InnoDB;


DELETE FROM time_slot;
INSERT INTO time_slot (times) VALUES ('09:00:00'), ('09:20:00'), ('09:40:00'), ('10:00:00'), ('10:20:00'), ('10:40:00'), ('11:00:00'), ('11:20:00'), ('11:40:00'), ('12:00:00'), ('12:20:00'), ('12:40:00'), ('13:00:00'), ('13:20:00'), ('13:40:00'), ('14:00:00'), ('14:20:00'), ('14:40:00'), ('15:00:00'), ('15:20:00'), ('15:40:00'), ('16:00:00'), ('16:20:00'), ('16:40:00'), ('17:00:00'), ('17:20:00'), ('17:40:00');