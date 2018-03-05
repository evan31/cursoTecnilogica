package es.tecnilogica.bucles;

public class Bucles {

	public static void main(String[] args) {
		int[] numeros = {1,2,3,4,5,6};
		int[] numeros2 = new int[6];
		String[] dias = {"L","M","X","J","V","S","D"};

		System.out.println(numeros[numeros.length-1]);

		// FOR
		System.out.println("----- Bucle FOR -----");
		for(int i = 0;i<dias.length;i++){
			System.out.print(dias[i] + " ");
		}

		System.out.println("");

		// FOREACH
		System.out.println("----- Bucle FOREACH-----");
		for(String s : dias){
			System.out.print(s + " ");
		}

		System.out.println();

		// FOR con BREAK
		System.out.println("----- FOR con BREAK -----");
		for(int i = 0;i < numeros.length;i++){
			if(i==3){
				break;
			}
			System.out.print(numeros[i] + " ");
		}

		System.out.println();

		// Bucle WHILE
		System.out.println("----- Bucle WHILE -----");
		int i = 0;
		while(numeros[i] <= 3){
			System.out.print(numeros[i] + " ");
			i++;
		}

		System.out.println();

		// Bucle DO WHILE
		System.out.println("----- Bucle DO WHILE -----");
		i = 0;
		do{
			System.out.print(numeros[i] + " ");
			i++;
		}while(numeros[i]<=3);
	}

}