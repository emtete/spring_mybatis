package org.wishit.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wishit.domain.CustomVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CustomMapperTest {
	
	@Setter( onMethod_ = @Autowired)
	private CustomMapper customMapper;
	
	
	public CustomVO genCustomVO() {
			
			CustomVO custom = new CustomVO();
			
			custom.setBusiNum("011-11-11111");
			custom.setCustom("롯데마트");
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


	@Test
	public void getListTest() {
		
		CustomVO customVO = genCustomVO();
		
		System.out.println("\n\n\n");
		System.out.println("getListTest : ");
		customMapper.getList(customVO).forEach( custom -> log.info(custom) );
	}
	
//	@Test
	public void getTest() {
		System.out.println("\n\n\n");
		System.out.println("getTest : ");
		log.info( "getTest Result : "+customMapper.get("111-11-11111") );
		
	}
	
	
	
//	@Test
	public void insertTest() {
		
		CustomVO custom = genCustomVO();
		 
		
		System.out.println("\n\n\n");
		System.out.println("insertTest : ");
		customMapper.insert(custom);
	}
	
//	@Test
	public void updateTest() {
		
		CustomVO custom = genCustomVO();
		
		System.out.println("\n\n\n");
		System.out.println("updateTest : ");
		log.info( customMapper.update(custom) );
	}
	
//	@Test
	public void deleteTest() {
		System.out.println("\n\n\n");
		System.out.println("deleteTest : " + customMapper.delete("511-11-11111"));
		
	}

}












