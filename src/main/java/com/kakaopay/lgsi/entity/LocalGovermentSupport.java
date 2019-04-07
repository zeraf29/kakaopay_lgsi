package com.kakaopay.lgsi.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne(targetEntity=LocalGoverment.class, fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="Local_Goverment_Code")
	private LocalGoverment localGoverment;
	//private String localGovermentCode;
	
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
