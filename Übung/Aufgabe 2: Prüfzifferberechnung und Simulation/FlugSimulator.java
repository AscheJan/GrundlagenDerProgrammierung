public class FlugSimulator
{
  public static void main (String[]args)
  {
    int anzahlfluege=Integer.parseInt(args[0]);
    double passagiere=0;
    double mittelwert=0;
    int ueberbuchung=0;
    int ticket=78;
    int sitze=75;
    double wahrscheinlichkeit=0.92;
    int passagierezaehler=0;
    int flugnummer=0;
    double ueberuchungwhr=0;
    
    while (flugnummer<anzahlfluege)      // Fluganzahl
    {
      flugnummer++;
      passagierezaehler=0;
      for (int i=0;i<ticket;i++)     // i als Zähler für Tickets
      {
        passagiere=Math.random();                  //Wahrscheinlichkeit vom Passagier
        if (passagiere<=wahrscheinlichkeit) 
        {
          passagierezaehler++;                //wenn Wahrscheinlichkeit vom Passagier kleiner 0.92, dann darf er mit
          mittelwert++;                       //insgesamte Passagiere werden gezählt
        } 
      }
      if (passagierezaehler>sitze) 
      {
        ueberbuchung++;  //Überbuchter Flug wird hochgezählt
        ueberuchungwhr++;
      } 
    }
    mittelwert=mittelwert/anzahlfluege;
    mittelwert= Math.round(10.0*mittelwert)/10.0;
    ueberuchungwhr= ueberuchungwhr/anzahlfluege;
    ueberuchungwhr= ueberuchungwhr*100;
    ueberuchungwhr=Math.round(100.00*ueberuchungwhr)/100.00;
    
    
    System.out.println("Überbuchung: " +ueberbuchung+" ("+String.format("%.2f",ueberuchungwhr)+"%)");
    System.out.println("Mittelwert: "+mittelwert);
  }
}