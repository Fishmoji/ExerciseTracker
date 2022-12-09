CREATE database exercisetracker;

CREATE TABLE tracker (
activityID INT NOT NULL AUTO_INCREMENT,
lastupdate DATETIME DEFAULT CURRENT_TIMESTAMP,
pointsGranted INT,
PRIMARY KEY (activityID)
);

SELECT * FROM tracker;