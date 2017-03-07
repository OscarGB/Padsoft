package utils;

public class Fecha {
	private int dia;
	private int mes;
	private int anyo;
	
	public enum meses {ENE, FEB, MAR, ABR, MAY, JUN, JUL, AGO, SEP, OCT, NOV, DEC};
	
	public Fecha(int dia, int mes, int anyo){
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}
	
	public boolean isFechaValida(Fecha f){
		if(mes > 12 || mes < 1){
			return false;
		}
		
	}
}
