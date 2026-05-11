class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Brute force
        //Rows
        for(int i=0; i<board[0].length; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j=0; j<board.length; j++) {
                char val = board[i][j];
                if(val == '.')
            		continue;
                
                if(set.contains(val)) 
                    return false;
                
                set.add(val);
            }
        }

        //Columns
        for(int i=0; i<board[0].length; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j=0; j<board.length; j++) {
                char val = board[j][i];
                if(val == '.')
            		continue;
			
                if(set.contains(val))
                    return false;
                
                set.add(val);
            }
        }

        //Squares
        for(int row=0; row<board[0].length; row += 3) {
            for(int col=0; col<board.length; col += 3) {
                HashSet<Character> set = new HashSet<>();
                for(int i=0; i<3; i++) {
                    for(int j=0; j<3; j++) {
                        char val = board[row+i][col+j];
                        if(val == '.')
                            continue;
                    
                        if(set.contains(val))
                            return false;
                        
                        set.add(val);
                    }
                }
            }
        }
        return true;
    }
}
