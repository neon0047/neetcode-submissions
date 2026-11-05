class Solution {
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    area = 0;
                    bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    public void bfs(int[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = -1;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int s = q.size();
            for(int k = 0; k<s; k++){
                int[] cell = q.poll();
                area++;
                for(int[] d: dir){
                    int newI = cell[0] + d[0], newJ = cell[1] + d[1];
                if(newI>=0 && newI<grid.length && newJ>=0 &&             newJ<grid[0].length && grid[newI][newJ] == 1){
                    grid[newI][newJ] = -1;
                    q.offer(new int[]{newI, newJ});
                }
                }
            }
        }
        

    }
}
