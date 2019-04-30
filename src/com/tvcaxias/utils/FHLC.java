package com.tvcaxias.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FHLC {

	public static Calendar stringCalendar(String dataString) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar dataCalendar = new GregorianCalendar();
		dataCalendar.setTime(dateFormat.parse(dataString));
		return dataCalendar;
	}
	
	public static String calendarTimestamp(Calendar dataCalendar) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataString = dateFormat.format(dataCalendar.getTime()); 
		return dataString;
	}
	
	public static Calendar timestampCalendar(String dataString) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar dataCalendar = new GregorianCalendar();
		dataCalendar.setTime(dateFormat.parse(dataString)); 
		return dataCalendar;
	}
	
	public static String calendarString(Calendar dataCalendar) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataString = dateFormat.format(dataCalendar.getTime()); 
		return dataString;
	}
	
}
