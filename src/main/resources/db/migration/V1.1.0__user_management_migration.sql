/* Adding New and Rename Table */

/* Project Task Table */
CREATE TABLE IF NOT EXISTS project_tasks (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	project_id BIGINT,
	description TEXT NULL,
	comment TEXT NULL,
	start_date DATE NULL,
	end_date DATE NULL,
	user_ids TEXT NULL,
	department_ids TEXT NULL,
	status ENUM('INITIATE', 'CONTINUE', 'ON_HOLD', 'FINISHED'),
	total_sub_tasks INT NULL,
	completed_sub_tasks INT NULL,
	completed_percentage INT NULL,
	parent_id BIGINT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
ALTER TABLE project_tasks ADD CONSTRAINT project_tasks_parent_id_foreign FOREIGN KEY (parent_id) REFERENCES project_tasks(id);
ALTER TABLE project_tasks ADD CONSTRAINT project_tasks_project_id_foreign FOREIGN KEY (project_id) REFERENCES projects(id);


/* Meeting Project Task Logs Table */
CREATE TABLE IF NOT EXISTS meeting_task_logs (
	id BIGSERIAL PRIMARY KEY,
	meeting_id BIGINT,
	project_id BIGINT,
	department_ids TEXT NULL,
	task_id BIGINT,
	parent_id BIGINT,
	user_ids TEXT NULL,
	description TEXT NULL,
	start_date DATE,
	end_date DATE,
	total_works INT NULL,
	completed_works INT NULL,
	completed_percentage INT NULL,
	status ENUM('INITIATE', 'CONTINUE', 'ON_HOLD', 'FINISHED'),
	comment TEXT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
ALTER TABLE meeting_task_logs ADD CONSTRAINT meeting_task_logs_meeting_id_foreign FOREIGN KEY (meeting_id) REFERENCES meetings(id);
ALTER TABLE meeting_task_logs ADD CONSTRAINT meeting_task_logs_project_id_foreign FOREIGN KEY (project_id) REFERENCES projects(id);
ALTER TABLE meeting_task_logs ADD CONSTRAINT meeting_task_logs_task_id_foreign FOREIGN KEY (task_id) REFERENCES project_tasks(id);
ALTER TABLE meeting_task_logs ADD CONSTRAINT meeting_task_logs_parent_id_foreign FOREIGN KEY (parent_id) REFERENCES project_tasks(id);


/* Alter Table */
/* Drop unescessary column form meetings table*/
ALTER TABLE meetings DROP opportunity;
ALTER TABLE meetings DROP overview;
ALTER TABLE meetings DROP problem;
ALTER TABLE meetings DROP discussion;


/* Adding 'others' feild to table meetings */ 
ALTER TABLE meetings ADD others TEXT NULL;


/* Rename table meeting_actions to meeting_discussion_logs */
ALTER TABLE meeting_actions RENAME TO meeting_discussion_logs;


CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON project_tasks
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_task_logs
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

