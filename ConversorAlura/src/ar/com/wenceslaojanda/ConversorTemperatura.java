package ar.com.wenceslaojanda;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ConversorTemperatura extends Conversor{

private String resultado;
	
	public String convertir(String tipoConversion, double cantidad) {
		
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
		
		switch(tipoConversion) {
		case "De Celsius a Fahrenheit":{
			resultado = formato1.format(cantidad) + " ºC equivalen a " +  formato1.format(9 * cantidad / 5 + 32) + " ºF";
			break;
		}
		case "De Celsius a Kelvin":{
			resultado = formato1.format(cantidad) + " ºC equivalen a " +  formato1.format(cantidad + 273.15) + " ºK";
			break;
		}
		case "De Fahrenheit a Celsius":{
			resultado = formato1.format(cantidad) + " ºF equivalen a " +  formato1.format(5 * (cantidad - 32) / 9) + " ºC";
			break;
		}
		case "De Fahrenheit a Kelvin":{
			resultado = formato1.format(cantidad) + " ºF equivalen a " +  formato1.format(5 * (cantidad - 32) / 9 + 273.15) + " ºK";
			break;
		}
		case "De Kelvin a Celsius":{
			resultado = formato1.format(cantidad) + " ºK equivalen a " +  formato1.format(cantidad - 273.15) + " ºC";
			break;
		}
		case "De Kelvin a Fahrenheit":{
			resultado = formato1.format(cantidad) + " ºK equivalen a " +  formato1.format(9 * (cantidad - 273.15) / 5 + 32) + " ºF";
			break;
		}
	}
	
	return resultado;
		
	}
}
