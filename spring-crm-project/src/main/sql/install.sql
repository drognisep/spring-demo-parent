DROP SCHEMA IF EXISTS `crm_project`;

CREATE SCHEMA `crm_project`;

USE `crm_project`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) DEFAULT NULL,
	`last_name` VARCHAR(50) DEFAULT NULL,
	`email` VARCHAR(200) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

-- Pre-load with data
INSERT INTO `customers` VALUES 
	(1001, 'David', 'Adams', 'david@luv2code.com'),
    (1002, 'John', 'Doe', 'john@luv2code.com'),
    (1003, 'Ajay', 'Rao', 'ajay@luv2code.com'),
    (1004, 'Mary', 'Public', 'mary@luv2code.com'),
    (1005, 'Maxwell', 'Dixon', 'max@luv2code.com');

-- Ensure you have a user with sufficient grants to access this schema.

-- It's recommended to create a new user that can only access this schema, use the alternative script to accomplish this.
