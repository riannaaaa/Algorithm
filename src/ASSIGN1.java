import java.util.Arrays;

public class ASSIGN3670 {
    //高 斯 消 元 法
    public double[][] gass(double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < Math.min(n,m); i++) {
            double tmp = matrix[i][i];//pivot
            if (tmp == 0)  {//if pivot is 0, swap this rows with one of the below rows
                int nextRow =  i + 1;
                boolean foundNonZero = false;
                while (nextRow < m) {
                    double tmpp = matrix[nextRow][i];
                    if (tmpp != 0) {
                        foundNonZero = true;
                        //swap
                        double[] t = matrix[i];
                        matrix[i] = matrix[nextRow];
                        matrix[nextRow] = t;
                        tmp = matrix[i][i];
                        for (int tt = 0; tt < n; tt++) {
                            matrix[i][tt] /= tmp;
                        }
                        break;
                    }
                    nextRow++;
                }
                //if we can not find non zero below, continue to deal with the next pivot.
                if (!foundNonZero) continue;
            };
            //change pivot to 1
            if (matrix[i][i] != 1) {
                for (int tt = i; tt < n; tt++) {
                    matrix[i][tt] /= tmp;
                }

            }
            for (int ttt = i + 1; ttt < m; ttt++) {
                double nowFirst = matrix[ttt][i];
                if (nowFirst == 0) continue;
                double[] tmpRow =  new double[n];
                for (int tt = 0; tt < n; tt++) {
                    tmpRow[tt] = matrix[i][tt];
                    tmpRow[tt] *= nowFirst;
                }
                for (int tt = i; tt < n; tt++) {
                    matrix[ttt][tt] -= tmpRow[tt];
                }
            }

        }
        //REF done;
        for (int x = 1; x < Math.min(n,m); x++) {
            for (int y = 0; y < x; y++) {
                // theElementShouldBeChangedToOne
                double elementAbovePivot = matrix[y][x];
                if (elementAbovePivot == 0) continue;
                double[] tmpRow = new double[n];
                for (int tt = 0; tt < n; tt++) {
                    tmpRow[tt] = matrix[x][tt];
                    tmpRow[tt] *= elementAbovePivot;
                }
                for (int tt = x; tt < n; tt++) {
                    matrix[y][tt] -= tmpRow[tt];
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }
}
