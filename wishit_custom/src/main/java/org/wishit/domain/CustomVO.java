package org.wishit.domain;

import java.util.Date;

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
	private Date contractPeriodS;
	private Date contractPeriodE;
	private String regiInfoMan;
	private Date regiInfoDate;
	private String modiInfoMan;
	private Date modiInfoDate;
}
