package challenge.model.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {
	
	public static int calculaIdade(Date dt_nascimento) {
		
		
		
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dt_nascimento);
		
		//criar um objeto calendar com data atual
		Calendar today = Calendar.getInstance();
		
		//Obtem a idade baseada no ano
		int age = today.get(Calendar.YEAR)- dateOfBirth.get(Calendar.YEAR);
		
		dateOfBirth.add(Calendar.YEAR, age);
		
		//se a data de hoje é antes da data de Nascimento, então diminui 1(um)
		if(today.before(dateOfBirth))
			age--;
			
		return age;
		
	}

}
