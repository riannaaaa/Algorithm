package Leet.无分组.旋转图像;

public class leet48 {
    //    旋转图像
    public void rotate(int[][] matrix) {
        int tmp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i <= matrix[0].length/2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-j-1];
                matrix[j][i] = tmp;
            }
        }
//        int rotate[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        rotate(rotate);
//        System.out.println(Arrays.deepToString(rotate()));
    }
}
