public class Sudoku {

    public static boolean solve(int[][] board, int row, int col)
    {
        if(row == 9)//nothing left to solve
        {
            return true;
        }


            int originalNum = board[row][col];

        if(originalNum !=0)
        {
            if (solve(board, nextRow(row, col), nextCol(col)) == true) {
                return true;
            }
        }

        else
        {
            for (int i = 1; i <= 9; i++) {
                if (valid(row, col, board, i)) {
                    board[row][col] = i;

                    if (solve(board, nextRow(row, col), nextCol(col)) == true) {
                        return true;
                    }
                    board[row][col] = originalNum;
                }
            }
        }




        return false;
    }

    public static int nextRow(int row, int col)
    {
        if(col <=7)
        {
            return row;
        }
        else//we need to go up a row
        {
            return row+1;
        }
    }

    public static int nextCol(int col)
    {
        if(col <=7)
        {
            return col +1;
        }
        else
        {
            return 0;
        }
    }

    public static boolean valid(int row, int col, int[][] board, int num)
    {
        //check row
        for(int col2 = 0; col2 <=8; col2++)//loop through the row its in
        {
            if(board[row][col2] == num && col2!= col)//if the number is in the row already its not valid
            {
                return false;
            }
        }

        //check col
        for(int row2 = 0; row2 <=8; row2++ )//loop through the col its in
        {
            if(board[row2][col] == num && row2 != row)
            {
                return false;
            }
        }

        //check the box

        //integer divide by 3 then multiply by 3 to find top left corner of box
        int boxRow = (row/3)*3;
        int boxCol = (col/3)*3;

        for(int boxRow2 = boxRow; boxRow2<=boxRow+2; boxRow2++)//loop through the rows in the box
        {
            for(int boxCol2 = boxCol; boxCol2 < boxCol +2; boxCol2++)//for every row loop through all cols
            {
                if(board[boxRow2][boxCol2] == num && (boxCol2 != col && boxRow2 != row))//if the num is the same as another in the box
                {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[][] board = {{0,0,0,7,9,0,0,5,0},
                         {3,5,2,0,0,8,0,4,0},
                         {0,0,0,0,0,0,0,8,0},
                         {0,1,0,0,7,0,0,0,4},
                         {6,0,0,3,0,1,0,0,8},
                         {9,0,0,0,8,0,0,1,0},
                         {0,2,0,0,0,0,0,0,0},
                         {0,4,0,5,0,0,8,9,1},
                         {0,8,0,0,3,7,0,0,0}};
        int row = 0;
        int col = 0;
        solve(board, row, col);

        //print the board

        for(int row2 = 0; row2 <=8; row2 ++)//loop through the rows
        {
            for(int col2 = 0; col2 <=8; col2 ++)//loop through the cols
            {
                System.out.print(board[row2][col2] + ",");
            }
            System.out.println("\n");
        }



    }
}
