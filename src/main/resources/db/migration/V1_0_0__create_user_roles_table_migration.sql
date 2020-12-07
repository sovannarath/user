CREATE TABLE IF NOT EXIST `user_roles` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`description` TEXT NULL, 
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

