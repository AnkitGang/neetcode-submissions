class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[10][10];
        int[][] cols = new int[10][10];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++) 
            boxes[i] = new HashSet<>();

        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                int boxRowIndex = row / 3;
                int boxColIndex = col / 3;
                int currBox = boxRowIndex * 3 + boxColIndex;

                char currVal = board[row][col];
                if(currVal == '.')  continue;

                if(rows[row][currVal - '0'] > 0)  return false; //Means on currVal index, same number was already present in some other row
                rows[row][currVal - '0']++;

                if(cols[col][currVal - '0'] > 0)  return false; //Means on currVal index, same number was already present in some other col
                cols[col][currVal - '0']++;

                if(!boxes[currBox].add(currVal))  return false;
            }
        }
        return true;
    }
}
