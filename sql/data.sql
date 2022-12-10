CREATE database exercisetracker;

CREATE TABLE tracker (
activityID INT NOT NULL AUTO_INCREMENT,
lastupdate DATETIME DEFAULT CURRENT_TIMESTAMP,
pointsGranted INT,
PRIMARY KEY (activityID)
);

SELECT * FROM tracker;
CREATE DATABASE IF NOT EXISTS exercisetracker;

CREATE TABLE goals (
goalID INT NOT NULL AUTO_INCREMENT,
pointthreshold INT NOT NULL,
goalstatement VARCHAR(150),
PRIMARY KEY(goalID) 
);

INSERT INTO goals (pointthreshold, goalstatement) VALUES (500, 'take a rest day');
INSERT INTO goals (pointthreshold, goalstatement) VALUES (1000, 'have a cheat meal');
INSERT INTO goals (pointthreshold, goalstatement) VALUES (2000, 'buy new work-out gear');
INSERT INTO goals (pointthreshold, goalstatement) VALUES (3000, 'purchase gym membership');

SELECT * FROM goals;
