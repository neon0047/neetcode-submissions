class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, 1, word)) return true;;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int i, int j, int idx, String word){
        if(idx == word.length()){
            return true;
        }
        char c = board[i][j];
        board[i][j] = ' ';
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d: dir){
            int newI = i + d[0], newJ = j + d[1];
            if(newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length && board[newI][newJ] == word.charAt(idx)){
                if(dfs(board, newI, newJ, idx+1, word)) return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}
