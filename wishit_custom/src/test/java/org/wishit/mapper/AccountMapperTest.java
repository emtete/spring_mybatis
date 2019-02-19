package org.wishit.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wishit.domain.AccountVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AccountMapperTest {
	
	@Setter( onMethod_ = @Autowired )
	private AccountMapper accountMapper;
	
//	@Test
	public void getListTest() {
		System.out.println("\n\n\n");
		System.out.println("getListTest : ");
		accountMapper.getList().forEach( account -> log.info( account ) );
	}
	
//	@Test
	public void getTest() {
		System.out.println("\n\n\n");
		System.out.println("getTest : " + accountMapper.get("111-11-11111"));
		
	}
	
	public AccountVO genAccountVO() {
		
		AccountVO account = new AccountVO();
		
		account.setAccountNum("303832922");
		account.setBusiNum("222-22-22222");
		account.setFactory("장");
		account.setTradeBank("행");
		
		return account;
	}
	
//	@Test
	public void insert() {
		
		AccountVO account = genAccountVO();
		
		System.out.println("\n\n\n");
		System.out.println("insertTest : ");
		accountMapper.insert(account);
	}
	
	
//	@Test
	public void update() {
		
		AccountVO account = genAccountVO();
		
		System.out.println("\n\n\n");
		System.out.println("updateTest : " + accountMapper.update(account));
		
	}
	
	
	@Test
	public void delete() {
		
		System.out.println("\n\n\n");
		System.out.println("deleteTest : " + accountMapper.delete("111-11-11111"));
	}
	
}






















