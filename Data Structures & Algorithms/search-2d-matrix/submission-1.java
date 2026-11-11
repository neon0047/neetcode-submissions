class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m*n - 1;
        while(left<=right){
            int midIndex = (left+right)/2;
            int r = midIndex/m, c = midIndex%m;
            if(matrix[r][c] == target) return true;
            else if (matrix[r][c]>target){
                right = midIndex-1;
            }else{
                left = midIndex+1;
            }
        }
        return false;
        
    }
}
