/*
 * @author: Felix Joshua Golub, Jan Asche, Angelique Anders
 * @version: 5.12
 */

import gdp.stdlib.*;

public class PythagorasTree {

	public static void durchfuhrung (int n,int zaehler,double ax,double ay,double bx,double by) {

		/* 
		 * durchfuhrung-Methode
		 * Uebergabeparameter: zaehler zum zaehlen der Durchlaeufe,vergleichen mit n (Anzahl der Durchlaeufe)
		 *  				   ax,ay,bx,by zum berechnen von dx,dy,cx,cy + für mehrere Durchgaenge geeignet
		 */

		double deltax=bx-ax;  //Laenge von ax zu bx (x-Laenge)
		double deltay=ay-by;  //Laenge von ay zu by (y-Laenge)
		double cx=bx+deltay;  //Berechnung von cx (x-Koordinate von C)
		double cy=by+deltax;  //Berechnung von cy (y-Koordinate von C)
		double dx=ax+deltay;  //Berechnung von dx (x-Koordinate von D)
		double dy=ay+deltax;  //Berechnung von yx (y-Koordinate von D)


		StdDraw.line(ax,ay,bx,by);  //Zeichnung Quadrat
		StdDraw.line(bx,by,cx,cy);
		StdDraw.line(cx,cy,dx,dy);
		StdDraw.line(dx,dy,ax,ay); 


		double random=0; //Parameter random erstellen

		random=30+(30*Math.random());    			//random zwischen 30 und 60
		double alpha=random;					//alpha durch random ersetzen
		double beta= 90-alpha;					//beta berechnen

		double sinalpha=Math.sin(Math.toRadians(alpha));		//sin alpha berechnen			  
		double cosalpha=Math.cos(Math.toRadians(alpha));		//cos alpha berechnen
		double sinbeta=Math.sin(Math.toRadians(beta));			//sin beta berechnen
		double cosbeta=Math.cos(Math.toRadians(beta));			//cos beta berechnen


		if (zaehler==n) {
			return;
		}

				durchfuhrung(n,zaehler+1,dx,dy,(dx+(cosbeta*cosbeta*deltax)+(cosalpha*sinalpha*deltay)), //Uebergabe von Parameter
						(dy+(cosalpha*sinalpha*deltax)-(cosbeta*cosbeta*deltay)));
				durchfuhrung(n,zaehler+1,(dx+(cosbeta*cosbeta*deltax)+(cosalpha*sinalpha*deltay)),
						(dy+(cosalpha*sinalpha*deltax)-(cosbeta*cosbeta*deltay)),cx,cy);

	}

	public static void main(String[] args) { 

		//Main-Methode

		int n=Integer.parseInt(args[0]); // Parameter n einlesen
		int zaehler=0;                   // Zaehler erstellen
		StdDraw.setCanvasSize(800, 800); // Bildgroesse erstellen

		double ax=0.45;
		double ay=0.05;
		double bx=0.55;
		double by=0.05;    // Punkt A und Punkt B definieren (Grundpunkt deshalb statisch)

		durchfuhrung(n,zaehler,ax,ay,bx,by); //neue Methode mit der Durchfuehrung
		/*
		 * In Methode Durchfuehrung wird gezeichnet und die Durchfuehrungen gezaehlt.
		 * Uebergabe der Parameter ax,ay (Werte vom Punkt A) und bx,by (Werte vom Punkt B) zum berechnen der Quadrate.
		 */
	}

}
