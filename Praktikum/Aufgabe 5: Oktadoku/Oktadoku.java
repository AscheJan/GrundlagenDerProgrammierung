import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Angelique Anders, Jan Asche
 *
 */
class Oktadoku {
	public enum Variante { normal, mitDiagonalen };
	private Variante v;
	private char [][]felde=new char[8][8];
	int zahler2=0;

	public Oktadoku(Variante var)  {  
		v=var;  
	}
	public void read()   {
		String leser;
		int zahler=0;
		Scanner feld= new Scanner(System.in);
		while (feld.hasNextLine()) {
			leser = feld.nextLine();
			if (leser==""|| leser==" "||leser.length()==0) {
				break;
			}
			leser= leser.replaceAll("[^1-8]", "0");
			char [] numberos=leser.toCharArray();
			for(int spalte=0;spalte<8;spalte++) {
				felde[zahler][spalte]=numberos[spalte];
			}
			zahler++;
		}
		feld.close();
		zahler=0;
	}
	public void write()  {  
		if(v==Variante.mitDiagonalen) {
			System.out.println("Oktadoku mit Diagonalen");
		}else {
			System.out.println("Oktadoku");
		}
		int zahler=0;
		char[][] bereich = {
				{ '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+','-', '-', '-', '-', '-', '+'},
				{ '|', ' ', felde[0][0], ' ', felde[0][1], ' ', '|', ' ', felde[0][2], ' ', felde[0][3], ' ', '|', ' ', felde[0][4], ' ', felde[0][5], ' ', '|',' ', felde[0][6], ' ', felde[0][7], ' ', '|' },
				{ '|', ' ', felde[1][0], ' ', felde[1][1], ' ', '|', ' ', felde[1][2], ' ', felde[1][3], ' ', '|', ' ', felde[1][4], ' ', felde[1][5], ' ', '|',' ', felde[1][6], ' ', felde[1][7], ' ', '|' },
				{ '|', ' ', felde[2][0], ' ', felde[2][1], ' ', '|', ' ', felde[2][2], ' ', felde[2][3], ' ', '|', ' ', felde[2][4], ' ', felde[2][5], ' ', '|',' ', felde[2][6], ' ', felde[2][7], ' ', '|' },
				{ '|', ' ', felde[3][0], ' ', felde[3][1], ' ', '|', ' ', felde[3][2], ' ', felde[3][3], ' ', '|', ' ', felde[3][4], ' ', felde[3][5], ' ', '|',' ', felde[3][6], ' ', felde[3][7], ' ', '|' },
				{ '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+','-', '-', '-', '-', '-', '+' },
				{ '|', ' ', felde[4][0], ' ', felde[4][1], ' ', '|', ' ', felde[4][2], ' ', felde[4][3], ' ', '|', ' ', felde[4][4], ' ', felde[4][5], ' ', '|',' ', felde[4][6], ' ', felde[4][7], ' ', '|' },
				{ '|', ' ', felde[5][0], ' ', felde[5][1], ' ', '|', ' ', felde[5][2], ' ', felde[5][3], ' ', '|', ' ', felde[5][4], ' ', felde[5][5], ' ', '|',' ', felde[5][6], ' ', felde[5][7], ' ', '|' },
				{ '|', ' ', felde[6][0], ' ', felde[6][1], ' ', '|', ' ', felde[6][2], ' ', felde[6][3], ' ', '|', ' ', felde[6][4], ' ', felde[6][5], ' ', '|',' ', felde[6][6], ' ', felde[6][7], ' ', '|' },
				{ '|', ' ', felde[7][0], ' ', felde[7][1], ' ', '|', ' ', felde[7][2], ' ', felde[7][3], ' ', '|', ' ', felde[7][4], ' ', felde[7][5], ' ', '|',' ', felde[7][6], ' ', felde[7][7], ' ', '|' },
				{ '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+', '-', '-', '-', '-', '-', '+','-', '-', '-', '-', '-', '+'},
		};
		while(zahler<bereich.length) {
			for (int spalte=0;spalte<25;spalte++) {
				if(bereich[zahler][spalte]==48) {
					System.out.print(" ");
				}
				else {
					System.out.print(bereich[zahler][spalte]);}
			}
			zahler++;
			System.out.println();
		}
	}		
	public boolean check()         {  
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				for (int a = x+1; a < 8; a++) {
					if (felde[y][x]!=48&&felde[y][x] == felde[y][a]) {
						return false;
					}
				}
				for (int b = y+1; b <7; b++) {
					if (felde[y][x]!=48&&felde[y][x] == felde[b][x]) {
						return false;
					}
				}
				if (v==Variante.mitDiagonalen) {
					for(int b=y+1,a=x+1;b<7&&a<7;b++,a++) {
							if(felde[y][x]!=48&&y<7 && x<7 && y==x && felde[y][x]==felde[b][a]) {
								return false;
							}
					}
					for (int c=y-1,d=x+1;c>=0&&d<7;c--,d++) {
							if (felde[y][x] != 48 &&y==7-x && x < 7
									&& felde[y][x] == felde[c][d]) {
								return false;
							} 
					}
				}
			}
		}
		return true;
	}
	public void solve() 	         {  
		boolean losung=false;
		char [][] felde2= new char[8][8];
		for (int y = 0; y < felde2.length; y++) {
			for (int x = 0; x < felde2.length; x++) {
				felde2[y][x]=felde[y][x];
			}
		}
		losung=loeser2(felde2);
		if(losung==false) {
			System.out.println("nicht loesbar :-(");
		}
	}

	private boolean loeser2(char [][]felder) {

		for (int y=0;y<8;y++) {
			for (int x=0;x<8;x++) {
				if (felder[y][x]==48) {
					for (char zahler=49; zahler<57;zahler++) {
						felder[y][x]=zahler;
						if(v==Variante.mitDiagonalen) {
							if(block(felder, zahler, y, x) && 
									reihe(felder, zahler, y, x) &&
									zeile(felder, zahler, y, x) &&
									diagonal(felder, zahler, y, x)&&
									loeser2(felder)){
								return true;
							}
						}
						else if (block(felder, zahler, y, x) && 
								reihe(felder, zahler, y, x) &&
								zeile(felder, zahler, y, x) &&
								loeser2(felder)){
							return true;
						}
						felder[y][x]=48;
					}
					return false;
				}
			}
		}
		//		for (int i = 0; i < felder.length; i++) {
		//			System.out.println(Arrays.toString(felder[i]));
		//		}
		//		System.out.println();
		for (int y = 0; y < felder.length; y++) {
			for (int x = 0; x < felder.length; x++) {
				felde[y][x]=felder[y][x];
			}
		}
		write();
		return true;

	}
	public boolean diagonal(char[][]felde2, char zahler,int y,int x) {
		for(int b=0,a=0;b<=7&&a<=7;b++,a++) {
			if(felde2[y][x]!=48&&b!=y&&a!=x&&y<7 && x<7 && y==x && felde2[y][x]==felde2[b][a]) {
				return false;
			}
	}
	for (int c=7,d=0;c>=0&&d<=7;c--,d++) {
			if (felde2[y][x] != 48 &&d!=x&&c!=y&&y==7-x && x < 7
					&& felde2[y][x] == felde2[c][d]) {
				return false;
			} 
	}
		return true;
	}
	public boolean block(char [][]felde2,char zahler,int y,int x) {
		if(x%2==0) {
			if (y<4) {
				for(int a=0;a<4;a++) {
					if(a!=y&&felde2[a][x]==zahler) {
						return false;
					}
					if (felde2[a][x+1]==zahler) {
						return false;
					}
				}
			}
			else{
				for(int a=4;a<8;a++) {
					if(a!=y&&felde2[a][x]==zahler) {
						return false;
					}
					if (felde2[a][x+1]==zahler) {
						return false;
					}
				}
			}
		}
		else {
			if (y<4) {
				for(int a=0;a<4;a++) {
					if(a!=y&&felde2[a][x]==zahler) {
						return false;
					}
					if (felde2[a][x-1]==zahler) {
						return false;
					}
				}
			}
			else{
				for(int a=4;a<8;a++) {
					if(a!=y&&felde2[a][x]==zahler) {
						return false;
					}
					if (felde2[a][x-1]==zahler) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public boolean reihe(char [][]felde2,char zahler,int y,int x) {
		for (int a = 0; a < 8; a++) {
			if (a!=y && felde2[a][x]!=48&&felde2[a][x] == zahler) {
				return false;
			}
		}
		return true;
	}
	public boolean zeile(char [][]felde2,char zahler,int y,int x) {
		for (int b = 0; b < 8; b++) {
			if (b!=x&&felde2[y][b]!=48&&felde2[y][b] == zahler) {
				return false;
			}
		}
		return true;
	}
}


