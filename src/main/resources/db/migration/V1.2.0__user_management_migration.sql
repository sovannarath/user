/* Table Meeting Attachment */
CREATE TABLE IF NOT EXISTS meeting_attachments (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	attachment_path VARCHAR(255) NOT NULL,
	domain_name VARCHAR(255) NOT NULL,
	agenda_id BIGINT NOT NULL,
	attachment_type VARCHAR(255) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);
ALTER TABLE meeting_attachments ADD CONSTRAINT meeting_attachments_agenda_id_foreign FOREIGN KEY (agenda_id) REFERENCES meeting_agendas(id);


/* Table Participant Group */
CREATE TABLE IF NOT EXISTS meeting_participant_groups (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);


/* Table Group participant */
CREATE TABLE IF NOT EXISTS meeting_group_users (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT,
	meeting_group_id BIGINT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);
ALTER TABLE meeting_group_users ADD CONSTRAINT meeting_group_participant_user_id_foreign FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE meeting_group_users ADD CONSTRAINT meeting_group_participant_meeting_group_id_foreign FOREIGN KEY (meeting_group_id) REFERENCES meeting_participant_groups(id);

ALTER TABLE meeting_discussion_logs ADD COLUMN agenda_id BIGINT AFTER meeting_id;
ALTER TABLE meeting_discussion_logs ADD CONSTRAINT meeting_discussion_logs_agenda_id_foreign FOREIGN KEY (agenda_id) REFERENCES meeting_agendas(id);

