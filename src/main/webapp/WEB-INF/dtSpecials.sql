DROP TABLE SPECIALS;
DROP TABLE BUSSPROFILES;
DROP TABLE USERPROFILES;
DROP TABLE SUBSCRIPTIONS;
DROP TABLE REVIEWS;
DROP TABLE RATINGS;
DROP TABLE USERS;
DROP TABLE BUSINESSES;
DROP TABLE ADMINS;


CREATE TABLE BUSINESSES (
username VARCHAR(10) NOT NULL UNIQUE,
password VARCHAR(15) NOT NULL,
email VARCHAR(100) NOT NULL,
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY
);

CREATE TABLE BUSSPROFILES (
bname VARCHAR(100) NOT NULL,
btype VARCHAR(11) NOT NULL,
description VARCHAR(1000),
phone VARCHAR(50) NOT NULL,
street VARCHAR(50) NOT NULL,
city VARCHAR(100) NOT NULL,
bstate VARCHAR(20) NOT NULL,
zip VARCHAR(9) NOT NULL,
website VARCHAR(100),
picture BLOB(200k),
pictype VARCHAR(30),
buss_Id INT REFERENCES BUSINESSES (id) NOT NULL,
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY
);

CREATE TABLE USERS (
email VARCHAR(50) NOT NULL,
username VARCHAR(10) NOT NULL UNIQUE,
password VARCHAR(10) NOT NULL,
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY
);

CREATE TABLE USERPROFILES (
fname VARCHAR(50),
lname VARCHAR(50),
phone VARCHAR(12),
picture BLOB(200k),
pictype VARCHAR(30),
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
user_Id INT REFERENCES USERS (id) NOT NULL
);

CREATE TABLE SPECIALS (
sname VARCHAR(50),
sdate DATE NOT NULL,
stime TIMESTAMP NOT NULL,
stime2 TIMESTAMP NOT NULL,
stype VARCHAR(50) NOT NULL,
description VARCHAR(500) NOT NULL,
buss_Id INT REFERENCES BUSINESSES (id) NOT NULL,
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY
);

CREATE TABLE REVIEWS (
id int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
post VARCHAR(1000) NOT NULL,
rdate TIMESTAMP NOT NULL,
user_Id INT REFERENCES USERS (id) NOT NULL,
buss_Id INT REFERENCES BUSINESSES (id) NOT NULL
);

CREATE TABLE RATINGS (
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
rating VARCHAR(2) NOT NULL,
user_Id INT REFERENCES USERS (id) NOT NULL,
buss_Id INT REFERENCES BUSINESSES (id) NOT NULL
);


CREATE TABLE SUBSCRIPTIONS (
id int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
user_Id INT REFERENCES USERS (id) NOT NULL,
buss_Id INT REFERENCES BUSINESSES (id) NOT NULL
);

CREATE TABLE ADMINS (
id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL
);

INSERT INTO ADMINS (username,password) VALUES
    ('admin','admin');

INSERT INTO USERS (username, password, email) VALUES
    ('58lalo53','lalo53', 'lpz_lalo@yahoo.com');

INSERT INTO BUSINESSES (username,password,email) VALUES
    ('elopez','Ea#030715','lpz_lalo@yahoo.com');