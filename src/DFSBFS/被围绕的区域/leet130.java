package Leet.DFSBFS.被围绕的区域;

public class leet130 {
    /*
     * 被围绕的区域
     */
    //DFS
    //步骤：
//           [[1,1,0],
//            [1,1,0],
//            [0,0,1]]
//    visited:[1,1,0]

    public void solve(char[][] board) {
        if(board.length==0)return;
        for (int i = 0; i < board[0].length; i++) {
            if(board[0][i]=='O'){
                change(board,0,i);
            }
            if(board[board.length-1][i]=='O'){
                change(board,board.length-1,i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][0]=='O'){
                change(board,i,0);
            }
            if(board[i][board[0].length-1]=='O'){
                change(board,i,(board[0].length)-1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if(board[i][i1]=='O'){
                    board[i][i1]='X';
                }
                if(board[i][i1]=='-'){
                    board[i][i1]='O';
                }
            }
        }
    }
    public static void change(char[][] board,int i,int j){
        //i=1
        //。。。记得j是和array[0].length比
        if( i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='X'||board[i][j]=='-'){
            return;
        }
        board[i][j]='-';
        change(board,i+1,j);
        change(board,i-1,j);
        change(board,i,j+1);
        change(board,i,j-1);
    }

//    [["-","-",'X','X'],
//     ['X','X','O','X'],
//     ['X','X','O','X'],
//     ['X',"-",'X','X']]

    //输入
    //[['X','O','X','O','X','O'],
    // ['O','X','O','X','O','X'],
    // ['X','O','X','O','X','O'],
    // ['O','X','O','X','O','X']]
    //我的输出
    // [['X','O','X','O','X','X']
    // ['O','X','X','X','X','X']
    // ['X','X','X','X','X','X']
    // ['O','X','O','X','X','X']]

}
