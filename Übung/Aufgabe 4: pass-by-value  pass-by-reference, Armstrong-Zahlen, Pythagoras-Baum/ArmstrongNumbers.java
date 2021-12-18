/**
 * 
 * @author Angelique Anders, Jan Asche
 *
 */
public class ArmstrongNumbers {
  public static void main(String[] args) {
    int[] test = giveArmstrongNumbers(Integer.parseInt(args[0]));
    int n=test.length;
    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634
    printArray(test);
    
  }

  public static boolean isArmstrongNumber(int number) { // Ueberpruefung ob Parameter "number" 
	  													//Bedingung einer Armstrongzahl erfuellt
	  int zahl=number;
	  int tester=0;
	  int stellen=0;
	  
	  stellen= (int)java.lang.Math.log10(zahl);
	  stellen= (int)java.lang.Math.floor(stellen);

	  for (int i=0; i<stellen+1;i++) {
		  tester+=(int)java.lang.Math.pow((zahl%10), stellen+1);
		  zahl=zahl/10;
	  }
	  
	  if(number==tester) {
		  return true;
		  }
	  else {
		  return false;
		  }
    
  }

  public static int[] giveArmstrongNumbers(int n) {    // Gibt die Ersten n Armstrong-Zahlen in einem Array zurueck
	  		
	  int [] armstrongs = new int [n];
	  int zaehler=0;
	  for (int i=0; zaehler < n;i++) {
		if (isArmstrongNumber(i)==true) {
			armstrongs[zaehler]=i;
			zaehler++;
		}
	}
			return armstrongs;
			  
  }

  private static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
      System.out.print(i < a.length - 1 ? ", " : "\n");
    }
  }
}
