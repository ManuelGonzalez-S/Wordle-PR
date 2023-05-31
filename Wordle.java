import java.util.Random;
import java.util.Scanner;

public class Wordle {

public static void main(String[] args) {
	String palabra,palabraUsuario;
	char caracterPalabraSecreta,caracterUsuario;
	int lenPalabraUsuario,vidas = 6,palabraHoy;
	boolean victoria = false,caracterCorrecto=false, posicionCorrecta = false;
	Scanner lector = new Scanner(System.in);
	Random r = new Random();
	
	
	String[] bancoPalabras = {"gatos","lapiz","pisar","raton","diosa","salto","altos","pelos","corte","nariz","firme","firma","firmo","horas","album","disco","edgar","movil","calor","bolis"};

	// Coge valores entre 0 y la longitud del banco de palabras
	palabraHoy = r.nextInt(bancoPalabras.length);
	
	palabra = bancoPalabras[palabraHoy];

	do {
		do {
			System.out.println("Introduce una palabra:");
			palabraUsuario=lector.nextLine();
			lenPalabraUsuario=palabraUsuario.length();

			if (lenPalabraUsuario!=5) {
				System.out.println("La palabra debe tener 5 letras");

			}else {
				palabraUsuario=palabraUsuario.toLowerCase();
			}
		} while (lenPalabraUsuario!=5);

	 
	 
	 
		for(int i=0;i<lenPalabraUsuario;i++) {//en un bucle que se recorre 5 veces (va a ser siempre eso pero por si se fuera a cambiar en algún momento)
			caracterUsuario=palabraUsuario.charAt(i);
			for(int j=0;j<lenPalabraUsuario;j++) {

				/*Y luego otro bucle que se recorre las mismas veces que el bucle anterior, ya que las dos palabras tienen la
				 * misma longitud*/

				caracterPalabraSecreta=palabra.charAt(j);

				if (caracterUsuario==caracterPalabraSecreta && palabra.charAt(i)==palabraUsuario.charAt(i)) {
					/*Este caso es que el caracter de la palabra del usuario y el caracter de la palabra secreta sean iguales y a su vez estén en la misma
					 * posicion ya que evaluando que los caracteres sean iguales y a la vez evaluar que el caracter en la posicion i de la palabra
					 * del usuario sea igual al caracter de la palabra secreta es que están en la misma posición y son las mismas*/
					posicionCorrecta=true;

				}else if(caracterUsuario==caracterPalabraSecreta) {
					caracterCorrecto=true;
				}
			}
			if (posicionCorrecta) {
				System.out.print("\033[32m"+caracterUsuario+"\u001B[0m");
			}else if (caracterCorrecto) {
				System.out.print("\033[33m"+caracterUsuario+"\u001B[0m");
			}else {
				System.out.print("\033[31m"+caracterUsuario+"\u001B[0m");
			}
			posicionCorrecta=false;
			caracterCorrecto=false;
		}
	
	
		vidas--;
		System.out.println("");
		if (palabra.equals(palabraUsuario)) {
			victoria=true;
		}else {
			System.out.println("Te quedan "+vidas+" vidas");
		}
	} while (!victoria && vidas>0);
	if(victoria) {
		System.out.println("Muy bien, has acertado la palabra :D");
	}else {
		System.out.println("Has perdido :(");
	}

	lector.close();
	
	}

}
