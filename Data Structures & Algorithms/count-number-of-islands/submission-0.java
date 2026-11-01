class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    // mark and count
                    mark(grid, i, j);
                    count++;
                }
            }
        }
        for(char[] arr: grid){
            System.out.println(Arrays.toString(arr));
        }
        return count;
    }
    public void mark(char[][] grid, int i, int j){
        grid[i][j] = '2';
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d: dir){
            int newI = i + d[0];
            int newJ = j + d[1];
            if(newI < grid.length && newI>=0 && newJ>=0 && newJ < grid[0].length && grid[newI][newJ] == '1'){
                mark(grid, newI, newJ);
            }

        }
    }
}
