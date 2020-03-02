CREATE TABLE Book (
	bookid      	INT(2) PRIMARY KEY AUTO_INCREMENT,
	bookname    	TEXT(40),
	publisher   	TEXT(40),
	price       	INT(8),
	stock    		INT(2) UNSIGNED DEFAULT 0
);

CREATE TABLE  Customer (
  custid      	INT(2) PRIMARY KEY AUTO_INCREMENT,  
  name        	TEXT(40),
  address     	TEXT(50),
  phone       	TEXT(20),
  point 		Int(10) UNSIGNED DEFAULT 0
);

CREATE TABLE Orders (
  orderid INT(2) PRIMARY KEY AUTO_INCREMENT,
  custid  INT(2) REFERENCES Customer(custid),
  bookid  INT(2) REFERENCES Book(bookid),
  saleprice INT(8) ,
  orderdate DATE
);

-- Book, Customer, Orders 데이터 생성?
INSERT INTO Book (bookname, publisher, price) VALUES('축구의 역사', '굿스포츠', 7000);
INSERT INTO Book (bookname, publisher, price) VALUES('축구아는 여자', '나무수', 13000);
INSERT INTO Book (bookname, publisher, price) VALUES('축구의 이해', '대한미디어', 22000);
INSERT INTO Book (bookname, publisher, price) VALUES('골프 바이블', '대한미디어', 35000);
INSERT INTO Book (bookname, publisher, price) VALUES( '피겨 교본', '굿스포츠', 8000);
INSERT INTO Book (bookname, publisher, price) VALUES('역도 단계별기술', '굿스포츠', 6000);
INSERT INTO Book (bookname, publisher, price) VALUES('야구의 추억', '이상미디어', 20000);
INSERT INTO Book (bookname, publisher, price) VALUES('야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book (bookname, publisher, price) VALUES('올림픽 이야기', '삼성당', 7500);
INSERT INTO Book (bookname, publisher, price) VALUES('Olympic Champions', 'Pearson', 13000);

INSERT INTO Customer (name, address, phone) VALUES ('박지성', '영국 맨체스타', '000-5000-0001');
INSERT INTO Customer (name, address, phone) VALUES ('김연아', '대한민국 서울', '000-6000-0001');  
INSERT INTO Customer (name, address, phone) VALUES ('장미란', '대한민국 강원도', '000-7000-0001');
INSERT INTO Customer (name, address, phone) VALUES ('추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer (name, address, phone) VALUES ('박세리', '대한민국 대전',  NULL);

-- 주문(Orders) 테이블의 책값은 할인 판매를 가정함
INSERT INTO Orders VALUES (1, 1, 1, 6000, STR_TO_DATE('2014-07-01','%Y-%m-%d')); 
INSERT INTO Orders VALUES (2, 1, 3, 21000, STR_TO_DATE('2014-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (3, 2, 5, 8000, STR_TO_DATE('2014-07-03','%Y-%m-%d')); 
INSERT INTO Orders VALUES (4, 3, 6, 6000, STR_TO_DATE('2014-07-04','%Y-%m-%d')); 
INSERT INTO Orders VALUES (5, 4, 7, 20000, STR_TO_DATE('2014-07-05','%Y-%m-%d'));
INSERT INTO Orders VALUES (6, 1, 2, 12000, STR_TO_DATE('2014-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (7, 4, 8, 13000, STR_TO_DATE( '2014-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (8, 3, 10, 12000, STR_TO_DATE('2014-07-08','%Y-%m-%d')); 
INSERT INTO Orders VALUES (9, 2, 10, 7000, STR_TO_DATE('2014-07-09','%Y-%m-%d')); 
INSERT INTO Orders VALUES (10, 3, 8, 13000, STR_TO_DATE('2014-07-10','%Y-%m-%d'));

-- 여기는 3장에서 사용되는 Imported_book 테이블

CREATE TABLE Imported_Book (
  bookid      INT ,
  bookname    TEXT(40),
  publisher   TEXT(40),
  price       INT(8) 
);
INSERT INTO Imported_Book VALUES(21, 'Zen Golf', 'Pearson', 12000);
INSERT INTO Imported_Book VALUES(22, 'Soccer Skills', 'Human Kinetics', 15000);

COMMIT;
