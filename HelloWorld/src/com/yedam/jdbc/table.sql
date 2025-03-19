select *
from   tab;

select *
from   bonus;

select empno,
       ename,
       job,
       mgr,
       hiredate,
       sal,
       comm,
       deptno
from   emp
order by empno desc;

insert into emp (empno, ename, job, mgr, hiredate, sal)
values (9998, '홍길동', 'CLERK' , 7788, '2020-01-01', 1000);

delete from emp
where empno = 9999;

update emp
set    sal = 2000
       ,deptno = 10
where  empno = 9998;

commit;



-- table 생성
-- 도서코드, 도서명, 저자, 출판사, 도서가격
create table tbl_book(
 book_code varchar2(5) primary key, -- 도서코드
 book_title varchar2(50) not null, -- 도서명
 author varchar2(30) not null, -- 저자
 company varchar2(30) not null, -- 출판사
 price number default 1000 -- 도서가격
);

create sequence book_seq;
select book_seq.nextval from dual;

insert into tbl_book(book_code, book_title, author, company, price)
values      (book_seq.nextval, '이것이 자바다', '신용권', '한빛출판사', 20000);
insert into tbl_book(book_code, book_title, author, company, price)
values      (book_seq.nextval, '이것이 자바다2', '신용이', '한빛출판사', 2000);
insert into tbl_book(book_code, book_title, author, company, price)
values      (book_seq.nextval, '이것이 자바다3', '신용삼', '한빛출판사', 200);
insert into tbl_book(book_code, book_title, author, company, price)
values      (book_seq.nextval, '이것이 자바다3', '신용삼', '예담', 200);

select *
from tbl_book
where company = nvl('', company)
order by book_code;

rollback;

delete from tbl_book;
commit;

delete from tbl_book
where book_code = bookCode;

--데이터베이스 프로그래밍
update tbl_book
set    book_title = '매개값'
       ,price     = 25000
       ,author    = '매개값'
where  book_code  = '매개값';