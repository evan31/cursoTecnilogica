/**
 *
 */
package es.tecnilogica.objetos;

/**
 * @author Carlos Gonzalez Gonzalez
 *
 */
public class Coche {

	// Atributos
	private String color;
	private String marca;
	private int caballosPotencia;

	// Contructor vacio
	public Coche(){

	}

	// Constructor de copia
	public Coche(Coche c){
		this.color = c.color;
		this.marca = c.color;
		this.caballosPotencia = c.caballosPotencia;
	}

	/**
	 * Constructor por parametros
	 *
	 * @param color Color inicial del coche
	 * @param marca Marca inicial del coche
	 * @param caballosPotencia Caballos de potencia iniciales del coche
	 */
	public Coche(String color,String marca,int caballosPotencia){
		this.color = color;
		this.marca = marca;
		this.caballosPotencia = caballosPotencia;
	}

	// Metodos
	/**
	 * Metodo que arranca el coche
	 */
	public void arrancar(){
		System.out.println("Arranco el coche...");
	}
	/**
	 * Metodo para cambiar el color
	 * @param color Nuevo color del coche
	 * @return cambio true si se ha cambiado, false si no
	 */
	public boolean cambiarColor(String color){
		boolean cambio = false;

		if(this.color == null || !this.color.equalsIgnoreCase(color)){
			this.color = color;
			cambio = true;
		}

		return cambio;
	}


	/**
	 * Metodo para obtener el color del coche
	 *
	 * @return el color del coche
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Metodo para obtener la marca del coche
	 *
	 * @return la marca del coche
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Metodo para obtener los caballos de potencia del coche
	 *
	 * @return los caballos de potencia del coche
	 */
	public int getCaballosPotencia() {
		return caballosPotencia;
	}

	/**
	 * Metodo que actualiza el color del coche
	 *
	 * @param color Nuevo color del coche
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Metodo que actualiza la marca del coche
	 *
	 * @param marca Nueva marca del coche
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Metodo que actualiza los caballos de potencia del coche
	 *
	 * @param caballosPotencia Nuevos caballos de potencia del coche
	 */
	public void setCaballosPotencia(int caballosPotencia) {
		this.caballosPotencia = caballosPotencia;
	}

}
