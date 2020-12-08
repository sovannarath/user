CREATE TABLE IF NOT EXIST `organizations` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`description` TEXT NULL,
	`address` TEXT NULL, 
	`telephone` VARCHAR (255) NULL,
	`email` VARCHAR(255) NULL, 
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL  
) ENGINE=InnoDB DEFAULT UTF8;
