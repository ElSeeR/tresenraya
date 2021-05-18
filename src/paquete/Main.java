package paquete;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Main {
	//VARIABLES GLOBALES
	private static String jugador1, jugador2;
	private static int dado1, dado2;
	private static Tablero tablero;
	private static Scanner entrada;
	
	public static void main(String[] args) {
		//INICIALIZO EL SCANNER 
		entrada = new Scanner(System.in);
		
		//INICIO DE LA PARTIDA
		System.out.println("Introduzca el nombre del jugador 1:");
		jugador1 = entrada.next();
		
		System.out.println("Introduzca el nombre del jugador 2:");
		jugador2 = entrada.next();
		
		do { 
		dado1 = (int) (Math.random()*6 + 1);
		dado2 = (int) (Math.random()*6 + 1);
		
		System.out.println("Van a jugar " + jugador1 + " y " + jugador2);
		System.out.println(jugador1 + " ha tirado el dado y ha sacado un " + dado1);
		System.out.println(jugador2 + " ha tirado el dado y ha sacado un " + dado2);
		System.out.println("=======================================================");
		} while (dado1 == dado2);
			

		//INICIO EL JUEGO 
		int fin = 0;
		if (dado1 >= dado2) {
			System.out.println(jugador1 + " va a tirar primero");
			fin = juego(jugador1, jugador2);
		}else { 
			System.out.println(jugador2 + " va a tirar primero");
			fin = juego(jugador2, jugador1);
		}
		//FIN DEL JUEGO
		switch (fin) {
		
			case 1: System.out.println("El ganador es el jugador 1"); break;
			case 2: System.out.println("El ganador es el jugador 2"); break;
			default: System.out.println("Partida empatada");
		
		}
		
		String fecha = new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(new Date());
		String fileName = fecha.concat(": ");
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try {
			fichero = new FileWriter("gamelog.txt");
			pw = new PrintWriter(fichero);
		
			for(int i = 0; i < 1; i++ ) {
				pw.println(fileName + "Van a jugar " + jugador1 + " y " + jugador2);
				pw.println(fileName + jugador1 + " ha tirado el dado y ha sacado un " + dado1);
				pw.println(fileName + jugador2 + " ha tirado el dado y ha sacado un " + dado2);
				if (dado1 >= dado2) {
					pw.println(fileName + jugador1 + " va a tirar primero");
				}else { 
					pw.println(fileName + jugador2 + " va a tirar primero");
				}
				switch (fin) {
				
				case 1: pw.println(fileName + "El ganador es " + jugador1); break;
				case 2: pw.println(fileName + "El ganador es " + jugador2); break;
				default: pw.println(fileName + "Partida empatada");
			
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			if(fichero != null) {
				fichero.close();
			}
		}catch(Exception e) {
			
		}
		
	}

	//SI GANA EL JUGADOR 1 DEVUELVE 1, SI GANA EL JUGADOR 2 DEVUELVE UN 2, SI NO, DEVUELVE UN 0
	public static int juego(String jugadorA, String jugadorB) {
		
		int fila = 0, columna = 0, alternador = 0;
		String jugadorAux, pieza;
		boolean malIntroducido, noRepetir;
		tablero = new Tablero();
		System.out.println(tablero.toString());
		
		while (tablero.finJuego() == 0) {
			noRepetir = true;
			if (alternador == 0) {
				jugadorAux = jugadorA;
				alternador = 1;
				pieza = "X";
			}
			else {
				jugadorAux = jugadorB;
				alternador = 0;
				pieza = "O";
			}
			
			do {
			do {
				malIntroducido = false;
				System.out.println(jugadorAux +" Introduce el número");
				columna = entrada.nextInt() - 1;
				if (columna != 0 && columna != 1 && columna != 2) {
					malIntroducido = true;
					System.out.println("Entrada incorrecta");
				}
			} while(malIntroducido);
			do {
				malIntroducido = false;
				System.out.println(jugadorAux +" Introduce la letra");
				String C = entrada.next(); 
				switch(C) {
				case "A": fila = 0; break;
				case "B": fila = 1; break;
				case "C": fila = 2; break;
				default: System.out.println("Entrada incorrecta");
				malIntroducido = true;
				}
			} while(malIntroducido);
			
			noRepetir = tablero.setCasilla(fila, columna, pieza);
			} while(!noRepetir);
				
			System.out.println(tablero.toString());
			
		} 
		return tablero.finJuego();
	}
	
}
