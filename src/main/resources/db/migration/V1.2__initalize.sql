CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  task_name VARCHAR(64),
  points SMALLINT DEFAULT 1
);

CREATE TABLE days (
  id SERIAL PRIMARY KEY,
  day VARCHAR(16),
  minutes INT DEFAULT 30
);

CREATE TABLE task_day (
  task_id INT NOT NULL REFERENCES tasks (id),
  day_id INT NOT NULL REFERENCES days (id)
);

INSERT into tasks (task_name, points) VALUES
  ('Math', 1),
  ('ML', 2);

INSERT into days (day) VALUES
  ('MONDAY'),
  ('TUESDAY');


INSERT INTO task_day (task_id, day_id) VALUES
  (1, 2),
  (1, 1),
  (2, 1),
  (2, 2);