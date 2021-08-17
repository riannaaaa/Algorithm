package Leet.无分组.重塑矩阵;

public class leet566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        int[][] res= new int[mat.length][mat[0].length];
        int indexR = 0;
        int indexC = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = mat[indexR][indexC];
                indexC++;
                if (indexC >= mat[0].length) {
                    indexC = 0;
                    indexR++;
                }
            }
        }
        return res;
    }
}
