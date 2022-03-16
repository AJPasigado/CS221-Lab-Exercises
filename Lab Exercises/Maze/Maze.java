/**
 * Maze
 * Anton John B. Pasigado
 * 09/04/2016
 * References: None
 */
 
 import java.util.Stack;
 
 public class Maze {
    public static void main (String[]args){
        int[][] path =  {   {0, 1, 0, 0, 1, 1, 1, 1},               //matrix; 3=exit; 2=mouse; 1=walls; 0=path
                            {0, 0, 1, 0, 0, 0, 0, 1},
                            {1, 1, 0, 0, 1, 1, 1, 1},
                            {0, 2, 1, 1, 1, 1, 1, 1},
                            {1, 0, 0, 3, 1, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1}
                        } ;
        findPath(path);
    }
    public static void findPath(int[][] maze){                      //With implimentation RLSN
        Stack<Integer> moves = new Stack<Integer>();                //Stores x-coordinates in even numbered position; y-coordinates in odd numbers
        Stack<Integer> Path = new Stack<Integer>();
        
        int[] Position = Coordinates(maze, 2);
        moves.push(Position[1]);                                    
        moves.push(Position[0]);
        boolean solved = false;
        
        while(solved == false){
            while (availableMove(maze, Position[0], Position[1])=="Path"){
                if ((Position[1]+1)<maze[0].length){
                    if (maze[Position[0]][Position[1]+1] == 0){                     //Checks right side
                        moves.push(Position[1]+1);                                  
                        moves.push(Position[0]);
                    }
                }
                if ((Position[1]-1)>=0){
                    if (maze[Position[0]][Position[1]-1] == 0){                     //Checks left side
                        moves.push(Position[1]-1);                                  
                        moves.push(Position[0]);
                    }
                }
                if ((Position[0]+1)<maze.length){
                    if (maze[Position[0]+1][Position[1]] == 0){                     //Checks south side
                        moves.push(Position[1]);                                    
                        moves.push(Position[0]+1);
                    }
                }
                if ((Position[0]-1)>0){
                    if (maze[Position[0]-1][Position[1]] == 0){                     //Checks North side
                        moves.push(Position[1]);                                    
                        moves.push(Position[0]-1);
                    }
                }
                Position[0] = moves.pop();
                Position[1] = moves.pop();
                Path.push(Position[1]);
                Path.push(Position[0]);
                maze[Position[0]][Position[1]] = 3;                             //Mark current to 4 for "visited"
            } 
            if (availableMove(maze, Position[0], Position[1])== "Exit"){
                if ((Position[1]+1)<maze[0].length){
                    if (maze[Position[0]][Position[1]+1] == 3){                     //Checks right side
                        solved = true;
                    }
                }
                if ((Position[1]-1)>0){
                    if (maze[Position[0]][Position[1]-1] == 3){                     //Checks left side
                        solved = true;
                    }
                }
                if ((Position[0]+1)<maze.length){
                    if (maze[Position[0]+1][Position[1]] == 3){                     //Checks south side
                        solved = true;
                    }
                }
                if ((Position[0]-1)>0){
                    if (maze[Position[0]-1][Position[1]] == 3){                     //Checks North side
                        solved = true;
                    }
                }
            } 
            while (availableMove(maze, Position[0], Position[1])== "None"){
                int x = moves.pop(), y = moves.pop();
                int a = 0, b=0;
                while(a != x && b != y){                               //removes the wrong paths
                    a = Path.pop();
                    b = Path.pop();
                }
                Position[0] = a;
                Position[1] = b;
                Path.push(Position[1]);
                Path.push(Position[0]);
            }
        }
        printMaze(maze, Path);
    }
    
    public static int[] Coordinates (int[][] maze, int what){
        int[] coordinates = new int[2];                                         //finds the coordinates of something in the maze
        for (int i=0; i<maze.length; i++){
            for (int j=0; j<maze[0].length; j++){
                if (maze[i][j]==what){
                    coordinates[0] = i;
                    coordinates[1] = j;
                }       
            }
        }
        return coordinates;
    }
    
    public static String availableMove (int[][] maze, int xC, int yC){
        String state = "";
        
        if (yC+1>=maze[0].length) {
            if (maze[xC][yC-1] == 3 ||
                maze[xC+1][yC] == 3 ||
                maze[xC-1][yC] == 3 ){                      
                state = "Exit";
            } else  
            if (maze[xC][yC-1] == 0 ||
                maze[xC+1][yC] == 0 ||
                maze[xC-1][yC] == 0 ){                      
                state = "Path";
            } else  
            if (maze[xC][yC-1] == 1 ||
                maze[xC+1][yC] == 1 ||
                maze[xC-1][yC] == 1 ||
                maze[xC][yC-1] == 4 ||
                maze[xC+1][yC] == 4 ||
                maze[xC-1][yC] == 4 ){                      
                state = "None";
            }
        } else 
        if (yC-1<0){
            if (maze[xC][yC+1] == 3 || 
                maze[xC+1][yC] == 3 ||
                maze[xC-1][yC] == 3 ){                      
                state = "Exit";
            } else  
            if (maze[xC][yC+1] == 0 || 
                maze[xC+1][yC] == 0 ||
                maze[xC-1][yC] == 0 ){                      
                state = "Path";
            } else  
            if (maze[xC][yC+1] == 1 ||
                maze[xC+1][yC] == 1 ||
                maze[xC-1][yC] == 1 ||
                maze[xC][yC+1] == 4 || 
                maze[xC+1][yC] == 4 ||
                maze[xC-1][yC] == 4 ){                      
                state = "None";
            }
        }else 
        if (xC+1>=maze.length){
            if (maze[xC][yC+1] == 3 || 
                maze[xC][yC-1] == 3 ||
                maze[xC-1][yC] == 3 ){                      
                state = "Exit";
            } else  
            if (maze[xC][yC+1] == 0 || 
                maze[xC][yC-1] == 0 ||
                maze[xC-1][yC] == 0 ){                      
                state = "Path";
            } else  
            if (maze[xC][yC+1] == 1 || 
                maze[xC][yC-1] == 1 ||
                maze[xC-1][yC] == 1 ||
                maze[xC][yC+1] == 4 || 
                maze[xC][yC-1] == 4 ||
                maze[xC-1][yC] == 4 ){                      
                state = "None";
            }
        } else
        if (xC-1<0){
            if (maze[xC][yC+1] == 3 || 
                maze[xC][yC-1] == 3 ||
                maze[xC+1][yC] == 3 ){                      
                state = "Exit";
            } else  
            if (maze[xC][yC+1] == 0 || 
                maze[xC][yC-1] == 0 ||
                maze[xC+1][yC] == 0 ){                      
                state = "Path";
            } else  
            if (maze[xC][yC+1] == 1 || 
                maze[xC][yC-1] == 1 ||
                maze[xC+1][yC] == 1 ||
                maze[xC][yC+1] == 4 || 
                maze[xC][yC-1] == 4 ||
                maze[xC+1][yC] == 4 ){                      
                state = "None";
            }
        } else 
            if (maze[xC][yC+1] == 3 || 
                maze[xC][yC-1] == 3 ||
                maze[xC+1][yC] == 3 ||
                maze[xC-1][yC] == 3 ){                      
                state = "Exit";
            } else  
            if (maze[xC][yC+1] == 0 || 
                maze[xC][yC-1] == 0 ||
                maze[xC+1][yC] == 0 ||
                maze[xC-1][yC] == 0 ){                      
                state = "Path";
            } else  
            if (maze[xC][yC+1] == 1 || 
                maze[xC][yC-1] == 1 ||
                maze[xC+1][yC] == 1 ||
                maze[xC-1][yC] == 1 ||
                maze[xC][yC+1] == 4 || 
                maze[xC][yC-1] == 4 ||
                maze[xC+1][yC] == 4 ||
                maze[xC-1][yC] == 4 ){                      
                state = "None";
            }
         return state;
        }
        
    public static void printMaze(int[][] maze, Stack path){
        String[][] board = new String[maze.length][maze[0].length];
        System.out.println ("The mouse found a way!");
        System.out.println();  
        
        for (int i=0; i<maze.length; i++){
            for (int j=0; j<maze[0].length; j++){
                 if (maze[i][j] == 1) board[i][j]="|";
                 else if (maze[i][j] == 2) board[i][j]="*";
                 else if (maze[i][j] == 3) board[i][j]="*";
                 else board[i][j] = "|";
            }       
        }
        int size = path.size()/2;
        for (int k=0; k<size;k++){
            int iS = path.pop().hashCode(); 
            int jS = path.pop().hashCode();
            board[iS][jS] = "*";
        }
        
        for (int i=0; i<maze.length; i++){
            for (int j=0; j<maze[0].length; j++){
                    System.out.print (board[i][j] + " ");
            }
            System.out.println();       
        }
    }
}