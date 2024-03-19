DELETE FROM REPLY;
DELETE FROM BOARD;

DROP TABLE BOARD;

CREATE TABLE BOARD(
	IDX INT NOT NULL AUTO_INCREMENT,
	TITLE VARCHAR(100) NOT NULL,
	CONTENT VARCHAR(2000) NOT NULL,
	WRITER VARCHAR(30) NOT NULL,
	INDATE DATETIME DEFAULT NOW(),
	COUNT INT DEFAULT 0,
	IMGPATH VARCHAR(200),
	PRIMARY KEY (IDX)
);

INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('봄이 좋냐', '추운데 뭔 소리임', '10CM');
INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('여름은', '싫음', 'KIM');
INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('가을은', '가을이 귀엽긴 해', '왜이래');
INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('겨울은', '눈이 와', '눈사람');
INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('사실 계절 2개임', '여어름겨어울', '가을돌려줘');


SELECT * FROM BOARD;

CREATE TABLE REPLY
  ( 
  IDX INT NOT NULL AUTO_INCREMENT,
  BOARDNUM INT NOT NULL,
  CONTENT VARCHAR(500) NOT NULL,
  WRITER VARCHAR(30) NOT NULL,
  INDATE DATETIME DEFAULT NOW(),
  PRIMARY KEY (IDX)
  );
  
  DROP TABLE REPLY;
  
  SELECT * FROM REPLY;
  
  CREATE TABLE MEMBER(
  	ID VARCHAR(100) NOT NULL,
  	PW VARCHAR(100) NOT NULL,
  	NICK VARCHAR(100) NOT NULL,
  	PRIMARY KEY (ID)
  );
  
  DELETE FROM MEMBER;
  
  SELECT * FROM MEMBER;
  
  DROP TABLE MEMBER;