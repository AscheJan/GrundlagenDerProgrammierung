
/**
 * @author Jan Asche
 *
 */
public class GGT {

	/**
	 * @param args
	 */
	public static int ggt(int a, int b) {
		

		while (b != 0) {
			if (a > b) {
				a = a - b;				
			}else {
				b = b - a;				
			}
		}

		return a;
	}

	public static void main(String[] args) {

		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		if (a > 0 && b > 0) {
			int ergebnis = ggt(a, b);
			System.out.println("Der größte gemeinsame Teiler von " + a + " und " + b + " ist: " + ergebnis);

		}else {
			System.out.println(" Es sind nur positive ganze Zahlen als Argument erlaubt.");
			System.exit(-1);

		}

	}
}
