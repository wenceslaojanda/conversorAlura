package ar.com.wenceslaojanda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class Programa {

	public Programa() {
		
		crearMenu();
	}
	
	private void crearMenu() {
		
		Object[] options = { "Conversor de Moneda", "Conversor de Temperatura"};
		
		int finPrograma = 0;
		
		do {
			Object conversorSeleccionado = opcionesConversion("Seleccione el conversor", "Conversor", options);
			
			try {
				double cantidad = Double.parseDouble(ingresoCantidad());
				
				if(conversorSeleccionado == "Conversor de Moneda") {
					
					
					List<Conversor> listaOpciones = crearListaOpciones(opcionesMoneda());
					
					Object opcionSeleccionada = crearMenuSeleccion(listaOpciones);
					
					ConversorMoneda cm = new ConversorMoneda();
					
					String resultado = cm.convertir(opcionSeleccionada.toString(), cantidad);
					
					mostrarConversion(resultado);
					
				}else {
					List<Conversor> listaOpciones = crearListaOpciones(opcionesTemperatura());
					
					Object opcionSeleccionada = crearMenuSeleccion(listaOpciones);
					
					ConversorTemperatura ct = new ConversorTemperatura();
					
					String resultado = ct.convertir(opcionSeleccionada.toString(), cantidad);
					
					mostrarConversion(resultado);
				}
				
				
			} catch(Exception e) {
				
				mensajeError();
			}
			
			finPrograma = deseaFinalizar();
			
			
			
		} while(finPrograma == 0);
		
		mostrarConversion("Programa terminado");
	
	}
	
	private Object opcionesConversion(String mensaje, String titulo, Object[] options){
		
		return JOptionPane.showInputDialog(null,

				"Seleccione el conversor", "Conversor",

				JOptionPane.PLAIN_MESSAGE, null,

				options, options[0]);
	}
	
	private String ingresoCantidad() {
		
		return JOptionPane.showInputDialog(null, "Ingresa la cantidad que deseas convertir: ", "Cantidad", JOptionPane.PLAIN_MESSAGE);
	}
	
	private int deseaFinalizar() {

		return JOptionPane.showInternalConfirmDialog(null,

				"¿Desea continuar?", "Salida",

				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mensajeError() {

		JOptionPane.showMessageDialog(null, "Valor no valido", "Error", JOptionPane.ERROR_MESSAGE);

	}
	
	private List<OpcionConversor> opcionesMoneda(){
		
		List<OpcionConversor> monedas = new ArrayList<>();
		
		monedas.add(new OpcionConversor("ARS", "Pesos Argentinos"));
		monedas.add(new OpcionConversor("USD", "Dolares"));
		monedas.add(new OpcionConversor("EUR", "Euros"));
		
		return monedas;
		
	}
	
private List<OpcionConversor> opcionesTemperatura(){
		
		List<OpcionConversor> temperaturas = new ArrayList<>();
		
		temperaturas.add(new OpcionConversor("C", "Celsius"));
		temperaturas.add(new OpcionConversor("F", "Fahrenheit"));
		temperaturas.add(new OpcionConversor("K", "Kelvin"));
		
		return temperaturas;
		
	}
	
	private List<Conversor> crearListaOpciones(List<OpcionConversor> lista) {
		
		List<Conversor> opcionesAComparar  = new ArrayList<>();
		
		for(OpcionConversor opcion : lista) {
			
			for(OpcionConversor otraOpcion : lista) {
				boolean esIgual = (opcion == otraOpcion);
				
				if(!esIgual) {
					opcionesAComparar.add(new Conversor(opcion, otraOpcion));
				}
			}
			
			
		}
		return opcionesAComparar;
		
	}
	
	private Object crearMenuSeleccion(List<Conversor> lista) {
		
		List<Object> descripciones = new ArrayList<>();
		for(Conversor item : lista) {
			descripciones.add(item.getDescripcion());
			
		}
		
		Object[] arrayOpciones = descripciones.toArray();
		return opcionesConversion("Elije una opción", "Conversores", arrayOpciones);
	}
	
	private void mostrarConversion(String mensaje) {
		

			JOptionPane.showMessageDialog(null, mensaje);

	}
}
