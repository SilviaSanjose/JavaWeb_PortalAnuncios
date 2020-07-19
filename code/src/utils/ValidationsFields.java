package utils;

import java.util.regex.Pattern;

public class ValidationsFields {
	
	//validar campos vacíos
	public String emptyFields(String a) {
		String error = "";
		if(a.isEmpty()) {
			error= "vacio";
		}
		return error;
	}//end fillFields
	
 //validar email
	public boolean regexEmail(String e) {
		String email = "[\\da-zA-Z\\.\\_]+@[\\da-zA-Z\\_]+\\.[a-zA-Z]{2,6}";
		return Pattern.matches(email, e);
	}

 //validar telefono
	public boolean regexTelefono(String t) {
		String tel = "[\\d]{9}";
		return Pattern.matches(tel, t);
	}
	
	
	
}//end class
