package com.kakaopay.lgsi.service;

import java.util.Iterator;

public interface LgsiService {

	String lgsiSaveAndUpdateFromCSV(Iterator<String[]> csvRowIterator) throws Exception;
}
