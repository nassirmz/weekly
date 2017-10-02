CREATE TABLE tasks (
  task_id SERIAL PRIMARY KEY,
  task_name VARCHAR(64),
  points SMALLINT DEFAULT 1
);

CREATE TABLE days (
  day_id SERIAL PRIMARY KEY,
  day VARCHAR(16),
  timer_set INT DEFAULT 30
);

CREATE TABLE task_day (
  task_id INT NOT NULL REFERENCES tasks (task_id),
  day_id INT NOT NULL REFERENCES days (day_id)
);

INSERT into tasks (task_name, points) VALUES
  ('Math'),
  ('ML', 2);

INSERT into days (day, timer_set) VALUES
  ('MONDAY'),
  ('TUESDAY');


INSERT INTO task_day (task_id, day_id) VALUES
  (1, 2),
  (1, 1),
  (2, 1),
  (2, 2);



