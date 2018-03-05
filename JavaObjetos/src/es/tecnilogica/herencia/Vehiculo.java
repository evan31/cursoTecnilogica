package es.tecnilogica.herencia;

public class Vehiculo {

	// Atributos
	private String tipo;

	// Constructor
	public Vehiculo(){
		System.out.println("Construyendo Vehiculo");
	}
	public Vehiculo(Vehiculo v){
		this.tipo = v.tipo;
	}

	// Metodos
	public void conducir(){
		System.out.println("Conduciendo Vehiculo");
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
