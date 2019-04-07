package com.kakaopay.lgsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.kakaopay.lgsi.common.Identifiable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class LocalGoverment implements Identifiable<Long>{

	@Id
	@Column(length=20)
	@GenericGenerator(name="seq_id", strategy="com.kakaopay.lgsi.common.SeqGenerator")
	@GeneratedValue(generator="seq_id")
	private String localGovermentCode;
	
	@Column(length=45)
	private String localGovermentName;

	@Version
    private Integer version;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return Long.parseLong(localGovermentCode.replace("reg",""));
	}
		
}
