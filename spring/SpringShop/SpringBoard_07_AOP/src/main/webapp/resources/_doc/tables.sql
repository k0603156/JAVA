CREATE TABLE TBL_PRODUCT (
	PNO NUMBER,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	WRITER VARCHAR2(100) NOT NULL,
	REGD8 DATE DEFAULT sysdate,
	MODD8 DATE DEFAULT sysdate,
	READCOUNT NUMBER DEFAULT 0,
	IMGFILE VARCHAR2(2000)
);
ALTER TABLE TBL_PRODUCT
ADD CONSTRAINT TBL_PRODUCT_PK PRIMARY KEY (PNO)
ENABLE;

CREATE SEQUENCE SEQ_PRODUCT INCREMENT BY 1 MINVALUE 0 NOCYCLE NOCACHE NOORDER ;




***************


CREATE SEQUENCE seq_comment
START WITH 1
INCREMENT BY 1
nocycle nocache;

CREATE TABLE tbl_comment(
cno NUMBER(10,0),
pno NUMBER(10,0) NOT NULL,
content varchar2(1000) NOT NULL,
writer varchar2(50) NOT NULL,
regd8 DATE DEFAULT sysdate,
modd8 DATE DEFAULT sysdate
);

ALTER TABLE tbl_comment
ADD CONSTRAINT pk_comment PRIMARY key(cno);

ALTER TABLE tbl_comment
ADD CONSTRAINT fk_comment_product
FOREIGN KEY	(pno) REFERENCES tbl_product (pno);

ALTER TABLE TBL_PRODUCT ADD (commentcnt NUMBER(10,0) DEFAULT 0);









CREATE TABLE SPRINGDB.TBL_QNA (
	QNO NUMBER(38,0),
	TITLE VARCHAR2(200),
	CONTENT VARCHAR2(2000),
	WRITER VARCHAR2(100),
	MODD8 DATE,
	REGD8 DATE,
	READCOUNT NUMBER(38,0),
	"COMMENTCNT" NUMBER(10,0)
);













==============================================

drop sequence seq_product;
drop sequence seq_comment;

CREATE SEQUENCE seq_product
start with 1
increment by 1
nocycle nocache;

truncate table tbl_product;
truncate table tbl_comment;























