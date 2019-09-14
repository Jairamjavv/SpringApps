DROP DATABASE IF EXISTS supermarketdb;
CREATE DATABASE supermarketdb;
USE supermarketdb;

DROP TABLE if exists customer CASCADE;
DROP TABLE if exists customertypes CASCADE;

CREATE TABLE customer (
 customerId Integer(10) PRIMARY KEY AUTO_INCREMENT,
 customerName VARCHAR(20),
 billingDate date,
 bill DOUBLE(10,2),
customerType varchar(3)
);


CREATE TABLE customertypes(
  customerType varchar(3) PRIMARY KEY,
 minimumBill double(10,2),
maximumBill double(10,2)
);



INSERT INTO customer VALUES (101, 'ABC', '2012-10-1',500, 'P');
INSERT INTO customer VALUES (102, 'ABC', '2012-10-2',900, 'G');

commit;


INSERT INTO customertypes VALUES ('P', 100, 1000);
INSERT INTO customertypes VALUES ('G', 500, 1500);

commit;


