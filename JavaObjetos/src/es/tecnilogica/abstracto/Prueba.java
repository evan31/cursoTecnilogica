package es.tecnilogica.abstracto;

public class Prueba {

	public static void main(String[] args) {
		Coche coche1 = new Coche();
		Vehiculo vehiculo = new Coche();
		Vehiculo vehiculo2 = new Bici();

		vehiculo.conducir();

	}

}
