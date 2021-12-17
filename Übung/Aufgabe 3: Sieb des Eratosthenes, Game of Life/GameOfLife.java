import gdp.stdlib.*;

public class GameOfLife {

	public static void main(String[] args) {
		//Eingabe Parameter einlesen
		double spalten = StdIn.readInt();
		double zeilen = StdIn.readInt();
		double startzellen = StdIn.readInt();
		double xwert;
		double ywert;
		
		xwert = 1 / spalten;
		ywert = 1 / zeilen;
		
		
		if (spalten > zeilen) {
			StdDraw.setCanvasSize((int) (500), (int) (500 * (zeilen / spalten)));
		}
		else {
			StdDraw.setCanvasSize((int) (500 * (spalten / zeilen)), (int) 500);
		}
		
		//zellenfeld init.
		boolean[][] zellenfeld = new boolean[(int) zeilen][(int) spalten];
		for (int i = 0; i < zeilen; i++) {
			for (int k = 0; k < spalten; k++) {
				zellenfeld[i][k] = false;
			}
		}
		
		//startzellen von config einlesen
		for (int Zellen = 0; Zellen < startzellen; Zellen++) {
			int x = StdIn.readInt();
			int y = StdIn.readInt();
			zellenfeld[y][x] = true;
		}
		

		while (true) {
			//zeilen einzeichnen
			for (int zeilend = 0; zeilend < zeilen + 1; zeilend ++) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.line(0, ywert*zeilend, 1, ywert*zeilend);
			}
			
			//spalten einzeichnen
			for (int spaltend = 0; spaltend < spalten + 1; spaltend++) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.line(xwert*spaltend, 0, xwert*spaltend, 1);
			}
			
			double[] xZellenPos = {0, 0, 0, 0};
			double[] yZellenPos = {0, 0, 0, 0};
			
			//zellen einzeichnen
			for (int zeilend = 0; zeilend < zeilen; zeilend++) {
				for (int spaltend = 0; spaltend < spalten; spaltend++) {
					xZellenPos[0] = xwert * spaltend + 0.9 * xwert;
					xZellenPos[1] = xwert * (spaltend + 1) - 0.9 * xwert;
					xZellenPos[2] = xwert * (spaltend + 1) - 0.9 * xwert;
					xZellenPos[3] = xwert * spaltend + 0.9 * xwert;
					
					
					yZellenPos[0] = ywert * zeilend + 0.9 * ywert;
					yZellenPos[1] = ywert * zeilend + 0.9 * ywert;
					yZellenPos[2] = ywert * (zeilend + 1) - 0.9 * ywert;
					yZellenPos[3] = ywert * (zeilend + 1) - 0.9 * ywert;
					if (zellenfeld[zeilend][spaltend] == true) {
						StdDraw.setPenColor(StdDraw.GREEN);
						StdDraw.filledPolygon(xZellenPos, yZellenPos);
					}
					else {
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledPolygon(xZellenPos, yZellenPos);
					}
				}
			}
			StdDraw.show(200);
			
			
			//nachbarn init.
			int[][] nachbarn = new int[(int) zeilen][(int) spalten];
			
			//Berechnung der nachbarzellen
			for (int zeilend = 0; zeilend < zeilen; zeilend++) {
				for (int spaltend = 0; spaltend < spalten; spaltend++) {
					for (int xnachbar = -1; xnachbar <= 1; xnachbar++) {
						for (int ynachbar = -1; ynachbar <= 1; ynachbar++) {
							int x = spaltend + xnachbar;
							int y = zeilend + ynachbar;
							if (x < 0) {
								x = (int) spalten - 1;
							}
							if (y < 0) {
								y = (int) zeilen - 1;
							}
							
							if (x > spalten - 1) {
								x = 0;
							}
							if (y > zeilen - 1) {
								y = 0;
							}
							
							
							if (zellenfeld[y][x] == true && !(xnachbar == 0 && ynachbar == 0)) {
								nachbarn[zeilend][spaltend]++;
							}
						}
					}
				}
			}
			
			//nächsten zustand berechnen
			for (int zeilend = 0; zeilend < zeilen; zeilend++) {
				for (int spaltend = 0; spaltend < spalten; spaltend++) {
					if (zellenfeld[zeilend][spaltend] == false && nachbarn[zeilend][spaltend] == 3) {
						zellenfeld[zeilend][spaltend] = true;
					}
					else {
						boolean a = (nachbarn[zeilend][spaltend] == 2 | nachbarn[zeilend][spaltend] == 3);
						if (zellenfeld[zeilend][spaltend] == true && a) {
							zellenfeld[zeilend][spaltend] = true;
						}
						else {
							boolean b = (nachbarn[zeilend][spaltend] < 2 | nachbarn[zeilend][spaltend] > 3);
							if (zellenfeld[zeilend][spaltend] == true && b) {
								zellenfeld[zeilend][spaltend] = false;
							}
							else {
								if (zellenfeld[zeilend][spaltend] == false && (nachbarn[zeilend][spaltend] != 3)) {
									zellenfeld[zeilend][spaltend] = false;
								}
							}
						}
					}
					
				}
			
			}
			nachbarn = new int[(int) zeilen][(int) spalten];
		}
		
	}
}
