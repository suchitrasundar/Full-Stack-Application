Create table BankEmployee
(
EmpId Varchar2(10) Primary key,
EmpPassword Varchar2(20),
EmpName varchar(20),
EmpType Varchar(10)CHECK(EmpType= 'Executive' or EmpType='Cashier'or EmpType='Teller')
);
commit;

drop table Bankemployee;

Insert into BankEmployee values ('1','Pankti@123','Pankti','Executive');
Insert into BankEmployee values('2','Jinal@123','Jinal','Executive');
Insert into BankEmployee values ('3','Suchitra@123','Suchitra','Executive');
Insert into BankEmployee values ('4','Nikitha@123','Nikitha','Executive');
Insert into BankEmployee values ('5','Nisarg@123','Nisarg','Teller');
Insert into BankEmployee values ('6','Manohar@123','Manohar','Cashier');
Insert into BankEmployee values('7','Sathvik@123','Sathvik','Teller');
Insert into BankEmployee values ('8','Sourab@123','Sourab','Cashier');
Insert into BankEmployee values ('executive','Qwerty12345','Morgan','Executive');
Insert into BankEmployee values ('cashier','Qwerty12345','James','Cashier');


CREATE TABLE ACCOUNT
(
CUSTOMER_ID NUMBER(10,0) REFERENCES CUSTOMER_DETAILS(CUSTOMER_ID),
ACCOUNT_ID NUMBER(10,0) NOT NULL PRIMARY KEY,
DEPOSIT_AMT NUMBER NOT NULL,
ACCOUNT_TYPE VARCHAR(20) CHECK (ACCOUNT_TYPE = 'Current' OR ACCOUNT_TYPE = 'Savings'),
ACCOUNT_STATUS VARCHAR(20) CHECK (ACCOUNT_STATUS = 'Pending' OR ACCOUNT_STATUS = 'Active' OR ACCOUNT_STATUS = 'Inactive'),
MESSAGE VARCHAR(60),
LAST_UPDATED varchar(20)
);

CREATE TABLE CUSTOMER_DETAILS 
(
  CUSTOMER_ID NUMBER(10, 0) NOT NULL primary key ,
  CUSTOMER_NAME VARCHAR2(20 BYTE) NOT NULL,
  AGE NUMBER(3, 0) NOT NULL,
  SSN_NO NUMBER(9, 0) NOT NULL,
  ADDRESS VARCHAR2(50 BYTE) NOT NULL,
  STATE VARCHAR2(20 BYTE) NOT NULL,
  CITY VARCHAR2(20 BYTE) NOT NULL,
);

create sequence acc_id start with 5550 increment by 1;

create sequence cust_id start with 1000 increment by 1;



