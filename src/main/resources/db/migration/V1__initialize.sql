CREATE TABLE tasks (
  id SERIAL PRIMARY KEY,
  task_name VARCHAR(64),
  points SMALLINT DEFAULT 1,
  finished_points SMALLINT DEFAULT 0,
  day VARCHAR(16)
);

CREATE TABLE timer (
  id SERIAL PRIMARY KEY,
  work_time INT DEFAULT 30,
  break_time INT DEFAULT 15
);



