package es.tecnilogica.herencia;

public class Coche extends Vehiculo{
	// Atributos
	private String color;
	private String marca;
	private int caballosPotencia;

	// Constructores
	public Coche(){
		System.out.println("Construyendo Coche");
	}

	public Coche(Coche c){
		super(c);
		this.color = c.color;
		this.marca = c.marca;
		this.caballosPotencia = c.caballosPotencia;
	}

	// Metodos
	@Override
	public void conducir(){
		System.out.println("Conduciendo Coche");
	}

	// Getters & Setters

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @return the caballosPotencia
	 */
	public int getCaballosPotencia() {
		return caballosPotencia;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @param caballosPotencia the caballosPotencia to set
	 */
	public void setCaballosPotencia(int caballosPotencia) {
		this.caballosPotencia = caballosPotencia;
	}

}
