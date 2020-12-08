CREATE TABLE IF NOT EXIST `user_involved_meeting` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`user_id` BIGINT,
	`meeting_id` BIGINT,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;
