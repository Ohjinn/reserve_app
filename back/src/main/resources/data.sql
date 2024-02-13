-- Schema reserve_mysql

CREATE SCHEMA IF NOT EXISTS reserve_mysql DEFAULT CHARACTER SET utf8 ;
USE reserve_mysql ;

-- Table reserve_mysql.user

CREATE TABLE IF NOT EXISTS reserve_mysql.user (
    user_id VARCHAR(45) NOT NULL,
    user_name VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(10) NOT NULL,
    created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
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
    user_id VARCHAR(45) NOT NULL,
    reservation_datetime DATETIME NULL,
    chair_id INT NULL,
    created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    location_id INT NULL,
    PRIMARY KEY (reservation_id),
    INDEX user_id_idx (user_id ASC) VISIBLE,
    INDEX chair_id_idx (chair_id ASC) VISIBLE,
    INDEX location_id_res_idx (location_id ASC) VISIBLE,
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
    CONSTRAINT location_id_res
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
    user_id VARCHAR(45) NOT NULL,
    PRIMARY KEY user_id(user_id))
    ENGINE = InnoDB;


DELETE FROM time_slot;
INSERT INTO time_slot (times) VALUES ('09:00:00'), ('09:20:00'), ('09:40:00'), ('10:00:00'), ('10:20:00'), ('10:40:00'), ('11:00:00'), ('11:20:00'), ('11:40:00'), ('12:00:00'), ('12:20:00'), ('12:40:00'), ('13:00:00'), ('13:20:00'), ('13:40:00'), ('14:00:00'), ('14:20:00'), ('14:40:00'), ('15:00:00'), ('15:20:00'), ('15:40:00'), ('16:00:00'), ('16:20:00'), ('16:40:00'), ('17:00:00'), ('17:20:00'), ('17:40:00');

-- location 값이 없으면 넣기
INSERT INTO location (location_name)
SELECT '방배 3층 남자휴게실'
FROM dual
WHERE (SELECT COUNT(*) FROM location) = 0;

-- chair 값이 없으면 넣기
INSERT INTO chair (chair_name, location_id)
SELECT * FROM (
                  SELECT '1' AS chair_name, '1' AS location_id UNION ALL
                  SELECT '2', '1' UNION ALL
                  SELECT '3', '1' UNION ALL
                  SELECT '4', '1' UNION ALL
                  SELECT '5', '1'
              ) AS tmp
WHERE NOT EXISTS (SELECT * FROM chair);