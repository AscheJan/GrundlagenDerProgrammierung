/**
 * 
 */

/**
 * @author Jan Asche, Angelique Anders, Felix Golub
 *
 */
public class KVNummerPruefer {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    String Versicherungsnummer = args[0];
    
    int a = 0;
    int b = 0;
    int c = 0;
    
    int letzterWert = Character.getNumericValue(Versicherungsnummer.charAt(9));
    
    
    //Zahlenwerte ermitteln
    for (int i = 0; i <= 8; i++) {
      if (i % 3 == 0)
        a += Character.getNumericValue(Versicherungsnummer.charAt(i))*7;
      else if (i % 3 == 1)
        b += Character.getNumericValue(Versicherungsnummer.charAt(i))*3;
      else
        c += Character.getNumericValue(Versicherungsnummer.charAt(i))*1;

    }
    //Summe der Zahlenwerte
    int summe = a + b + c;
    
    //Prüfziffer
    int differenz = ((summe /10) +1) * 10 - summe;

    //Wahr oder Falsch
    if (differenz == letzterWert) {
      System.out.println("Korrekt");
    }
    else
    {
      if (differenz!=10) {
        System.out.println("Inkorrekt\nKorrekte Ziffer: "+ differenz);
      } else {
        System.out.println("Inkorrekt\nKorrekte Ziffer: 0");
      } //Differenz ungleich 10?
    }
    
  }

}
