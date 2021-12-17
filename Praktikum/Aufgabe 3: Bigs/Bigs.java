
public class Bigs {

	// addiert die Ziffernfelder a und b
	public static int[ ] add (int[ ] a, int[ ] b) { 		
		int uberflow=0;
		int laenge=0;
		int kleinerelaenge=0;

		if(a.length>=b.length) {
			laenge=a.length;
			kleinerelaenge=b.length;
		}
		else { 
			laenge=b.length; 
			kleinerelaenge=a.length; 
		}

		int ergebnis[]=new int[laenge];

		for (int i=0;i<kleinerelaenge;i++) {

			ergebnis[i]=a[i]+b[i]+uberflow;
			if (ergebnis[i]>9) {
				uberflow=ergebnis[i]/10;
				ergebnis[i]=ergebnis[i]%10;
			}
			else {
				uberflow=0;
			}
		}

		if(a.length!=b.length) {


			for (int i = kleinerelaenge; i < laenge; i++) {
				if (a.length == laenge) {

					ergebnis[i]=a[i]+uberflow;
					if (ergebnis[i]>9) {
						uberflow=ergebnis[i]/10;
						ergebnis[i]=ergebnis[i]%10;
					}else {uberflow=0;}

				} else {

					ergebnis[i]=b[i]+uberflow;
					if (ergebnis[i]>9) {
						uberflow=ergebnis[i]/10;
						ergebnis[i]=ergebnis[i]%10;
					}
					else {
						uberflow=0;
						}
					}


				}
			}


			if (uberflow!=0) {
				int uberfluss[]=new int[kleinerelaenge+1];
				for (int i = 0; i < ergebnis.length; i++) {
					uberfluss[i] = ergebnis[i];
				}
				uberfluss[uberfluss.length-1]=uberflow;
				return uberfluss;

			}
			return ergebnis;
		}											

		// gibt das Ziffernfeld n in lesbarer dezimaler Form aus												
		// bei sehr langen Zahlen soll das Format verwendet werden, welches auch von
		// bc (s.u.) benutzt wird: Umbruch nach 68 Ziffern mit einem \ am Ende
		static void print (int[ ] n) { 
			for(int i=0;i<n.length;i++) {
				System.out.print(n[n.length-1-i]);
				if((i+1)%68==0) {
					System.out.println("\\");
				}
			}
			System.out.println();
		}
		// konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
		static int[ ] digit(int d) { 
			return new int [] {d};	
		}

		// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
		static int[ ] Null() { return digit(0); }

		// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
		static int[ ] One() { return digit(1); }

		// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
		static int mod10(int[ ] n) { return n[0]; }

		// ganzzahliger Quotient bei Division durch 10
		static int[ ] div10(int[ ] n) { 

			int k[]=new int[n.length];
			for (int i=0;i<n.length;i++) {
				k[i]=n[i]%10;
			}
			return k;
		}

		// Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
		static int[ ] fromInt(int n) { 
			int k[]=new int[String.valueOf(n).length()];
			for (int i=0;i<k.length;i++) {
			
				k[i]=Character.getNumericValue(String.valueOf(n).charAt(k.length-i-1));
				
			}
			return k;
		}

		// kopiert den Wert von n
		static int[ ] copy(int[ ] n) { return n; }

		// multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
		static int[ ] times(int[ ] n, int d) { 
			int ergebnis[]=new int[n.length];
			int uberflow=0;
			for (int i=0;i<n.length;i++) {
				ergebnis[i]=n[i]*d+uberflow;
				if (ergebnis[i]>9) {
					uberflow=ergebnis[i]/10;
					ergebnis[i]=ergebnis[i]%10;
				}
				else {
					uberflow=0;
				}
			}
			if (uberflow!=0) {
				int uberfluss[]=new int[n.length+1];
				for (int i = 0; i < ergebnis.length; i++) {
					uberfluss[i] = ergebnis[i];
				}
				uberfluss[uberfluss.length-1]=uberflow;
				return uberfluss;

			}
			return ergebnis;
		}

		// multipliziert das Ziffernfeld n mit 10
		static int[ ] times10(int[ ] n) { 

			int []ergebnis=new int[n.length+1];
			for (int i=1;i<ergebnis.length;i++) {
				ergebnis[i]=n[i-1];
			}
			return ergebnis;
		}

		// multipliziert zwei Ziffernfeld
		static int[ ] times(int[ ] a, int[ ] b) { 		
			int ergebnis[]=new int[0];

			for (int i=b.length-1;i>=0;i--) {

				ergebnis=add(times10(ergebnis),times(a,b[i]));

			}

			return ergebnis;
		}

		// Quadratzahl eines Ziffernfeldes
		static int[ ] square(int[ ] a) { 
			return times(a,a);
		}

		// Kubikzahl eines Ziffernfeldes
		static int[ ] cubic(int[ ] a) {
			return times(a,times(a,a));
		}

		// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
		static boolean less (int[ ] a, int[ ] b) { 

			if(a.length<b.length) {
				return true;
			}
			for(int i=a.length-1; i>=0; i++) {
				
				if(a[i]<b[i]) {
					return true;
				}
			}
		
			return false;
			
		}

		// Test auf Gleichheit zweier Ziffernfelder
		static boolean equal (int[ ] a, int[ ] b) { 
			
			if (a.length==b.length) {
				for (int i=a.length-1; i>=0;i--) {
					if (a[i]==b[i]) {
						return true;
					}
				}
			}
			return false;
		}

		// Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
		// mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
		// keine fuehrenden Nullen (ausser bei Null selbst)
			static boolean ok (int[ ] n) {
				if(n.length>1 && n[n.length-1]==0) {
					return false;
				}
				if(n.length==1 && n[0]==0) {
					return true;
				}
				for (int i=n.length; i<n.length;i++) {
					if (n[i]<=9 || n[i]>=0) {
						return true;
					}
				}
				return false;
			}

		// gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
			static void maxDigit(int[] n) { 
				int zahlen[]=new int [10];
				int kleinste=0;
				for (int i=0;i<n.length;i++){
					zahlen[n[i]]=zahlen[n[i]]+1;
				}
				
				for(int k=1;k<=9;k++) {
					if (zahlen[k]>zahlen[kleinste]) {
						kleinste=k;
					}
				}
				System.out.println(kleinste+": "+zahlen[kleinste]);
			}

		public static void main (String[] s) {
			int[ ] a = One();
			for (int i=0; i<33222; ++i) { a = times(a, 2); }
			System.out.println("2^33222 hat " + a.length + " Stellen");
			print(a);
			System.out.println();
			int[ ] b = fromInt(13);
			int[ ] c = copy(b);
			for (int i=1; i<8978; ++i) { c = times(c, b); }
			System.out.println("13^8978 hat " + c.length + " Stellen");
			print(c);
			System.out.println();
			System.out.println(less(a, c)); // beantwortet die Frage aus der
											// Aufgabenueberschrift
			maxDigit(a);
			maxDigit(c);
		}
	}
