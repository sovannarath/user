CREATE TABLE IF NOT EXIST `user_roles` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`description` TEXT NULL, 
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO `user_roles` (`name`, `description`)
VALUES
('DIRECTOR', 'Head of the department'),
('MANAGER', 'General managment of the department'),
('ADMINISTRATOR', 'Administration of the system.'),
('DATA_ENTRY', 'Entry data to any system as requirement.'),
('MEETING_RECORDER', 'Join and record meeting process.'),
('PROGRAMMER', 'Develop internal system.')
('GUEST', 'For who that doesn\'t has any position');

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

INSERT INTO `organizations` (`name`, `description`, `address`, `telephone`, `email`)
VALUES
('Zillennium', 'Real estate market place.', 'St 310, Boeung Kak II, Khan Toul Kok, Phnom Penh, Cambodia', '+855230000000', 'info@zillennium.com'),
('Century 21 Zillion Home', 'International real estate market place.', 'St 310, Beoung Kak II, Toul Kok, Phnom Penh, Cambodia', '+85523000000', 'info@zillionhome.com');

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

ALTER TABLE `users` ADD CONSTRAINT users_role_id_foreign FOREIGN KEY (`role_id`) REFERENCES `users_role`(`id`);
ALTER TABLE `users` ADD CONSTRAINT users_organization_id_foreign FOREIGN KEY (`organization_id`) REFERENCES `organizations`(`id`);
ALTER TABLE `users` ADD CONSTRAINT users_reference_foreign FOREIGN KEY (`reference`) REFERENCES `organizations`(`id`);

CREATE TABLE IF NOT EXIST `project_types` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`description` TEXT NULL, 
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8; 

INSERT INTO `project_type` ('name', 'description')
VALUES
('SOFTWARE_PROJECT', 'Project that build software.'),
('CONSTRUCTION_PROJECT', 'Project for civil engineer contruction.'),
('RESEARCH_PROJECT', 'Research project'),
('DATA_COLLECTION_PROJECT', 'Data collection project');


CREATE TABLE IF NOT EXIST `contact_providers` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255), 
	`description` TEXT NULL,
	`logo_id` BIGINT NULL,
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO `contact_providers` (`name`, `description`)
VALUES 
('GOOGLE', 'Google company g-mail service provider'),
('YAHOO', 'Yahoo! company mail service provider'), 
('SMART_MOBILE', 'Smart Mobile service provider'),
('CELLCARD', 'Cellcard mobile service provider'),
('METFONE', 'Metfone mobile service provider'),
('SEATEL', 'Sea-Tel mobile service provider');

CREATE TABLE IF NOT EXIST `user_contacts` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`user_id` BIGINT,
	`type_id` BIGINT,
	`contact` TEXT,
	`provider_id` BIGINT NULL,
	`is_active` TINYINT DEFAULT 1,
	`is_default` TINYINT DEFAULT 0,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;

ALTER TABLE `user_contacts` ADD CONSTRAINT user_contacts_user_id_foreign FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);
ALTER TABLE `user_contacts` ADD CONSTRAINT user_contacts_type_id_foreign FOREIGN KEY (`type_id`) REFERENCES `contact_types`(`id`);
ALTER TABLE `user_contacts` ADD CONSTRAINT user_contacts_provider_id_foreign FOREIGN KEY (`provider_id`) REFERENCES `contact_providers`(`id`);

CREATE TABLE IF NOT EXISTS `projects`(
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255), 
	`purpose` TEXT NULL,
	`descriptions` TEXT NULL,
	`organization_id` BIGINT,
	`manager_id` BIGINT NULL,
	`start_date` DATE NULL,
	`end_date` DATE NULL,
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

ALTER TABLE `projects` ADD CONSTRAINT projects_organization_id_foreign FOREIGN KEY `organization_id` REFERENCES `organizations`(`id`);
ALTER TABLE `projects` ADD CONSTRAINT projects_manager_id_foreign FOREING KEY `manager_id` REFERENCES `users`(`id`);

CREATE TABLE IF NOT EXIST `meeting_types` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`description` TEXT NULL,
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;

INSERT INTO `meeting_types` ('name', 'description')
VALUES
('DAILY_MEETING', 'Daily meeting'),
('WEEKLY_MEETING', 'Weekly meeting'),
('MONTHLY_MEETING', 'Monthly meeting'),
('MINUTE_MEETING', 'Minute Meeting');

CREATE TABLE IF NOT EXIST `meetings` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`project_id` BIGINT,
	`issue_number` INT NULL,
	`date` DATE,
	`start_time` TIME NULL,
	`end_time` TIME NULL,
	`location` VARCHAR(255) NULL,
	`overview` TEXT NULL,
	`objective` TEXT,
	`problem` TEXT NULL,
	`opportunity` TEXT NULL,
	`discussion` TEXT NULL,
	`conclusion` TEXT NULL,
	`comment` TEXT NULL,
	`status` ENUM('ON_HOLD', 'NEXT_SCHEDULE', 'FINISHED'),
	`next_schedule` DATE NULL,
	`next_schedule_topic` VARCHAR(255) NULL,
	`next_schedule_comment` VARCHAR(255) NULL,
	`recorder_id` BIGINT,
	`record_date` DATE NULL,
	`checker_id` BIGINT​​ NULL,
	`check_date` DATE NULL,
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;

ALTER TABLE `meetings` ADD CONSTRAINT meetings_project_id_foreign FOREIGN KEY (`project_id`) REFERENCES `meetings`(`id`);
ALTER TABLE `meetings` ADD CONSTRAINT meetings_recorder_id_foreign FOREIGN KEY (`recorder_id`) REFERENCES `users`(`id`);
ALTER TABLE `meetings` ADD CONSTRAINT meetings_checker_id_foreign FOREIGN KEY (`checker_id`) REFERENCES `users`(`id`);

CREATE TABLE IF NOT EXIST `meeting_action_types` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255),
	`description` TEXT NULL,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;

INSERT INTO `meeting_action_types` ('name', 'description')
VALUES
('COMMENT', 'Give a comment in meeting.'),
('ASK_QUESTION', 'Ask a question in meeting.'),
('ANSWER_QUESTION', 'Answer a question in meeting.');

CREATE TABLE IF NOT EXIST `meeting_actions` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`meeting_id` BIGINT,
	`user_id` BIGINT,
	`action_id` BIGINT,
	`description` TEXT, 
	`note` TEXT NULL,
	`is_active` TINYINT DEFAULT 1,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;

ALTER TABLE `meeting_actions` ADD CONSTRAINT meeting_actions_meeting_id_foreign FOREIGN KEY (`meeting_id`) REFERENCES `meetings`(`id`); 
ALTER TABLE `meeting_actions` ADD CONSTRAINT meeting_actions_user_id_foreign FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);
ALTER TABLE `meeting_actions` ADD CONSTRAINT meeting_actions_action_id_foreign FOREIGN KEY (`action_id`) REFERENCES `meeting_action_types`(`id`);

CREATE TABLE IF NOT EXIST `meeting_participants` (
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`user_id` BIGINT,
	`meeting_id` BIGINT,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`deleted_at` TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT UTF8;

ALTER TABLE `meeting_participants` ADD CONSTRAINT meeting_participants_user_id_foreign FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);
ALTER TABLE `meeting_participants` ADD CONSTRAINT meeting_actions_meeting_id_foreign FOREIGN KEY (`meeting_id`) REFERENCES `meetings`(`id`);


