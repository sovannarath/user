
CREATE TYPE enum_gender AS ENUM('MALE', 'FEMALE');
CREATE TYPE enum_meeting_status AS ENUM('ON_HOLD', 'NEXT_SCHEDULE', 'FINISHED');

CREATE TABLE IF NOT EXISTS user_roles (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	description TEXT NULL, 
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

INSERT INTO user_roles (name, description)
VALUES
('DIRECTOR', 'Head of the department'),
('MANAGER', 'General managment of the department'),
('ADMINISTRATOR', 'Administration of the system.'),
('DATA_ENTRY', 'Entry data to any system as requirement.'),
('MEETING_RECORDER', 'Join and record meeting process.'),
('PROGRAMMER', 'Develop internal system.'),
('GUEST', 'For who that does not has any position');

CREATE TABLE IF NOT EXISTS organizations (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	description TEXT NULL,
	address TEXT NULL, 
	telephone VARCHAR (255) NULL,
	email VARCHAR(255) NULL, 
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL  
);

INSERT INTO organizations (name, description, address, telephone, email)
VALUES
('Zillennium', 'Real estate market place.', 'St 310, Boeung Kak II, Khan Toul Kok, Phnom Penh, Cambodia', '+855230000000', 'info@zillennium.com'),
('Century 21 Zillion Home', 'International real estate market place.', 'St 310, Beoung Kak II, Toul Kok, Phnom Penh, Cambodia', '+85523000000', 'info@zillionhome.com');

CREATE TABLE IF NOT EXISTS users (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	gender enum_gender,
	date_of_birth DATE NULL, 
	email VARCHAR(255) NULL,
	password TEXT, 
	remember_token TEXT NULL,
	api_token TEXT NULL,
	role_id BIGINT,
	organization_id BIGINT NULL,
	reference BIGINT NULL,
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);
ALTER TABLE users ADD CONSTRAINT users_role_id_foreign FOREIGN KEY (role_id) REFERENCES user_roles(id);
ALTER TABLE users ADD CONSTRAINT users_organization_id_foreign FOREIGN KEY (organization_id) REFERENCES organizations(id);
ALTER TABLE users ADD CONSTRAINT users_reference_foreign FOREIGN KEY (reference) REFERENCES organizations(id);

CREATE TABLE IF NOT EXISTS contact_types (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	description TEXT NULL,
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

INSERT INTO contact_types (name, description)
VALUES
('EMAIL', 'Email type of contact'),
('PHONE_NUMBER', 'Phne number type of contact'),
('ADDRESS', 'Address type of contact'),
('SOCIAL_MEDIA', 'Social media type of contact');

CREATE TABLE IF NOT EXISTS contact_providers (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255), 
	description TEXT NULL,
	logo_id BIGINT NULL,
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

INSERT INTO contact_providers (name, description)
VALUES
('GOOGLE', 'Google company g-mail service provider'),
('YAHOO', 'Yahoo! company mail service provider'), 
('SMART_MOBILE', 'Smart Mobile service provider'),
('CELLCARD', 'Cellcard mobile service provider'),
('METFONE', 'Metfone mobile service provider'),
('SEATEL', 'Sea-Tel mobile service provider');

CREATE TABLE IF NOT EXISTS user_contacts (
	id BIGSERIAL PRIMARY KEY,
	user_id BIGINT,
	type_id BIGINT,
	contact TEXT,
	provider_id BIGINT NULL,
	is_active SMALLINT DEFAULT 1,
	is_default SMALLINT DEFAULT 0,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

ALTER TABLE user_contacts ADD CONSTRAINT user_contacts_user_id_foreign FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE user_contacts ADD CONSTRAINT user_contacts_type_id_foreign FOREIGN KEY (type_id) REFERENCES contact_types(id);
ALTER TABLE user_contacts ADD CONSTRAINT user_contacts_provider_id_foreign FOREIGN KEY (provider_id) REFERENCES contact_providers(id);

CREATE TABLE IF NOT EXISTS project_types (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	description TEXT NULL, 
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
); 

INSERT INTO project_types (name, description) 
VALUES 
('SOFTWARE_PROJECT', 'Project that build software.'),
('CONSTRUCTION_PROJECT', 'Project for civil engineer contruction.'),
('RESEARCH_PROJECT', 'Research project'),
('DATA_COLLECTION_PROJECT', 'Data collection project');

CREATE TABLE IF NOT EXISTS projects(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255), 
	purpose TEXT NULL,
	description TEXT NULL,
	project_type BIGINT,
	organization_id BIGINT,
	manager_id BIGINT NULL,
	start_date DATE NULL,
	end_date DATE NULL,
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

ALTER TABLE projects ADD CONSTRAINT projects_project_type_foreign FOREIGN KEY (project_type) REFERENCES project_types(id);
ALTER TABLE projects ADD CONSTRAINT projects_organization_id_foreign FOREIGN KEY (organization_id) REFERENCES organizations(id);
ALTER TABLE projects ADD CONSTRAINT projects_manager_id_foreign FOREIGN KEY (manager_id) REFERENCES users(id);

CREATE TABLE IF NOT EXISTS meeting_types (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	description TEXT NULL,
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

INSERT INTO meeting_types (name, description)
VALUES
('DAILY_MEETING', 'Daily meeting'),
('WEEKLY_MEETING', 'Weekly meeting'),
('MONTHLY_MEETING', 'Monthly meeting'),
('MINUTE_MEETING', 'Minute Meeting');

CREATE TABLE IF NOT EXISTS meetings (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	project_id BIGINT,
	meeting_type BIGINT, 
	issue_number INT NULL,
	date DATE,
	start_time TIME NULL,
	end_time TIME NULL,
	location VARCHAR(255) NULL,
	objective TEXT,
	conclusion TEXT NULL,
	comment TEXT NULL,
	others TEXT NULL,
	status enum_meeting_status,
	next_schedule DATE NULL,
	next_schedule_topic VARCHAR(255) NULL,
	next_schedule_comment VARCHAR(255) NULL,
	recorder_id BIGINT,
	record_date DATE NULL,
	checker_id BIGINT NULL,
	check_date DATE NULL,
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

ALTER TABLE meetings ADD CONSTRAINT meetings_project_id_foreign FOREIGN KEY (project_id) REFERENCES meetings(id);
ALTER TABLE meetings ADD CONSTRAINT meetings_recorder_id_foreign FOREIGN KEY (recorder_id) REFERENCES users(id);
ALTER TABLE meetings ADD CONSTRAINT meetings_checker_id_foreign FOREIGN KEY (checker_id) REFERENCES users(id);
ALTER TABLE meetings ADD CONSTRAINT meetings_meeting_type_foreign FOREIGN KEY (meeting_type) REFERENCES meeting_types(id);

CREATE TABLE IF NOT EXISTS meeting_action_types (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255),
	description TEXT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

INSERT INTO meeting_action_types (name, description)
VALUES
('COMMENT', 'Give a comment in meeting.'),
('ASK_QUESTION', 'Ask a question in meeting.'),
('ANSWER_QUESTION', 'Answer a question in meeting.');

CREATE TABLE IF NOT EXISTS meeting_agendas (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	meeting_id BIGINT,
	description TEXT NULL,
	agenda_comment TEXT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);
ALTER TABLE meeting_agendas ADD CONSTRAINT meeting_agendas_meeting_id_foreign FOREIGN KEY (meeting_id) REFERENCES meetings(id);

CREATE TABLE IF NOT EXISTS meeting_discussion_logs (
	id BIGSERIAL PRIMARY KEY,
	meeting_id BIGINT,
	agenda_id BIGINT,
	user_id BIGINT,
	action_id BIGINT,
	description TEXT, 
	related_action BIGINT,
	note TEXT NULL,
	is_active SMALLINT DEFAULT 1,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

ALTER TABLE meeting_discussion_logs ADD CONSTRAINT meeting_discussion_logs_meeting_id_foreign FOREIGN KEY (meeting_id) REFERENCES meetings(id);
ALTER TABLE meeting_discussion_logs ADD CONSTRAINT meeting_discussion_logs_ageda_id_foreign FOREIGN KEY (agenda_id) REFERENCES meeting_agendas(id);
ALTER TABLE meeting_discussion_logs ADD CONSTRAINT meeting_discussion_logs_user_id_foreign FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE meeting_discussion_logs ADD CONSTRAINT meeting_discussion_logs_action_id_foreign FOREIGN KEY (action_id) REFERENCES meeting_action_types(id);
ALTER TABLE meeting_discussion_logs ADD CONSTRAINT meeting_discussion_logs_related_action_foreign FOREIGN KEY (related_action) REFERENCES meeting_discussion_logs(id);

CREATE TABLE IF NOT EXISTS meeting_participants (
	id BIGSERIAL PRIMARY KEY,
	user_id BIGINT,
	meeting_id BIGINT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

ALTER TABLE meeting_participants ADD CONSTRAINT meeting_participants_user_id_foreign FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE meeting_participants ADD CONSTRAINT meeting_participants_meeting_id_foreign FOREIGN KEY (meeting_id) REFERENCES meetings(id);

/* Table Meeting Attachment */
CREATE TABLE IF NOT EXISTS meeting_attachments (
	id BIGSERIAL PRIMARY KEY,
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
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);

/* Table Group participant */
CREATE TABLE IF NOT EXISTS meeting_group_users (
	id BIGSERIAL PRIMARY KEY,
	user_id BIGINT,
	meeting_group_id BIGINT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);
ALTER TABLE meeting_group_users ADD CONSTRAINT meeting_group_participant_user_id_foreign FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE meeting_group_users ADD CONSTRAINT meeting_group_participant_meeting_group_id_foreign FOREIGN KEY (meeting_group_id) REFERENCES meeting_participant_groups(id);



CREATE FUNCTION update_timestamp() RETURNS trigger AS $update_timestamp$
    BEGIN
        NEW.modified := current_timestamp;
        RETURN NEW;
    END;
$update_timestamp$ LANGUAGE plpgsql;

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON user_roles
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();
    
CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON organizations
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON users
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON contact_types
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON contact_providers
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON user_contacts
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON project_types
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON projects
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_types
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meetings
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_action_types
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();
    
CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_discussion_logs
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_participants
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();
    
CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_agendas
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

