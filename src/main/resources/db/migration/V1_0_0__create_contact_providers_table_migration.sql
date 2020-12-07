CREATE TABLE IF NOT EXIST `contact_providers` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`description` TEXT NULL,
	`logo_id` BIGINT NULL,
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;