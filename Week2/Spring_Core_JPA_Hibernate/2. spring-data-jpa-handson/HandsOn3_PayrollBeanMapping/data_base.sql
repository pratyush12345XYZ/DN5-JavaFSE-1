CREATE TABLE department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(45)
);
CREATE TABLE employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(45),
    em_salary DECIMAL(10,2),
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);
CREATE TABLE skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(45)
);
CREATE TABLE employee_skill (
    es_id INT AUTO_INCREMENT PRIMARY KEY,
    es_em_id INT,
    es_sk_id INT,
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);
INSERT INTO department(dp_name)
VALUES
('HR'),
('IT'),
('Finance');
INSERT INTO skill(sk_name)
VALUES
('Java'),
('Spring Boot'),
('SQL'),
('Python');
INSERT INTO employee
(em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES
('Pratyush',50000,true,'2004-01-10',2),
('Rahul',42000,true,'2003-08-15',1),
('Ananya',65000,false,'2002-11-20',3);
INSERT INTO employee_skill
(es_em_id, es_sk_id)
VALUES
(1,1),
(1,2),
(1,3),
(2,3),
(2,4),
(3,1),
(3,4);