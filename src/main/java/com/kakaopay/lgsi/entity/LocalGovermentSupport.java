package com.kakaopay.lgsi.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LocalGovermentSupport {

	@Id
	@Column(length=100)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length=10)
	private String localGovermentCode;
	
	@Column(length=25)
	private String target;
	
	@Column(length=10)
	private String usage;
	
	@Column(length=15)
	private String limit;
	
	@Column(length=10)
	private String rate;
	
	@Column(length=15)
	private String institute;
	
	@Column(length=15)
	private String mgmt;
	
	@Column(length=25)
	private String reception;
	
	@Column(length=15)
	private String regDate;
	
	@Column(length=15)
	private String modDate;
}
