package org.wishit.controller;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class CustomControllerTest {
	
	
	@Setter( onMethod_ = @Autowired )
	private CustomController controller;
	
	@Setter( onMethod_ = @Autowired )
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
//	@Test
	public void getListTest() throws Exception{
		log.info( mockMvc.perform(MockMvcRequestBuilders.get("/wishit/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
	
	@Test
	public void getTest() throws Exception {
		log.info( mockMvc.perform(MockMvcRequestBuilders.get("/wishit/get")
				.param("busiNum", "111-11-11111")	)
				.andReturn()
				.getModelAndView()
				.getModelMap()
				
				);
	}
	
	
//	@Test
	public void insertTest() throws Exception {
		
		ModelAndView result= mockMvc.perform(MockMvcRequestBuilders.post("/wishit/insert")
				.param("busiNum", "811-11-11111")
				.param("custom", "234")
				.param("shortt", "234")
				.param("ceo", "234")
				.param("chargePerson", "234")
				.param("busiCondition", "234")
				.param("item", "234")
				.param("postNum", "422233")
				.param("addr1", "2341")
				.param("addr2", "2342")
				.param("tel", "12344")
				.param("fax", "12345")
				.param("homepage", "234")
				.param("coYn", "Y")
				.param("foreignYn", "N")
				.param("taxYn", "Y")
				.param("countryEng", "KOR")
				.param("countryKor", "대한민국")
				.param("specialRelation", "Y")
				.param("tradeStop", "N")
//				.param("contractPeriodS", "22/09/2015")
//				.param("contractPeriodE", "22/09/2016")
				.param("regiInfoMan", "홍길동")
				.param("modiInfoMan", "수정인")
				.param("factory", "대만공장")
				.param("tradeBank", "대만은행")
				.param("accountNum", "303832922")		)
				.andReturn()
				.getModelAndView();
				/*.getModelMap();*/
		
	}
	
//	@Test
	public void updateTest() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.post("/wishit/update")
				.param("busiNum", "811-11-11111")
				.param("custom", "수수")
				.param("shortt", "234")
				.param("ceo", "234")
				.param("chargePerson", "234")
				.param("busiCondition", "234")
				.param("item", "234")
				.param("postNum", "422233")
				.param("addr1", "2341")
				.param("addr2", "2342")
				.param("tel", "12344")
				.param("fax", "12345")
				.param("homepage", "234")
				.param("coYn", "Y")
				.param("foreignYn", "N")
				.param("taxYn", "Y")
				.param("countryEng", "KOR")
				.param("countryKor", "대한민국")
				.param("specialRelation", "Y")
				.param("tradeStop", "N")
//				.param("contractPeriodS", "22/09/2015")
//				.param("contractPeriodE", "22/09/2016")
				.param("regiInfoMan", "홍길동")
				.param("modiInfoMan", "수정인")
				.param("factory", "수수")
				.param("tradeBank", "대만은행")
				.param("accountNum", "303832922") )
				.andReturn()
				.getModelAndView();
						
	}
	
	
//	@Test
	public void deleteTest() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.post("/wishit/delete")
						.param("busiNum", "811-11-11111")
						);
		
	}
	
}






















