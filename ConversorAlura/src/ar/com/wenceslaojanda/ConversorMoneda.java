package ar.com.wenceslaojanda;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ConversorMoneda extends Conversor{
	
	private String resultado;
	
	public String convertir(String tipoConversion, double cantidad) {
		
		DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
		separadoresPersonalizados.setDecimalSeparator('.');
		DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
		
		switch(tipoConversion) {
		case "De Pesos Argentinos a Dolares":{
			resultado = formato1.format(cantidad) + " ARS equivalen a " +  formato1.format(cantidad / 211) + " USD";
			break;
		}
		case "De Pesos Argentinos a Euros":{
			resultado = formato1.format(cantidad) + " ARS equivalen a " +  formato1.format(cantidad / 225) + " EUR";
			break;
		}
		case "De Dolares a Pesos Argentinos":{
			resultado = formato1.format(cantidad) + " USD equivalen a " +  formato1.format(cantidad * 211) + " ARS";
			break;
		}
		case "De Dolares a Euros":{
			resultado = formato1.format(cantidad) + " USD equivalen a " +  formato1.format(cantidad * 0.93 ) + " EUR";
			break;
		}
		case "De Euros a Pesos Argentinos":{
			resultado = formato1.format(cantidad) + " EUR equivalen a " +  formato1.format(cantidad * 225) + " ARS";
			break;
		}
		case "De Euros a Dolares":{
			resultado = formato1.format(cantidad) + " EUR equivalen a " +  formato1.format(cantidad * 1.07) + " USD";
			break;
		}
	}
	
	return resultado;
		
	}

}
