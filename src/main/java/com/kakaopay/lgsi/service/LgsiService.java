package com.kakaopay.lgsi.service;

import java.util.Iterator;

public interface LgsiService {

	String insertEcoTourismDataFromCSV(Iterator<String[]> csvRowIterator) throws Exception;
}
