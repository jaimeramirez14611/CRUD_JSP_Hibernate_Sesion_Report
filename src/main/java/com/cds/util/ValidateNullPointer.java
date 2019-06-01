package com.cds.util;

public class ValidateNullPointer {
	public static String validateToString(String string) {
	
		if(string == null) {
			string = "";
		}else if(string != "") {
			 string=string.trim();
			 if(string != "") { 
			 //No hacer ninguna accion
			 }else {
				 string = "";
			 }
			 //No hacer ninguna accion
		}else {
			string = "";
		}
		return string;
	}
	public static int validateToInt(String string) {
		int response = 0;
		   //Regresa un ""    
		if(validateToString(string) != "") {
			response = Integer.parseInt(string) ;
		}
		
		return response;
	}
}
