package es.tecnilogica.objetos;

public class Prueba {

	public static void main(String[] args) {
		// 0. Crear instancia de un objeto
		Coche coche1 = new Coche();
		Coche coche2 = new Coche("Rojo","Opel",220);
		/*Coche coche3 = coche2;
		coche3.setColor("Azul");*/
		Coche coche3 = new Coche(coche2);
		coche3.setColor("Azul");

		// 1. Vemos los atributos
		System.out.println("----- Coche 1 -----");
		System.out.println("Color coche1: " + coche1.getColor());
		System.out.println("Marca coche1: " + coche1.getMarca());
		System.out.println("Caballos de potencia coche1: " + coche1.getCaballosPotencia());

		System.out.println("----- Coche 2 -----");
		System.out.println("Color coche2: " + coche2.getColor());
		System.out.println("Marca coche2: " + coche2.getMarca());
		System.out.println("Caballos de potencia coche2: " + coche2.getCaballosPotencia());

		System.out.println("----- Coche 3 -----");
		System.out.println("Color coche3: " + coche3.getColor());
		System.out.println("Marca coche3: " + coche3.getMarca());
		System.out.println("Caballos de potencia coche3: " + coche3.getCaballosPotencia());

		// 2. Probamos los metodos
		System.out.println("----- Metodos -----");
		coche1.arrancar();
		boolean cambio = coche1.cambiarColor("negro");
		System.out.println("¿Ha cambiado el color? " + cambio);
		System.out.println("El color del coche 1 es:" + coche1.getColor());
	}

}
