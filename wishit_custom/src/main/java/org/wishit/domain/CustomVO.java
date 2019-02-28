package org.wishit.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Data;

@Data
public class CustomVO {
	
	private String busiNum;
	private String custom;
	private String shortt;
	private String ceo;
	private String chargePerson;
	private String busiCondition;
	private String item;
	private String postNum;
	private String addr1;
	private String addr2;
	private String tel;
	private String fax;
	private String homepage;
	private String coYn;
	private String foreignYn;
	private String taxYn;
	private String countryEng;
	private String countryKor;
	private String specialRelation;
	private String tradeStop;
	private String modiInfoMan;
	private String regiInfoMan;
	
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul" )
	private Date contractPeriodS;
	
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul" )
	private Date contractPeriodE;
	
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul" )
	private Date regiInfoDate;
	
	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul" )
	private Date modiInfoDate;
	
	private AccountVO accountVO;
}
