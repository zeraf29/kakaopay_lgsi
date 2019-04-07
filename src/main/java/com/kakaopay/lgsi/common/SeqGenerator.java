package com.kakaopay.lgsi.common;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SeqGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		String prefix = "reg";
		
		Connection connection = session.connection();
        try {
 
            PreparedStatement ps = connection
                    .prepareStatement("SELECT nextval ('HIBERNATE_SEQUENCE') as nextval");
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("nextval");
                String code = prefix + StringUtils.leftPad(Integer.toString(id),4,'0');
                return code;
            }
 
        } catch (SQLException e) {
            throw new HibernateException(
                    "Unable to generate Code Sequence");
        }
		
		return null;
	}

	
	
}
