CREATE TABLE users (
    userID int NOT NULL AUTO_INCREMENT,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(12) NOT NULL,
    username VARCHAR(50),
    haircolour VARCHAR(50),
    skincolour VARCHAR(50),
    eyecolour VARCHAR(50),
    physique VARCHAR(70),
    PRIMARY KEY (userID)
    );
    
    CREATE TABLE XPtracker (
    userID INT NOT NULL AUTO_INCREMENT,
    lastupdate TIMESTAMP,
    score INT,
    FOREIGN KEY (userID) REFERENCES users(userID)
    );
    
    CREATE TABLE exercises (
    exerciseID INT NOT NULL AUTO_INCREMENT,
    exercisename VARCHAR(250) NOT NULL,
    easyrep INT,
    mediumrep INT,
    hardrep INT,
    PRIMARY KEY (exerciseID)
    );
    
    SELECT * FROM exercises;
    
    INSERT INTO exercises(exercisename, easyrep, mediumrep, hardrep) VALUES ('push-up', 5, 15, 25);