/**
 * NQueens
 * Anton John B. Pasigado
 * 09/04/2016
 * References: None
 */
 
 import java.util.Stack;
 
 public class NQueens {
    public static void main (String[]args){
        int BoardSize = 16;
        findPositions(BoardSize);
    }   
        
    public static void findPositions (int BoardSize){
        int[][] board = new int[BoardSize][BoardSize];
        Stack<Integer> moves = new Stack<Integer>();
        int xC = 0, yC = 0;
            
        while (yC != board.length){
            boolean flag = false;
            for (int i=0; i<board.length; i++){
                if (yC<board.length && isClear(board, i, yC)=="CL"){
                    moves.push(yC);
                    moves.push(i);
                    flag = true;
                }
            }
            int c = yC;
            xC=moves.pop(); yC = moves.pop();
            if (flag){
                if (isClear(board, xC, yC)=="CL"){
                    board[xC][yC]=1;
                }
                yC++; xC=0;
            } else{ 
                for (int y=c; y>=yC; y--){
                    for (int x = 0; x<board.length; x++){
                        board[x][y]=0;
                    }
                }
                if (isClear(board, xC, yC)=="CL"){
                    board[xC][yC]=1;
                    yC++; xC=0;
                }
             }
        }
        printBoard(board);
    }
    
    public static String isClear (int[][] board, int xC, int yC){
        String ret = "CL";
        for (int i=0,  x = xC; i< board[0].length; i++){                    //Vertical
            if (x+i >=board[0].length) x = (x+i)-board.length;
            else x= x+i;
            if (board[x][yC]==1) ret = "CQ";
        }
        for (int i=0, y= yC; i<board.length; i++){                          //Horizontal
            if (y+i >=board.length) y = (y+i)-board.length;
            else y= y+i;
            if (board[xC][y]==1) ret = "RQ";
        }
        int x = xC, y=yC;                                                   //South-East 
        while (x < board.length && y < board.length){
            if (board[x++][y++]==1) ret = "DQ";
        }
        x = xC; y=yC;                                                        //North-West 
        while (x >= 0 && y >= 0){
            if (board[x--][y--]==1) ret = "DQ";
        }
        x = xC; y=yC;                                                        //South-West 
        while (x < board.length && y >= 0){
            if (board[x++][y--]==1) ret = "DQ";
        }
        x = xC; y=yC;                                                        //South-West 
        while (x >= 0 && y < board.length){
            if (board[x--][y++]==1) ret = "DQ";
        }
        return ret;
    }
    
    public static void printBoard(int[][] board){
        String[][] boardy = new String[board.length][board.length];
        
        System.out.println (board.length + " Queens: ");
        System.out.println();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                    if (board[i][j]==0) boardy[i][j]="•";
                    else if (board[i][j]==1) boardy[i][j]="?";
            }    
        }
        
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                    System.out.print (boardy[i][j] + " ");
            }
            System.out.println();       
        }
    }
 }