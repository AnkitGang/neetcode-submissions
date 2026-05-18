class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0; i<rows; i++) {
            int last = matrix[i][cols-1];

            if(last < target) 
                continue;
            
            int left = 0;
            int right = cols-1;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(matrix[i][mid] == target)
                    return true;
                if(matrix[i][mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
