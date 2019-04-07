package com.kakaopay.lgsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class LocalGoverment{

	@Id
	@Column(length=20)
	@GenericGenerator(name="seq_id", strategy="com.kakaopay.lgsi.common.SeqGenerator")
	@GeneratedValue(generator="seq_id")
	private String localGovermentCode;
	
	@Column(length=45)
	private String localGovermentName;
		
}
