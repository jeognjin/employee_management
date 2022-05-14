/* 직원 */
CREATE TABLE employee (
	emp_no INT NOT NULL, /* 사원번호 */
	name VARCHAR2(20) NOT NULL, /* 이름 */
	department_no INT, /* 부서번호 */
	department_name VARCHAR2(50), /* 부서명 */
	position VARCHAR2(20), /* 직급 */
	salary INT /* 급여 */
);

CREATE UNIQUE INDEX PK_employee
	ON employee (
		emp_no ASC
	);

ALTER TABLE employee
	ADD
		CONSTRAINT PK_employee
		PRIMARY KEY (
			emp_no
		);

/* 관리자 */
CREATE TABLE manager (
	manager_id VARCHAR2(20) NOT NULL, /* 관리자ID */
	manager_password VARCHAR2(20) NOT NULL, /* 관리자비밀번호 */
	manager_name VARCHAR2(20) NOT NULL /* 관리자 이름 */
);

CREATE UNIQUE INDEX PK_manager
	ON manager (
		manager_id ASC
	);

ALTER TABLE manager
	ADD
		CONSTRAINT PK_manager
		PRIMARY KEY (
			manager_id
		);
        
        
select * from employee;
select * from manager;

insert into employee values(1, 'tom', 10, '마케팅', '사원', 2800); 
insert into employee values(2, 'sam', 10, '마케팅', '과장', 5000); 
insert into employee values(3, 'mem', 10, '마케팅', '차장', 7000); 
insert into employee values(4, 'jane', 20, '품질관리', '인턴', 2500); 
insert into employee values(5, 'tim', 20, '품질관리', '대리', 3400); 
insert into employee values(6, 'then', 20, '품질관리', '사원', 2800); 
insert into employee values(7, 'jim', 30, '디자인', '사원', 2800); 
insert into employee values(8, 'kim', 30, '디자인', '부장', 6000); 
insert into employee values(9, 'emily', 40, '설계', '인턴', 2500); 
insert into employee values(10, 'sally', 40, '설계', '과장', 5000); 

insert into manager values('master', 'master', 'master');

update manager set manager_name = '마스터';





