class Solution {
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    area = 0;
                    calculate(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    public void calculate(int[][] grid, int i, int j){
        area++;
        grid[i][j] = -1;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d: dir){
            int newI = i + d[0], newJ = j + d[1];
            if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid[0].length && grid[newI][newJ] == 1){
                calculate(grid, newI, newJ);
            }
        }
    }
}
