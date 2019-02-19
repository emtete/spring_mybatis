package org.wishit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wishit.domain.AccountVO;
import org.wishit.domain.CustomVO;
import org.wishit.mapper.AccountMapper;
import org.wishit.mapper.AccountMapperTest;
import org.wishit.mapper.CustomMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CustomDaoTest {
	
	@Setter( onMethod_ = @Autowired )
	private AccountMapper accountMapper;

	@Setter( onMethod_ = @Autowired )
	private CustomMapper customMapper;
	
	@Setter( onMethod_ = @Autowired )
	private CustomDao dao;
	
	
//	@Test
	public void getListTest() {
		
		Map<String, Object> map = dao.getList();
		
		List<CustomVO> customList = (List<CustomVO>)(map.get("custom"));
		List<AccountVO> accountList = (List<AccountVO>)(map.get("account"));
		
		customList.forEach( custom -> System.out.println(custom) );
		accountList.forEach( account -> System.out.println(account) );
	}
	
	
//	@Test
	public void getTest() {

		Map<String, Object> map = dao.get("222-22-22222");

		List<CustomVO> customList = (List<CustomVO>)map.get("custom");
		List<AccountVO> accountList = (List<AccountVO>)map.get("account");
		
		System.out.println("\n\n\n");
		customList.forEach( custom -> System.out.println(custom) );
		accountList.forEach( account -> System.out.println(account) );
	}
	
	
	public CustomVO genCustomVO() {
		
		CustomVO custom = new CustomVO();
		
		custom.setBusiNum("911-11-11111");
		custom.setCustom("73");
		custom.setShortt("마트");
		custom.setCeo("ceo");
		custom.setChargePerson("홍길동");
		custom.setBusiCondition("업태");
		custom.setItem("종목");
		custom.setPostNum("1111");
		custom.setAddr1("11");
		custom.setAddr2("22");
		custom.setTel("12312");
		custom.setFax("12312");
		custom.setHomepage("홈페이지");
		custom.setCoYn("Y");
		custom.setForeignYn("N");
		custom.setTaxYn("Y");
		custom.setCountryEng("KOR");
		custom.setCountryKor("대한민국");
		custom.setSpecialRelation("Y");
		custom.setTradeStop("N");
		custom.setRegiInfoMan("홍길동");
		custom.setModiInfoMan("수정인");
		
		return custom;
	}

	
	public AccountVO genAccountVO() {
	
		AccountVO account = new AccountVO();
		
		account.setAccountNum("303832922");
		account.setBusiNum("911-11-11111");
		account.setFactory("77장");
		account.setTradeBank("7수");
	
	return account;
}

	@Test
	public void insertTest() {
		
		AccountVO account = genAccountVO();
		CustomVO custom = genCustomVO();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("custom", custom);
		map.put("account", account);
		
		System.out.println("\n\n\n");
		System.out.println("insertTest : ");
		dao.insert(map);
	}
	
	
//	@Test
	public void updateTest() {
		
		AccountVO account = genAccountVO();
		CustomVO custom = genCustomVO();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("custom", custom);
		map.put("account", account);
		
		System.out.println("\n\n\n");
		System.out.println("updateTest : " + dao.update(map));
		
	}
	
	
//	@Test
	public void deleteTest() {
		
		System.out.println("\n\n\n deleteTest : " + dao.delete("711-11-11111"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
