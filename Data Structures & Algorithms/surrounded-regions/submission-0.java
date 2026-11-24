class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i<n; i++){
            if(board[i][0] == 'O') q.offer(new int[]{i, 0});
            if(board[i][m-1] == 'O') q.offer(new int[]{i, m-1});
        }
        for(int j = 0; j<m; j++){
            if(board[0][j] == 'O') q.offer(new int[]{0, j});
            if(board[n-1][j] == 'O') q.offer(new int[]{n-1, j});
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0, -1}};
        while(!q.isEmpty()){
            int[] coord = q.poll();
            board[coord[0]][coord[1]] = 'Z';
            for(int[] d: dir){
                int newX = coord[0] + d[0], newY = coord[1] + d[1];
                if(newX>=0 && newX<n && newY>=0 && newY<m && board[newX][newY] == 'O'){
                    board[newX][newY] = 'Z';
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'Z') board[i][j] = 'O';
            }
        }
        
    }
}
