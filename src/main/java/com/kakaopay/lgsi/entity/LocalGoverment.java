package com.kakaopay.lgsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class LocalGoverment{

	@Id
	@Column(length=10)
	private String localGovermentCode;
	
	@Column(length=45)
	private String localGovermentName;
		
}
