CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';
CREATE DATABASE user_service;
GRANT ALL ON user_service.* TO 'admin'@'%';
FLUSH PRIVILEGES;

CREATE SCHEMA app;

CREATE TABLE app.users (
	id mediumint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	dt_create timestamp NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	patronymic VARCHAR(40) NOT NULL,
	email VARCHAR(50) NOT NULL,
	role ENUM('ADMINISTRATOR', 'SALE_USER', 'CUSTOMER_USER', 'SECURE_API_USER') NOT NULL
);