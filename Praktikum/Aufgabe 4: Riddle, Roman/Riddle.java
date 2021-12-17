/**
 * 
 * @author Angelique Anders, Jan Asche
 *
 */
public class Riddle {

	static int zahl;
	static int[] liste;
	static int zahler;
	static int loesungen;

	public static int berechnung (int N, int [] feld,int zahler) {
		int b=N;
		for (int i=-1;i<feld.length-b-2;) {
			i++;
			if(feld[i]==0 && feld[i+b+1]==0) {
				feld [i]=b;
				feld [i+b+1]=b;
				berechnung(b-1,feld,zahler);
				feld[i]=0;
				feld[i+b+1]=0;
			}	
		}
		int ergebnis[]=new int[feld.length];
					for (int i = 0; i < ergebnis.length; i++) {
						if (feld[0] < feld[feld.length - 1]) {
							ergebnis[i] = feld[i];
						} else {
							ergebnis[i] = feld[feld.length - i - 1];
						} 
					}
		if(b==0) {
			boolean doppel=true;

			for (int k=0; k<ergebnis.length;k++) {
				if(ergebnis[k]!=liste[k]) {
					doppel=false;
				}
			}
			if(doppel==false) {
				if (zahl<10) {
					for (int k = 0; k < ergebnis.length; k++) {
						System.out.print(ergebnis[k]);
					}
					System.out.println();
				}
				loesungen++;	
				for (int j=0; j<ergebnis.length;j++) {
					liste[j]=ergebnis[j];
				}	
			}
			else {
				if(loesungen==1) {
					System.out.println("eine Loesung ");
				}else {
				System.out.println(loesungen+" Loesungen");
				}
				System.exit(0);
			}
		}

		return N;

	}

	public static int durchfuhrung(int N) {
		int [] feld= new int [2*N];
		liste=new int[2*N];
		berechnung(N,feld,zahler);
		return N;

	}

	public static void main (String[]args) {

		int N= Integer.parseInt(args[0]);
		zahl=N;
		durchfuhrung(N);
		System.out.println("keine Loesung");
		
	}
}
