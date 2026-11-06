class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rot = new LinkedList();
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1 || grid[i][j] == 2) count++;
                if(grid[i][j] == 2){
                    rot.offer(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }
        if(count == 0) return 0;
        int min = -1;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!rot.isEmpty()){
            int s = rot.size();
            min++;
            for(int i = 0; i<s; i++){
                int[] rottenCord = rot.poll();
                count--;
                for(int[] d: dir){
                    int nbrI = rottenCord[0] + d[0];
                    int nbrJ = rottenCord[1] + d[1];
                    if(nbrI>=0 && nbrI<grid.length && nbrJ>=0 && nbrJ<grid[0].length && grid[nbrI][nbrJ] == 1){
                        rot.offer(new int[]{nbrI, nbrJ});
                        grid[nbrI][nbrJ] = 2;
                    }
                }
            }
        }

        return count>0?-1:min;
    }
}
