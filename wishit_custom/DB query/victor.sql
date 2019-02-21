INSERT	INTO	CUSTOM
(		
	BUSI_NUM,	
	CUSTOM,		
	SHORTT,		
	CEO,		
	CHARGE_PERSON,		
	BUSI_CONDITION,		
	ITEM,		
	POST_NUM,		
	ADDR1,		
	ADDR2,		
	TEL,		
	FAX,		
	HOMEPAGE,		
	CO_YN,		
	FOREIGN_YN,		
	TAX_YN,		
	COUNTRY_ENG,		
	COUNTRY_KOR,		
	SPECIAL_RELATION,		
	TRADE_STOP,		
	CONTRACT_PERIOD_S,		
	CONTRACT_PERIOD_E,		
	REGI_INFO_MAN,		
	REGI_INFO_DATE,		
	MODI_INFO_MAN,		
	MODI_INFO_DATE		
) VALUES (		
	'222-22-22222',		
	'롯데마트',		
	'롯데마트',		
	'홍길동',		
	'홍길동',		
	'업태',		
	'종목',		
	'422233',		
	'주소1',		
	'주소2',		
	'12344',		
	'12345',		
	'홈페이지',		
	'Y',		
	'N',		
	'Y',		
	'KOR',		
	'대한민국',		
	'Y',		
	'N',		
	SYSDATE,		
	SYSDATE,		
	'홍길동',		
	SYSDATE,		
	'수정인',		
	SYSDATE		
);
commit;
rollback;
select * from account;
select * from custom;
UPDATE	ACCOUNT
SET	
FACTORY		='만공장',
TRADE_BANK	='만은행',
ACCOUNT_NUM	= '303832922303832922'
WHERE  	
BUSI_NUM	= '222-22-22222';
rollback;
INSERT	INTO	ACCOUNT
	(		
		BUSI_NUM,		
		FACTORY,		
		TRADE_BANK,		
		ACCOUNT_NUM		
	)VALUES(		
		'222-22-22222',		
		'대만공장',		
		'대만은행',		
		'303832922'	
	);