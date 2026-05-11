class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                int boxRowIndex = row / 3;
                int boxColIndex = col / 3;
                int currBox = boxRowIndex * 3 + boxColIndex;

                char currVal = board[row][col];
                if(currVal == '.')  continue;

                if(!rows[row].add(currVal))  return false;

                if(!cols[col].add(currVal))  return false;

                if(!boxes[currBox].add(currVal))  return false;
            }
        }
        return true;
    }
}
