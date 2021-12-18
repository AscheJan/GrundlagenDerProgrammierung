/**
 * 
 * @author Angelique Anders, Jan Asche
 *
 */
import gdp.stdlib.StdDraw;

public class MazeSolver {
  public static boolean solve(int[][] maze, int row, int col) {

  //  int[][] tester= new int[maze.length][maze.length];
    boolean ziel=false;
  //  tester[maze.length-1][0]=2;
    //tester[0][maze.length-1]=2;
    while(ziel!=true) {
      if ( !(col-1<0) && maze[row][col-1]!=0 &&maze[row][col-1]!=6) {
        col-=1;
        if(maze[row][col]==3) {
          ziel=true;
        }
        maze[row][col]=9;
      }
      else if(!(row+1>maze.length-1) && maze[row+1][col]!=0 &&maze[row+1][col]!=6) {
        row+=1;
        if(maze[row][col]==3) {
          ziel=true;
        }
        maze[row][col]=9;
      }
      else {
        maze[row][col]=6;
        if ( !(col+1>maze.length-1) && maze[row][col+1]!=0 && maze[row][col+1]!=6 && maze[row][col+1]==9) {
          col+=1;
          if(maze[row][col]==3) {
            ziel=true;
          }
          maze[row][col]=9;
        }
        else if(!(row-1<0) && maze[row-1][col]!=0 &&maze[row-1][col]!=6&&maze[row-1][col]==9) {
          row-=1;
          if(maze[row][col]==3) {
            ziel=true;
          }
          maze[row][col]=9;
        }
        else {
          return false;
        }
      }
    } 
    for(int i=0;i<=maze.length-1;i++) {
      for (int j=0; j<=maze.length-1;j++) {
        if (maze[i][j]==6) {
          maze [i][j]=1;
        }
        if (maze [i][j]==9) {
          maze [i][j]=2;
        }
      }
    }
    draw(maze);
    return ziel;

  }

  public static void draw(int[][] maze) {
    int x = maze.length;
    int y = maze.length;
    StdDraw.setXscale(0, maze.length);
    StdDraw.setYscale(0, maze.length);
    for (int j = maze.length-1; j >= 0; j--) {
      for (int i = 0; i < maze.length; i++) {
        if(maze[i][j] == 0) {
          StdDraw.setPenColor(StdDraw.GRAY);
        }
        else if(maze[i][j] == 2) {
          StdDraw.setPenColor(StdDraw.GREEN);
        }
        else if(maze[i][j] == 3) {
          StdDraw.setPenColor(StdDraw.BLUE);
        }
        else if(maze[i][j] == 1) {
          StdDraw.setPenColor(StdDraw.WHITE);
        }
        else if(maze[i][j] == 9) {
          StdDraw.setPenColor(StdDraw.RED);
        }
        else if(maze[i][j] == 6) {
          StdDraw.setPenColor(StdDraw.BLACK);
        }
        StdDraw.filledSquare(j + 0.5, maze.length-1-i+ 0.5, 0.49);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0.0, j, x, j);
        StdDraw.line(i, 0.0, i, y);
      }
    }
    StdDraw.line(0.0, maze.length, x, maze.length);
    StdDraw.line(maze.length, 0.0, maze.length, y);
  }
}
