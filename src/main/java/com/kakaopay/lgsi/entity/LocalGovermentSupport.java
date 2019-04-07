package com.kakaopay.lgsi.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class LocalGovermentSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idx;
	
	@Column(length=10)
	private String localGovermentCode;
	
	@Column(length=150)
	private String target;
	
	@Column(length=10)
	private String usage;
	
	@Column(length=15)
	private String limitRange;
	
	@Column(length=10)
	private String rate;
	
	@Column(length=45)
	private String institute;
	
	@Column(length=45)
	private String mgmt;
	
	@Column(length=45)
	private String reception;
	
	@Column(length=15)
	private Date regDate;
	
	@Column(length=15)
	private Date modDate;
}
