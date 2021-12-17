
public class Sieb {

	public static void main (String[]args) {
		
	int n = Integer.parseInt(args[0]);
	int m=9;
	int speicher []= new int [n];
	int zahl=0;
	
	if (n==0) {
		System.out.println("");
	} else {
		do { 
			
			boolean prim []= new boolean [m];
		
			for (int i=2; i<m; i++)
			{prim[i]=true;}

			for (int i=2; i*i<m;i++) {
				if (prim[i]) {
					for (int k=2; k*i<m; k++)
						prim[k*i]=false;
				}
			}
			for (int i=2;i<m; i++) {
				if (prim[i] && zahl<n) {
					speicher[zahl]=i;
					zahl++;
				}
			}
			if (zahl<n) {
			m=m*10;
			zahl=0;
			}
		} while(n>zahl);
		
		for(int i=0; i<=speicher.length-1;i++) {
		System.out.println(speicher[i]);

		}
	}
	}
}
	
