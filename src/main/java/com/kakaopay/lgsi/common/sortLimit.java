package com.kakaopay.lgsi.common;

import java.util.Comparator;

import com.kakaopay.lgsi.entity.LocalGovermentSupport;

public class sortLimit implements Comparator<LocalGovermentSupport>{	
	
	@Override
	public int compare(LocalGovermentSupport o1, LocalGovermentSupport o2) {
		// TODO Auto-generated method stub
		int aLimit = Integer.parseInt(o1.getLimit().toString().replace(" ","").replace("억원이내", "00").replace("백만원이내", "").replace("추천금액이내","0"));
		int bLimit = Integer.parseInt(o1.getLimit().toString().replace(" ","").replace("억원이내", "00").replace("백만원이내", "").replace("추천금액이내","0"));
		if(aLimit==bLimit) {
			String aRate = o1.getRate().toString().replace(" ", "").replace("대출이자전액", "0").replace("%", "");
			String bRate = o2.getRate().toString().replace(" ", "").replace("대출이자전액", "0").replace("%", "");
			String[] aRates = aRate.split("~");
			String[] bRates = bRate.split("~");
			int aInt1 = (int)Double.parseDouble(aRates[0])*100;
			int aInt2 = 0;
			if(aRates.length>1) {
				aInt2 = (int)Double.parseDouble(aRates[1])*100;
			}
			int bInt1 = (int)Double.parseDouble(bRates[0])*100;
			int bInt2 =0;
			if(bRates.length>1) {
				bInt2 = (int)Double.parseDouble(bRates[1])*100;
			}
			
			return ((aInt1+aInt2)/2) - ((bInt1+bInt2)/2);
		}else
			return aLimit-bLimit;
	}

}
