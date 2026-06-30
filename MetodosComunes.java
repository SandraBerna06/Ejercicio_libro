package ejercicio.libro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosComunes {

	private static Scanner sc = new Scanner(System.in);
	private static Scanner scLetra = new Scanner(System.in);
	private static Scanner scDouble = new Scanner(System.in);
	private static Scanner scBoolean = new Scanner(System.in);

	public static int introduceNumero(String txt) {

		int num = 0;
		boolean rep = true;

		do {
			rep = true;
			try {
				System.out.println(txt);
				num = sc.nextInt();
				if (num < 0) {
					System.err.println("ERROR: El número tiene que ser mayor o igual a 0");
				} else {
					rep = false;
				}

			} catch (InputMismatchException e) {
				System.err.println("ERROR: Debes de introducir un número");
				sc.next();
			} catch (Exception e) {
				System.err.println("ERROR");
			}
		} while (rep);

		return num;
	}

	public static Double introduceDecimal(String txt) {

		double num = 0;
		boolean rep = true;

		do {
			rep = true;
			try {
				System.out.println(txt);
				num = scDouble.nextDouble();
				if (num <= 0) {
					System.err.println("ERROR: El número tiene que ser mayor o igual a 0");
				} else {
					rep = false;
				}

			} catch (InputMismatchException e) {
				System.err.println("ERROR: Debes de introducir un número");
				sc.next();
			} catch (Exception e) {
				System.err.println("ERROR");
			}
		} while (rep);

		return num;
	}

	public static Boolean introduceBoolean(String txt) {

		boolean valido = false;

		boolean texto;
		do {
			System.out.println(txt);
			texto = scBoolean.nextBoolean();

			if (texto == true && texto == false) {
				valido = true;
			} else {
				valido = false;
			}
		} while (!valido);
		
		return texto;
	}

	public static String introduceTexto(String txt) {

		System.out.println(txt);
		String texto = scLetra.nextLine().trim();

		return texto;
	}

}
