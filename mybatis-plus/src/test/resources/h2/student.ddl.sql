CREATE TABLE IF NOT EXISTS  h2student (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NULL DEFAULT NULL ,
	grade INT(3) NULL,
	gender VARCHAR(10) NULL,
	age INT(11) NULL DEFAULT NULL ,
	PRIMARY KEY (id)
);

