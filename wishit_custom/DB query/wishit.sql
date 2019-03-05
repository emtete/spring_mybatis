select * from custom;
select * from account;

select 
    C.*,
		    A.BUSI_NUM A_BUSI_NUM,
		    A.FACTORY A_FACTORY,
		    A.TRADE_BANK A_TRADE_BANK,
		    A.ACCOUNT_NUM A_ACCOUNT_NUM
from
    custom c, account A
where 
    c.busi_num = a.busi_num
and
    c.busi_num = '222-11-11111';
    
    
