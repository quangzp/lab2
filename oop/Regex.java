package com.lab1.oop;

public class Regex {

	// day format : yyyy-mm-dd
	final static String DATE = "^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$" 
		      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
		      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" 
		      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
	
	final static String EMAIL = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
	final static String PHONE = "(84|0[3|5|7|8|9])+([0-9]{8})\\b"; // VietNam format phone number
	
	final static String FULL_NAME = "^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$";
}
