CREATE TABLE IF NOT EXIST `users` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`gender` ENUM('Male', 'Female'),
	`date_of_birth` DATE NULL, 
	`email` VARCHAR(255) NULL,
	`password` TEXT, 
	`remember_token` TEXT NULL,
	`api_token` TEXT NULL,
	`role_id` BIGINT,
	`organization_id` BIGINT NULL,
	`reference` BIGINT NULL,
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;

