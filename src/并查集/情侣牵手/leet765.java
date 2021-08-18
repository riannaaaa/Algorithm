package 并查集.情侣牵手;

public class leet765 {
    //贪心法，待补充并查集方法
    public static int minSwapsCouples(int[] row) {
        int res = 0;
        int nowI = 0;
        int nowSecond = 0;
        for (int i = 0; i < row.length - 1 ; i+=2) {
            nowI = row[i];
            nowSecond = row[i + 1];
            if (nowI % 2 == 0 && nowSecond != nowI + 1) {
                //find i + 1;
                for (int j = i + 1; j < row.length; j++) {
                    if (i < row.length - 1 && row[j] == nowI + 1) {
                        //swap
                        int tmp = row[i + 1];
                        row[i + 1] = row[j];
                        row[j] = tmp;

                        res += 1;

                    }
                }
            }
            if (nowI % 2 == 1 && nowSecond != nowI - 1) {
                //find i - 1;
                for (int j = i + 1; j < row.length; j++) {
                    if (i < row.length - 1 && row[j] == nowI - 1) {
                        //swap
                        int tmp = row[i + 1];
                        row[i + 1] = row[j];
                        row[j] = tmp;

                        res += 1;
                        break;
                    }
                }
            }

        }
        return res;
    }
}
