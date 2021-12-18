import java.math.BigInteger;

/**
 * 
 * @author Angelique Anders, Jan Asche
 *
 */

public class Nolindrom
{
  
  public static void main (String[]args)
  {
    long Abbruch=0;
    BigInteger N=new BigInteger("1");
 
    
     if (args.length==0) 
    {
      //System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
    } 
    else 
    {
      Abbruch=Long.parseLong(args[0]);
    } 
    if (args.length==2) {
    if (args[1].compareTo("x")==0) {
      long durchfuehrung=0;  
      BigInteger Variable=new BigInteger("1");
      BigInteger Variable2=new BigInteger("0");
      BigInteger VariableS=new BigInteger("0");
      BigInteger Rest=new BigInteger("0");
      BigInteger R=new BigInteger("0");
      BigInteger S=new BigInteger("0");
      BigInteger Summe=new BigInteger("0");
      boolean palindrom=false;
      boolean uberfluss=false;
        boolean keinuberfluss=false;
      
      do {
      //System.out.println(N);
      Variable=N;
      Summe=reverse(Variable);
      Variable2=N;
      do {
        durchfuehrung++;     
          //System.out.println("Summe "+Summe+" = Variable "+Variable+" + S "+S);
          Summe=Variable.add(Summe);
                  
          VariableS=Summe;
          Rest=BigInteger.ZERO;
          S=BigInteger.ZERO;
           while (VariableS!=BigInteger.ZERO) 
           { 
            Rest=VariableS.mod(BigInteger.TEN);
             S= S.multiply(BigInteger.TEN).add(Rest);  
            VariableS=VariableS.divide(BigInteger.TEN);  
           } 
           if (S.compareTo(Summe)==0) 
           {

            //System.out.println(N+" Ist ein Polinom");
           palindrom=true;
          Variable=S;
           } 
           else 
           {
          Variable=S;
          //System.out.println("Summe "+Summe+" VariableS "+VariableS+" S "+S+ " Rest "+Rest);
         } 
      } while (Summe.compareTo(Variable)!=0 && uberfluss==false && durchfuehrung<100); // end of do-while
            if (durchfuehrung>=99) {
        //System.out.println(N);
      } // end of if
        if (Summe.compareTo(BigInteger.valueOf(Long.MAX_VALUE))>0 && durchfuehrung<99) {
            keinuberfluss=false;
            System.out.println(N+" braucht "+ durchfuehrung+" Iterationen bis zum Palindrom " +Summe+" …… "+S);
            System.exit(0);
          } 
          if (durchfuehrung>99) {
            keinuberfluss=true;
           //  System.out.println("test"+N+" braucht "+ durchfuehrung+" Iterationen bis zum Palindrom " +Summe+" …… "+S);
          //  break;
          } // end of if
      palindrom=false;
      uberfluss=false;
      N=N.add(BigInteger.ONE);

      durchfuehrung=0;

    } while (N.compareTo(BigInteger.valueOf(Abbruch))<=0); // end of do-while (N<Abbruch)
                  if (keinuberfluss=true) {
            System.out.println("alle Zahlen werden auch durch Abbruch per Ueberlauf gefunden");
          } // end of if
    } 
    }
    else {
    long M=1;
    
     if (args.length==0) 
    {
      System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
    } 
    else 
    {
      Abbruch=Long.parseLong(args[0]);
    } 
    long durchfuehrung=0;  
    long Variable=M;
    long Variable2=0;
    long VariableS=0;
    long Rest=0;
    long R=0;
    long S=0;
    long Summe=0;
    boolean palindrom=false;
    boolean uberfluss=false;
    do {
      //System.out.println(N);
      Variable=M;
      Summe=reverse(Variable);
      Variable2=M;
      do {
        durchfuehrung++;     
          //System.out.println("Summe "+Summe+" = Variable "+Variable+" + S "+S);
          //Summe=Variable+Summe;
          if ((Summe=Variable+Summe)<Variable) {
          
          uberfluss=true;  
          System.out.println(M);
          } else {
            
          } // end of if-else
          VariableS=Summe;
          R=0;
          Rest=0;
          S=0;
           while (VariableS>0) 
           { 
            Rest=VariableS %10;
             S= S*10 + Rest;  
            VariableS=VariableS/10;  
           } 
        if (S<0) {
          //System.out.println("SSSSSSSSSSSSSSSS"+S);
          uberfluss=true;
          System.out.println(M);
        } // end of if
           if (S==Summe) 
           {
            //System.out.println(N+" Ist ein Polinom");
           palindrom=true;
          Variable=S;
           } 
           else 
           {
          Variable=S;
          //System.out.println("Summe "+Summe+" VariableS "+VariableS+" S "+S+ " Rest "+Rest);
         } 
      } while (Summe!=Variable && uberfluss==false); // end of do-while
      palindrom=false;
      uberfluss=false;
      M++;
    } while (M<=Abbruch); // end of do-while (N<Abbruch) 
    }

     
    }
  
      private static long reverse(long input){
    long R=0;
    long Rest=0;
       while (input>0) 
          {  
            Rest = input % 10;         
            R= R * 10 + Rest;         
            input = input/10;
          } 
       return R;
      }
  
    private static BigInteger reverse(BigInteger input){
    BigInteger R=new BigInteger("0");
    BigInteger Rest=new BigInteger("0");
       while (input!=BigInteger.ZERO) 
          {  
            Rest = input.mod(BigInteger.TEN);         
            R= R.multiply(BigInteger.TEN).add(Rest);         
            input = input.divide(BigInteger.TEN);
          } 
       return R;
      }
      //System.out.println("N "+N+" R "+R+" Variable "+Variable+ " Summe "+Summe);
  }
