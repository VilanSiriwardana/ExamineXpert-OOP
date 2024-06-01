SELECT * FROM examinexpert.student;
SELECT * FROM examinexpert.module;
SELECT * FROM examinexpert.paper;
SELECT * FROM examinexpert.question;
SELECT * FROM examinexpert.studentanswer;
SELECT * FROM examinexpert.teacher;
SELECT * FROM examinexpert.result;

CREATE DATABASE `examinexpert` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `module` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) DEFAULT NULL,
  `mdes` varchar(255) DEFAULT NULL,
  `mcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `paper` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `mid` int NOT NULL,
  `pname` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`,`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `question` (
  `pid` int NOT NULL,
  `mid` int NOT NULL,
  `qid` int NOT NULL,
  `question` varchar(255) NOT NULL,
  `tanswer` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`,`mid`,`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) NOT NULL,
  `semail` varchar(255) NOT NULL,
  `susername` varchar(255) NOT NULL,
  `spassword` varchar(255) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `studentanswer` (
  `pid` int NOT NULL,
  `mid` int NOT NULL,
  `qid` int NOT NULL,
  `sid` int NOT NULL,
  `sanswer` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`,`mid`,`qid`,`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `result` (
  `pid` int NOT NULL,
  `mid` int NOT NULL,
  `sid` int NOT NULL,
  `score` FLOAT(5, 1) NOT NULL,
  `grade` varchar(5) NOT NULL,
  PRIMARY KEY (`pid`,`mid`,`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `teacher` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(500) DEFAULT NULL,
  `temail` varchar(50) DEFAULT NULL,
  `tconno` varchar(10) DEFAULT NULL,
  `tusername` varchar(10) DEFAULT NULL,
  `tpassword` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO examinexpert.student VALUES(0, 'Duhilsha Vithanage', 'duhilshavithanage@gmail.com', 'duhivith', '7890');

INSERT INTO examinexpert.teacher VALUES(0, 'Vilan Siriwardana', 'vilansriwardana@gmail.com', 0703802284, 'vilansith', '1234');


INSERT INTO examinexpert.module (mid, mname, mdes, mcode)
VALUES
    (1, 'Calculus I', 'Introduction to differential and integral calculus.', 'MATH101'),
    (2, 'English Literature', 'Exploring classic and contemporary literature.', 'ENG101'),
    (3, 'Web Development Basics', 'Fundamentals of web development technologies.', 'IT101'),
    (4, 'Cell Biology', 'Study of cell structure and function.', 'BIO101'),
    (5, 'World History: Ancient Civilizations', 'Exploring ancient cultures and societies.', 'HIST101');



INSERT INTO examinexpert.paper (mid, pname) VALUES
(1, 'Paper 1'),
(1, 'Paper 2'),
(1, 'Paper 3'),
(2, 'Paper 4'),
(2, 'Paper 5'),
(2, 'Paper 6'),
(3, 'Paper 7'),
(3, 'Paper 8'),
(3, 'Paper 9'),
(4, 'Paper 10'),
(4, 'Paper 11'),
(4, 'Paper 12');



INSERT INTO examinexpert.question (pid, mid, qid, question, tanswer) VALUES
(1, 1, 1, 'Question 1 for Paper 1', 'Answer 1'),
(1, 1, 2, 'Question 2 for Paper 1', 'Answer 2'),
(1, 1, 3, 'Question 3 for Paper 1', 'Answer 3'),
(1, 1, 4, 'Question 4 for Paper 1', 'Answer 4'),
(1, 1, 5, 'Question 5 for Paper 1', 'Answer 5'),
(2, 2, 1, 'Question 1 for Paper 2', 'Answer 3'),
(2, 2, 2, 'Question 2 for Paper 2', 'Answer 6'),
(2, 2, 3, 'Question 3 for Paper 2', 'Answer 7'),
(2, 2, 4, 'Question 4 for Paper 2', 'Answer 3'),
(2, 2, 5, 'Question 5 for Paper 2', 'Answer 8'),
(3, 1, 1, 'Question 1 for Paper 3', 'Answer 1'),
(3, 1, 2, 'Question 2 for Paper 3', 'Answer 2'),
(3, 1, 3, 'Question 3 for Paper 3', 'Answer 3'),
(3, 1, 4, 'Question 4 for Paper 3', 'Answer 4'),
(3, 1, 5, 'Question 5 for Paper 3', 'Answer 5'),
(4, 2, 1, 'Question 1 for Paper 4', 'Answer 1'),
(4, 2, 2, 'Question 2 for Paper 4', 'Answer 2'),
(4, 2, 3, 'Question 3 for Paper 4', 'Answer 3'),
(4, 2, 4, 'Question 4 for Paper 4', 'Answer 4'),
(4, 2, 5, 'Question 5 for Paper 4', 'Answer 5'),
(5, 1, 1, 'Question 1 for Paper 5', 'Answer 2'),
(5, 1, 2, 'Question 2 for Paper 5', 'Answer 6'),
(5, 1, 3, 'Question 3 for Paper 5', 'Answer 7'),
(5, 1, 4, 'Question 4 for Paper 5', 'Answer 6'),
(5, 1, 5, 'Question 5 for Paper 5', 'Answer 3'),
(5, 1, 6, 'Question 6 for Paper 5', 'Answer 2');

