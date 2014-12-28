
CREATE DATABASE test;

USE test;

CREATE TABLE todoitem(task_id int not null auto_increment, task_title varchar(50), task_status bool default false, primary key(task_id));

INSERT INTO todoitem values(1,'Make breakfast', true);
INSERT INTO todoitem values(2,'Go to the central shopping mall', true);
INSERT INTO todoitem values(3,'Buy milk and sugar', false);
INSERT INTO todoitem values(4,'Make cookies', true);
INSERT INTO todoitem values(5,'Buy tickets', false);
INSERT INTO todoitem values(6,'Eat vitamins', false);

SELECT * FROM todoitem;

