/* Adding New and Rename Table */

/* Project Task Table */
CREATE TABLE IF NOT EXISTS meeting_agendas (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	project_id BIGINT,
	description TEXT NULL,
	agenda_comment TEXT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	deleted_at TIMESTAMP NULL
);
ALTER TABLE meeting_agendas ADD CONSTRAINT project_tasks_project_id_foreign FOREIGN KEY (project_id) REFERENCES projects(id);

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


CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_agendas
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();

/*CREATE TRIGGER update_timestamp BEFORE INSERT OR UPDATE ON meeting_task_logs
    FOR EACH ROW EXECUTE PROCEDURE update_timestamp();*/

