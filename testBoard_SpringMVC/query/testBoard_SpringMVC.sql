CREATE SEQUENCE seq_board;


CREATE TABLE tbl_board (			
	bno	number	(10,0),
	title	varchar2	(200)	not null,
	content	varchar2	(2000)	not null,
	writer	varchar2	(50)	not null,
	regdate	date default sysdate,		
	updatedate	date default sysdate		
);


alter table tbl_board add constraint pk_board
primary key(bno);


insert into tbl_board ( bno, title, content, writer)
            values    ( seq_board.nextval, 'title', 'content', 'writer');
            
            
select regdate from tbl_board;

select /*+ INDEX_ASC(tbl_board pk_board*/ * from tbl_board
where bno > 0;


select * from tbl_board order by bno desc;

select /*+ INDEX_DESC (tbl_board pk_board) */
rownum rn, bno, title, content, writer, regdate, updatedate
from 
    tbl_board;    
    
    
select 
    * 
from
    (select /*+ INDEX_DESC (tbl_board pk_board) */
        rownum rn, bno, title, content, writer, regdate, updatedate
    from 
        tbl_board
    where rownum <= 20)
where rn > 10;
    
    
    
select
    
    bno, title, content, writer, regdate, updatedate 
from
    (select /*+ INDEX_DESC (tbl_board pk_board) */ 
        rownum rn, bno, title, content, writer, regdate, updatedate 
    from 
        tbl_board 
    where 
        rownum <= 20) 
where rn > 10 ;
    
    
    commit;
    
    select * from (select /*+ INDEX_DESC (tbl_board 
pk_board) */ rownum rn, bno, title, content, writer, regdate, updatedate from tbl_board where 
rownum <= 3 * 10 ) where rn > (3 - 1) * 10 