
-- =========================================================
-- quiz.sql
-- Quiz Database for Cognizant DN 5.0 Hands-on 3
-- Schema: ormlearn
-- =========================================================

USE ormlearn;

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS attempt_option;
DROP TABLE IF EXISTS attempt_question;
DROP TABLE IF EXISTS attempt;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS `user`;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `user`(
  us_id INT PRIMARY KEY AUTO_INCREMENT,
  us_name VARCHAR(45) NOT NULL,
  us_email VARCHAR(45) NOT NULL
);

CREATE TABLE question(
  qt_id INT PRIMARY KEY AUTO_INCREMENT,
  qt_text VARCHAR(150) NOT NULL
);

CREATE TABLE options(
  op_id INT PRIMARY KEY AUTO_INCREMENT,
  op_qt_id INT NOT NULL,
  op_score DOUBLE NOT NULL,
  op_text VARCHAR(100) NOT NULL,
  CONSTRAINT fk_option_question
    FOREIGN KEY(op_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt(
  at_id INT PRIMARY KEY AUTO_INCREMENT,
  at_date DATE NOT NULL,
  at_us_id INT NOT NULL,
  at_score DOUBLE,
  CONSTRAINT fk_attempt_user
    FOREIGN KEY(at_us_id) REFERENCES `user`(us_id)
);

CREATE TABLE attempt_question(
  aq_id INT PRIMARY KEY AUTO_INCREMENT,
  aq_at_id INT NOT NULL,
  aq_qt_id INT NOT NULL,
  CONSTRAINT fk_aq_attempt
    FOREIGN KEY(aq_at_id) REFERENCES attempt(at_id),
  CONSTRAINT fk_aq_question
    FOREIGN KEY(aq_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt_option(
  ao_id INT PRIMARY KEY AUTO_INCREMENT,
  ao_op_id INT NOT NULL,
  ao_aq_id INT NOT NULL,
  ao_selected BIT NOT NULL,
  CONSTRAINT fk_ao_option
    FOREIGN KEY(ao_op_id) REFERENCES options(op_id),
  CONSTRAINT fk_ao_aq
    FOREIGN KEY(ao_aq_id) REFERENCES attempt_question(aq_id)
);

INSERT INTO `user`(us_name,us_email) VALUES
('Pratyush Kumar Mohanty','pratyushmohanty12345@gmail.com'),
('Alice','alice@gmail.com'),
('Bob','bob@gmail.com'),
('Charlie','charlie@gmail.com'),
('David','david@gmail.com'),
('Emma','emma@gmail.com'),
('Frank','frank@gmail.com'),
('Grace','grace@gmail.com'),
('Henry','henry@gmail.com'),
('Isabella','isabella@gmail.com');

INSERT INTO question(qt_text) VALUES
('What is the extension of the hyper text markup language file?'),
('What is the maximum level of heading tag can be used in a HTML page?'),
('The HTML document itself begins with <html> and ends </html>. State True or False'),
('Choose the right option to store text value in a variable'),
('Which HTML tag is used to insert an image?'),
('Which CSS property changes text color?'),
('Which keyword creates an object in Java?'),
('Which collection does not allow duplicates?'),
('Which SQL statement retrieves records?'),
('Spring Boot annotation used to mark the main application class?');

INSERT INTO options(op_qt_id,op_score,op_text) VALUES
(1,0,'.xhtm'),(1,0,'.ht'),(1,1,'.html'),(1,0,'.htmx'),
(2,0,'5'),(2,0,'3'),(2,0,'4'),(2,1,'6'),
(3,0,'False'),(3,1,'True'),
(4,0.5,"'John'"),(4,0,'John'),(4,0.5,'"John"'),(4,0,'/John/'),
(5,1,'<img>'),(5,0,'<image>'),(5,0,'<picture>'),(5,0,'<src>'),
(6,1,'color'),(6,0,'font-color'),(6,0,'text-color'),(6,0,'foreground'),
(7,1,'new'),(7,0,'create'),(7,0,'object'),(7,0,'make'),
(8,1,'Set'),(8,0,'List'),(8,0,'ArrayList'),(8,0,'Vector'),
(9,1,'SELECT'),(9,0,'UPDATE'),(9,0,'DELETE'),(9,0,'ALTER'),
(10,1,'@SpringBootApplication'),(10,0,'@Component'),(10,0,'@Configuration'),(10,0,'@EnableAutoConfiguration');

INSERT INTO attempt(at_date,at_us_id,at_score) VALUES
('2026-07-01',1,8.5),
('2026-07-02',2,7.0),
('2026-07-03',3,9.5),
('2026-07-04',1,10.0),
('2026-07-05',4,6.5);

-- Attempt 1 (user 1)
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,1);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,2);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,3);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,4);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,5);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,6);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,7);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,8);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,9);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (1,10);
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (1,1,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (2,1,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (3,1,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (4,1,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (5,2,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (6,2,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (7,2,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (8,2,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (9,3,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (10,3,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (11,4,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (12,4,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (13,4,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (14,4,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (15,5,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (16,5,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (17,5,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (18,5,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (19,6,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (20,6,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (21,6,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (22,6,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (23,7,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (24,7,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (25,7,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (26,7,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (27,8,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (28,8,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (29,8,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (30,8,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (31,9,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (32,9,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (33,9,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (34,9,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (35,10,b'1');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (36,10,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (37,10,b'0');
INSERT INTO attempt_option(ao_op_id,ao_aq_id,ao_selected) VALUES (38,10,b'0');

-- Additional attempt/question mappings
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,1);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,2);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,3);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,4);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,5);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,6);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,7);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,8);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,9);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (2,10);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,1);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,2);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,3);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,4);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,5);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,6);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,7);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,8);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,9);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (3,10);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,1);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,2);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,3);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,4);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,5);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,6);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,7);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,8);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,9);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (4,10);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,1);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,2);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,3);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,4);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,5);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,6);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,7);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,8);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,9);
INSERT INTO attempt_question(aq_at_id,aq_qt_id) VALUES (5,10);
