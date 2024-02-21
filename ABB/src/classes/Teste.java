package classes;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {

		int num;
		//String numero;

		ArvoreBinaria arv = new ArvoreBinaria();

		Scanner tec = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.print("Digite um número: ");
			//numero = tec.nextLine();
			num = tec.nextInt();
			arv.inserirNo(num);
		}
		
		tec.close();
		arv.exibirNo();
		System.exit(0);
	}

}
