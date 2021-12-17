/**
 *  @author Angelique Anders, Jan Asche
 **/

public class Roman {
	static String roman(int n) {  	// Methode nur fuer Aufgabenstellung, richtige Methode ist
		// nomar-Methode. Uebergibt im Prinzip nur das String-Ergebnis
		String erg = "";			// in ein Int-Ergebnis.
		erg=namor(erg,n);
		return erg;

	}

	static String namor(String erg, int n) {		// Richtige Methode, liesst String ein für Rekursion
		// Rechnet den int-Wert immer runter und String hoch
		while(n!=0) {								// wodurch wir das in einer Rekursion machen können
			if (n >= 1000) {							// geht zum Schluss in die roman-Methode wieder zurück.
				erg += "M";
				n -= 1000;
			} else if (n >= 900) {
				erg += "CM";
				n -= 900;
			} else if (n >= 500) {
				erg += "D";
				n -= 500;
			} else if (n >= 400) {
				erg += "CD";
				n -= 500;
			} else if (n >= 100) {
				erg += "C";
				n -= 100;
			} else if (n >= 90) {
				erg += "XC";
				n -= 90;
			} else if (n >= 50) {
				erg += "L";
				n -= 50;
			} else if (n >= 40) {
				erg += "XL";
				n -= 40;
			} else if (n >= 10) {
				erg += "X";
				n -= 10;
			} else if (n >= 9) {
				erg += "IX";
				n -= 9;
			} else if (n >= 5) {
				erg += "V";
				n -= 5;
			} else if (n >= 4) {
				erg += "IV";
				n -= 4;
			} else if (n >= 1) {
				erg += "I";
				n -= 1;
			}
			namor (erg, n);
		}
		return erg;
	}

	public static void main(String[] args) {

		if (args.length == 0) { // Keine Eingabe.
			System.out.println("Bitte eine Zahl als Parameter angeben.");
			System.exit(0);
		}

		int N = Integer.parseInt(args[0]);	// Liesst Wert ein.
		assert(1<=N && N<=5000); 			// Soll schlecht sein, weshalb nochmal eine Ueberpruefung stattfindet.

		if (N < 1 || N > 5000) {			// Gleiche Ueberpruefung wie oben, da assert nicht soo praktisch dafuer ist.
			System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");	// Wert ausserhalb des Wertebereichs.
		} else {
			System.out.println(roman(N));		// Wert im Wertebereich, rechnet danach Wert in Roemische Zahlen um.
		}
	}
}