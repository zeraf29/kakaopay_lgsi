package com.kakaopay.lgsi.common;

import java.io.Serializable;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class SeqGenerator extends IdentityGenerator{

	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		
		String prefix = "reg";
		/*
		if(object instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) object;
            Serializable id = identifiable.getId();
            
            if(id != null) {
                return prefix+StringUtils.leftPad(id.toString(),4, '0');
            }
        }
		System.out.println(((Identifiable) object).getId());
		return super.generate(session, object);
		*/
		Identifiable identifiable = (Identifiable) object;
        Serializable id = identifiable.getId();
		return prefix+StringUtils.leftPad(id.toString(),4, '0');
	}

}
