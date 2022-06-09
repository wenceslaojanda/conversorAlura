package ar.com.wenceslaojanda;

public class Conversor {
	
	private String convertirDe;
	private  String convertirA;
	private double cantidad;
	private String descripcion;
	
	
	public Conversor(OpcionConversor valor, OpcionConversor otroValor, double cantidad) {
		super();
		this.convertirDe = valor.getCodigo();
		this.convertirA = otroValor.getCodigo();
		this.cantidad = cantidad;
	}
	
	public Conversor(OpcionConversor valor, OpcionConversor otroValor) {
		super();
		this.convertirDe = valor.getCodigo();
		this.convertirA = otroValor.getCodigo();
		this.descripcion = "De " + valor.getNombre() + " a " + otroValor.getNombre();
	}
	
	public Conversor() {
		
	}

	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getConvertirDe() {
		return convertirDe;
	}
	public void setConvertirDe(String convertirDe) {
		this.convertirDe = convertirDe;
	}
	public String getConvertirA() {
		return convertirA;
	}
	public void setConvertirA(String convertirA) {
		this.convertirA = convertirA;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	

}
