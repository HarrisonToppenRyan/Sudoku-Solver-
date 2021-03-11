// Name: Harrison Toppen-Ryan and Abigayle Peterson 
// Date: Mar 6th 2021
// Academic Honesty Statement: I affirm that I have not given or received any unauthorized help on this assignment, and that this work is my own. - Abigayle Peterson
// The purpose of this project is to demonstrate understanding the 2d arrays and conditonals
import java.util.*;
 
// Sudoku class 
public class Sudoku {
        // setting if the boeard is solvable, unsolvable, checks 1 & 2, and count spaces
        private static boolean solvable = false;
        private static boolean unsolvable = false;
        private static boolean check1 = false;
        private static boolean check2 = false;
        private static boolean check3 = false;
        private static int countSpace = 0;
 
        // checking the boolean puzzle
        public static boolean check(char[][] puzzle) {
          // creating a 9 x 9 grid for the sudoku puzzle 
          int[][] row = new int[9][9]; 
          int[][] col = new int[9][9];
          int[][][] grid = new int[3][3][9];
          for(int i = 0; i < 9;i++){
              for(int j = 0; j < 9;j++){
                  int num = puzzle[i][j]-49; //convert char to corresponding number
                  if(num < 0) continue;// do nothing if it's "."
                  
                  if(row[i][num] > 0) {
                  
                   return false;
                  } // false, if the row already has the number
              
                  row[i][num]++;
                  
                  if(col[j][num] > 0) {
                  
                    return false;
                  } // false, if the column already has the number
                  
                  col[j][num]++;
                  
                  if(grid[i / 3][j / 3][num] > 0) {
             
                    return false;
                  } // false, if the grid already has the number
                  
                  grid[i / 3][j / 3][num]++;
              }
          }
          // if i gets through all of that codem then all checks are false and returns true 
          // check1 = false;
          // check2 = false;
          // check3 = false;

          // if(!check1 && !check2 && !check3) {
          //   unsolvable = true;
          // }
          return true;
      }
 
// print puzzle method that takes in the unfinished puzzle 
      public static void printPuzzle(char[][] puzzle) {
        // looping though each row and column and printing out the results 
        int row;
        int column;
        for(row = 0; row < 9; row++) {
          for(column = 0; column < 9; column++) {
            System.out.print(puzzle[row][column] + " ");
          }
          System.out.println();
        }
      }

              
 // solve method that takes in puzzle and solve it 
    public static boolean solve(char[][] puzzle) {
        // if check is false then the puzzle is invalid 
            if(!check(puzzle)) {
              System.out.println("The given sudoku puzzle is invalid");
              return false;
              // solve the number if the space is '.' and replace with appropate number 
            } else {
              for (int r = 0; r < puzzle.length; r++) {
                  for (int c = 0; c < puzzle[0].length; c++) {
                    if (puzzle[r][c] == '.') {
                        for (int k = 1; k <= 9; k++) {
                            puzzle[r][c] = (char) ('0' + k);
                            if (check(puzzle) && solve(puzzle)) {
                                solvable = true;
                                return true;
                            
                            } else {
                               
                                puzzle[r][c] = '.';
                            }
                         }
                     
                     return false;
                     }
           
                    solvable = false; // return false;

                
                 }
             }
      

          }
 

          return true;
        }
 
    
 


        public static void main(String[] args) {
                char[][] puzzle = SudokuP.puzzle();
                // test boards 
                char[][] unsolvable = {{'2', '.', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '6', '.'},
                        {'.', '.', '.', '.', '.', '1', '.', '.', '.'},
                        {'5', '.', '2', '6', '.', '.', '4', '.', '7'},
                        {'.', '.', '.', '.', '.', '4', '1', '.', '.'},
                        {'.', '.', '.', '.', '9', '8', '.', '2', '3'},
                        {'.', '.', '.', '.', '.', '3', '.', '8', '.'},
                        {'.', '.', '5', '.', '1', '.', '.', '.', '.'},
                        {'.', '.', '7', '.', '.', '.', '.', '.', '.'}};
 

                char[][] unsolvable2 = {{'6', '.', '.', '.', '.', '8', '9', '4', '.'},
                              {'9', '.', '.', '.', '.', '6', '1', '.', '.'},
                              {'.', '7', '.', '.', '4', '.', '.', '.', '2'},
                              {'2', '.', '5', '6', '3', '.', '.', '.', '.'},
                              {'.', '.', '.', '.', '5', '7', '2', '.', '.'},
                              {'.', '8', '9', '.', '.', '2', '.', '.', '.'},
                              {'.', '.', '.', '.', '6', '.', '.', '.', '5'},
                              {'.', '.', '.', '.', '.', '.', '8', '3', '.'},
                              {'8', '.', '3', '.', '.', '1', '6', '.', '.'}};
         
                char[][] projExample = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

                char[][] test = {{'1', '2', '3', '4', '5', '6', '7', '8', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '2'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '3'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '4'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '5'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '7'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '8'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '9'}};
                      
      if(solve(test)) {
        printPuzzle(test);
      } else if(!solve(test)) { // this does NOT print false for some reason
        System.out.println("The given sudoku puzzle is unsolvable");      
      }

      // if(!solvable) {
      //   System.out.println("yes");
      //  }
    }
}
