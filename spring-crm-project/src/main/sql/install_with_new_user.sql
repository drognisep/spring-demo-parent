-- This script will not only create the schema and table(s), but also create a new user to safely interact with it

-- Allow use of standard || concatenation
SET sql_mode := 'PIPES_AS_CONCAT';

-- Override these 3 variables to change the user's attributes
SET @new_user := 'training';
SET @new_user_host := 'localhost'; -- This should be the **CLIENT'S** IP
SET @new_user_pass := 'training';

-- Dynamic SQL statements, do not modify
SET @drop_user := 'DROP USER IF EXISTS `' || @new_user || '`@`' || @new_user_host || '`';
SET @create_user := 'CREATE USER `' || @new_user || '`@`' || @new_user_host || '` IDENTIFIED BY "' || @new_user_pass || '"';
SET @user_grants := 'GRANT SELECT,INSERT,UPDATE,DELETE ON `crm_project`.* TO `' || @new_user || '`@`' || @new_user_host || '`';

-- Drop user if exists
PREPARE stmt FROM @drop_user; EXECUTE stmt; DEALLOCATE PREPARE stmt;

\. install.sql

-- Create new user
PREPARE stmt FROM @create_user; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- Grant basic privileges to user
PREPARE stmt FROM @user_grants; EXECUTE stmt; DEALLOCATE PREPARE stmt;
