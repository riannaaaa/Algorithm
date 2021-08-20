package DFSBFS.单词搜索;

public class leet79 {
    public boolean exist(char[][] board, String word) {
        //试试自己写
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if (board[i][i1] == word.charAt(0)) {
                    int index = 0;
                    res = backtracking1(board, word, i, i1);
                    if(res) return res;
                }
            }
        }
        return res;
    }
    //word "SEE"
    public boolean backtracking1(char[][] board, String word, int i,int j){
        if(word.length()==0)return true;
        if(i< 0 ||j< 0|| i>= board.length|| j>=board[0].length|| board[i][j]!=word.charAt(0)) return false;
        char tmp = board[i][j];
        board[i][j] = '-';
        word=word.substring(1);
        boolean res = backtracking1(board, word, i+1, j)||backtracking1(board, word, i-1, j)||backtracking1(board, word, i, j+1)||backtracking1(board, word, i, j-1);
        board[i][j] = tmp;
        return res;
    }
}
