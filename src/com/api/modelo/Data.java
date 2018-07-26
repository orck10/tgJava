package com.api.modelo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {
	public Calendar formata(String data) throws Exception {
		String dataString = data;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date dataFormatada = new java.sql.Date(df.parse(dataString).getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(dataFormatada);
		return c;
	}
}
