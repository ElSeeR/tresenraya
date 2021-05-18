package paquete;

public class Tablero {
	
	//VARIABLES GLOBALES!!!!!!!!!! -__-
	private String casillas[][];
	
	public Tablero () {
		casillas = new String[3][3];
		 for (int i = 0; i < 3; i++) {
			 for (int j = 0; j < 3; j++) {
				 casillas[i][j] = " ";
			 }
		 } 
	}
	
	public boolean setCasilla(int fila, int columna, String asig) {
		if (casillas[fila][columna] == " ") {
			casillas[fila][columna] = asig;
			return true;
		}
		System.out.println("La casilla está ocupada");
		return false;
		
	}
	
	//1- GANA X     2- GANA O    3- EMPATE    0- CONTINUA   
	public int finJuego() {
		int finJuego = 3;
		for (int i = 0; i < 3; i++) {
			 for (int j = 0; j < 3; j++) {
				  if (casillas[i][j] == " ") {
					  finJuego = 0;
				  }
			 }
		 }
		//COMPRUEBA HORIZONTALES 
		for(int i=0;i<3;i++) {
			if (casillas[i][0] == casillas[i][1] && casillas[i][1] == casillas[i][2]) {
				if(casillas[i][0] == "X")finJuego = 1;
				else if(casillas[i][0] == "O")finJuego = 2;
			} 
		}
		
		//COMPRUEBA VERTICALES 
		for(int j=0;j<3;j++) {
			if (casillas[0][j] == casillas[1][j] && casillas[1][j] == casillas[2][j]) {
				if(casillas[0][j] == "X")finJuego = 1;
				else if(casillas[0][j] == "O")finJuego = 2;
			}
		}
		
		//COMPRUEBA DIAGONALES 
		if (casillas[0][0] == casillas[1][1] && casillas[1][1] == casillas[2][2]) {
			if(casillas[0][0] == "X")finJuego = 1;
			else if(casillas[0][0] == "O")finJuego = 2;
		}		
		
		if (casillas[2][0] == casillas[1][1] && casillas[1][1] == casillas[0][2]) {
			if(casillas[2][0] == "X")finJuego = 1;
			else if(casillas[2][0] == "O")finJuego = 2;
		}		
		return finJuego;
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("    1   2   3\n");
		buff.append("A | "+casillas[0][0]+" | "+casillas[0][1]+" | "+casillas[0][2]+" |\n");
		buff.append("B | "+casillas[1][0]+" | "+casillas[1][1]+" | "+casillas[1][2]+" |\n");
		buff.append("C | "+casillas[2][0]+" | "+casillas[2][1]+" | "+casillas[2][2]+" |\n");
		return buff.toString();	
	}
	
}
