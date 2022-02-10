DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               first_name VARCHAR(250) NOT NULL,
                               last_name VARCHAR(250) NOT NULL,
                               email VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS MESSAGES;

CREATE TABLE MESSAGES (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               body TEXT NOT NULL,
                               userId INT,
                               FOREIGN KEY (userId) REFERENCES MESSAGES(userId),
);
