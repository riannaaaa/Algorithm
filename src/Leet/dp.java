package Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp {
//1. 确定dp数组(Leet.dp table)以及下标的含义
//2. 确定递推公式
//3. dp数组如何初始化
//4. 确定遍历顺序
//5. 举例推导dp数组

    /*
    * 509. 斐波那契数
    */
//1. 确定dp数组(Leet.dp table)以及下标的含义
//   Leet.dp[i]的定义为:第i个数的斐波那契数值是dp[i]
//2. dp数组如何初始化
//   Leet.dp[0] = 0;
//   Leet.dp[1] = 1;
//3. 确定递推公式
//   状态转移方程 Leet.dp[i] = Leet.dp[i - 1] + Leet.dp[i - 2];
//4. 确定遍历顺序
//   从递归公式dp[i] = Leet.dp[i - 1] + Leet.dp[i - 2];中可以看出，Leet.dp[i]是依赖 Leet.dp[i - 1] 和 Leet.dp[i - 2]，
//   那么遍历的顺序一定是从前到后遍历的。
//5. 举例推导dp数组--->debug
//   e.g. 按照这个递推公式dp[i] = Leet.dp[i - 1] + Leet.dp[i - 2]，推导当N为10的时候，dp数组应该是如下的
//   数列: 0 1 1 2 3 5 8 13 21 34 55 如果有bug就把dp数组打印出来看看和推导的数列是不是一致的。
    public int fib(int n) {
        //先设置初始值
        if(n<=1){return n;}
        //确定dp数组(Leet.dp table)以及下标的含义
        //创建长度为 n+1 的数组dp
        int[] dp = new int[n+1];
        //dp数组初始化
        dp[0]=0;
        dp[1]=1;
      //Leet.dp[2]=1;
      //Leet.dp[3]=2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
//    优化空间版本：只用一个两个元素的数组
//    public:
//    int fib(int N) {
//        if (N <= 1) return N;
//        int Leet.dp[2];
//        Leet.dp[0] = 0;
//        Leet.dp[1] = 1;
//        for (int i = 2; i <= N; i++) {
//            int sum = Leet.dp[0] + Leet.dp[1];
//            Leet.dp[0] = Leet.dp[1];
//            Leet.dp[1] = sum;
//        }
//        return Leet.dp[1];
//    }
    /*
     * 70. 爬楼梯
     */
//1. 确定dp数组(Leet.dp table)以及下标的含义
//   Leet.dp[i]的定义为: 爬到第i层楼梯，有dp[i]种方法
//2. dp数组如何初始化
//   答案dp[0]=0比较有争议所以先不考虑dp[0]如果初始化，只初始化dp[1] = 1，Leet.dp[2] = 2
//3. 确定递推公式
//   从dp[i]的定义可以看出，Leet.dp[i] 可以有两个方向推出来。
//   首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶不就是dp[i]。
//   还有就是dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是dp[i]。
//   so:
//   状态转移方程 Leet.dp[i] = Leet.dp[i - 1] + Leet.dp[i - 2];
//4. 确定遍历顺序
//   从递归公式dp[i] = Leet.dp[i - 1] + Leet.dp[i - 2];中可以看出，Leet.dp[i]是依赖 Leet.dp[i - 1] 和 Leet.dp[i - 2]，
//   那么遍历的顺序一定是从前到后遍历的。
//5. 举例推导dp数组--->debug
//   e.g. 按照这个递推公式dp[i] = Leet.dp[i - 1] + Leet.dp[i - 2]，推导当N为5的时候，dp数组应该是如下的
//   数列: 1 1 2 2 3 5 8 如果有bug就把dp数组打印出来看看和推导的数列是不是一致的。
    public int climbStairs(int n) {
        if(n==0)return 1;
        //创建长度为 n+1 的数组dp
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //也可以同样方法优化空间。
    /*
     * 爬楼梯拓展版：
     * 这道题目还可以继续深化，就是一步一个台阶，两个台阶，三个台阶，直到 m个台阶，有多少种方法爬到n阶楼顶。
     * 代码示例如下：
     */
//    public:
//    int climbStairs(int n) {
//        vector<int> Leet.dp(n + 1, 0);
//        Leet.dp[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) { // 把m换成2，就可以AC爬楼梯这道题 if (i - j >= 0) Leet.dp[i] += Leet.dp[i - j];
//            } }
//        return Leet.dp[n];
//    }
    /*
     * 746. 使用最小花费爬楼梯
     */
//1. 确定dp数组(Leet.dp table)以及下标的含义
//   Leet.dp[i]的定义为: 爬到第i层楼梯！！顶部！！需要的最小的力气
//2. 确定递推公式
//   状态转移方程 Leet.dp[i]=min(Leet.dp[i-2]+cost[i-1],Leet.dp[i-1]+cost[i]);
//3. dp数组如何初始化
//   Leet.dp[0]=cost[0]
//   Leet.dp[1]= min(Leet.dp[0]+cost[1],cost[1])
//   Leet.dp[2]= min(Leet.dp[0]+cost[1],Leet.dp[1]+cost[2])
//4. 确定遍历顺序
//   那么遍历的顺序一定是从前到后遍历的。
//5. 举例推导dp数组--->debug
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1){
            return cost[0];
        }
        int[] dp = new int[cost.length+1];          //      _
        dp[0] = 0;                                 //10   _| 20
        dp[1] = Math.min(cost[0],cost[1]);        //10  _| 15  [10,(10,15),(10+15,)]
        // Leet.dp[2] = Math.min(cost[0],cost[1]);    //10 _|  10  [10,(10,15),(10+15,)]
        for (int i = 2; i < dp.length-1; i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-1],dp[i-1]+cost[i]);//Leet.dp[2] = min(Leet.dp[0]+cost[1],Leet.dp[1]+cost[2]) 25,
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length-1];
    }
    /*
     * 62. 到finish有多少条路径
     */
//1. 确定dp数组(Leet.dp table)以及下标的含义
//   Leet.dp[i][j]的定义为: 到[i][j]有的不同路径个数？
//2. 确定递推公式
//   状态转移方程 Leet.dp[i][j]=Leet.dp[i-1][j]+Leet.dp[i][j-1];        _ _ _
//3. dp数组如何初始化                                     _ 2 _
//   Leet.dp[0][0]=0?                                       _ _ _
//   Leet.dp[1][0]= 1
//   Leet.dp[1][1]= Leet.dp[0][1]+Leet.dp[1][0] = 2
//   Leet.dp[0][1]= 1
//   Leet.dp[0][j]= Leet.dp[0][j-1]
//   Leet.dp[i][0]= Leet.dp[i-1][0]
//4. 确定遍历顺序
//   那么遍历的顺序一定是从前到后遍历的。
//5. 举例推导dp数组--->debug

    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && (j == 0)){dp[0][0]=0;}
                else
                if(i == 0){dp[0][j]= 1;}
                else
                if(j == 0){dp[i][0]= 1;}
                else
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
    /*
     * 63. 到finish有多少条路径（有障碍版）
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean firstRowHas0 = false;
        boolean firstColumnHas0 = false;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    if(i==0)firstRowHas0 = true;
                    if(j==0)firstColumnHas0 = true;
                    dp[i][j] = 0;
                }else
                    if(i == 0 && j == 0){dp[0][0]=1;}
                    else
                    if(i == 0){
                        if(firstRowHas0)dp[0][j]= 0;
                        else
                        dp[0][j]= 1;}
                    else
                    if(j == 0){
                        if(firstColumnHas0)dp[i][0]= 0;
                        else
                            dp[i][0]= 1;}
                    else
                        dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
    /*
     * 343. 整数拆分
     */
    public int integerBreak(int n) { //5 [0, 1 ,2 ,3 ,4 ,5 ]  3:b(1)*2,b(2)*1
        if(n==0) return 0;                                  //4:b(1)*3,b(2)*2,b(3)*1
        int max = 0;
        int thisValue = 0;
        int dividedBy0 = 0;
        int[] dp = new int[n+1];
        dp[2] = 1;
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dividedBy0 = j*(i-j);
                thisValue = dp[j]*(i-j);
                max = Math.max(max,thisValue);
                max = Math.max(max,dividedBy0);
            }
            dp[i] = max;
            max = 0;
        }
        return dp[n];
    }
    /*
     * 96. 不同的二叉搜索树
     */
    //1.定义dp：n时刻的二叉树个数
    //2.递归：图见题解
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int num = 0;
        for (int i = 3; i <= n; i++) { //3: 0->2*0;1->1*1;2->0*2
            int half = i/2;
            if(i%2==1){               //4: 0->0*3;1->1*2;2->2*1;3->3*0
                                      //5: 0->0*4;1->1*3;2->2*2;3->3*1;4->4*0;
                for (int j = 0; j < half; j++) {
                    num +=dp[j]*dp[i-1-j];
                }
                num*=2;
                num+=dp[half]*dp[half];
                dp[i] = num;
                num = 0;
            }
            else {
                for (int j = 0; j < half; j++) {
                    num +=dp[j]*dp[i-1-j];
                }
                num*=2;
                dp[i] = num;
                num = 0;
            }
        }
        return dp[n];
    }
    public int rob(int[] nums) {//[1,2,3,4]
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0],nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[nums.length];
    }

    /*
     * 64. 最小路径和
     */
    public int minPathSum(int[][] grid) {
        //定义dp：到达dp[i][j]的最短路径？
        if(grid.length==1&&grid[0].length==1){return grid[0][0];}
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int ij = grid[i][j];
                if(i==0&&j==0)dp[0][0] = grid[0][0];
                else
                if(i==0){dp[i][j]=dp[i][j-1]+ij;}
                else
                if(j==0){dp[i][j]=dp[i-1][j]+ij;}
                else
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+ij;
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    /*
     * 64. 最长公共子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] , dp[i][j]);
                }
            }
        }
        return dp[text1.length() + 1][text2.length() + 1];
    }

    /*
     * leet1915 最美子字符串的数目
     */
    public long wonderfulSubstrings(String word) {
        int[][] dp = new int[word.length()][word.length()];
        int[] num = new int[10];
        if (word.length() == 1) return 1;
        if (word.length() == 0) return 0;
        dp[0][0] = 1;
        num[word.charAt(0) - 'a']++;
        System.out.println();
        boolean haveOdd = true;
        for (int i = 1; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (!haveOdd && num[word.charAt(j) - 'a'] % 2 == 0 || haveOdd && num[word.charAt(j) - 'a'] % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                    haveOdd = !haveOdd;
                    num[word.charAt(i) - 'a']++;
                }
            }
            haveOdd = !haveOdd;
            num[word.charAt(i) - 'a']--;
        }
        return dp[word.length() - 1][word.length() - 1];}

        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] < i) {
                        dp[i] += dp[i - nums[j]] + 1;
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[target];
        }

    /*
     * leet5. 最长回文子串
     */
//    对于一个子串而言，如果它是回文串，并且长度大于 2，那么将它首尾的两个字母去除之后，它仍然是个回文串。
//    j    0000 0-3 1-2
//    0 1 2 3 4
//i   0     2 x
//    1     x
//    2
//    3 x x x T T
//    4 x x x x T
    //字符串
    //倒过来
    //Leet.dp:
    //1.定义dp：boolean Leet.dp[i][j] = string i--j是否为回文
    //2.递归公式：
    public String longestPalindrome(String s) {
        boolean [][] dp = new boolean[s.length()][s.length()];
        int[] res = new int[2];
        int max = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if(i > j) {
                    dp[i][j]=false;
                    continue;}
                else
                if(i==j) {
                    dp[i][j]=true;
                    if(max<1){
                        max= 1;
                        res[0] = i;
                        res[1] = j;}
                    continue;
                }
                else if(j==0) {
                    dp[i][j]=false;
                    continue;}
                else if(j-i==1){
                    dp[i][j]=b;
                    if(b&&max <= 1){
                        max= 2;
                        res[0] = i;
                        res[1] = j;
                    }continue;
                }
                dp[i][j] = b && dp[i+1][j-1];
                if(dp[i][j]&&j-i+1>max){
                    max= j-i+1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return s.substring(res[0],res[1]+1) ;
    }
    public static void main(String[] args) {
        dp dp = new dp();
        //System.out.println(Leet.dp.fib(3));
        int[] minCostClimbingStairs = new int[]{1,100,1,1,1,100,1,1,100,1};
        int[] dengcha = new int[]{1,2,3,8,9,10};
//        Sy stem.out.println(Leet.dp.minCostClimbingStairs(minCostClimbingStairs));
//        System.out.println(Leet.dp.uniquePaths(3,7));
        int obstacleGrid[][] = new int[][]{{0,0,0,0,1,0,0,0}};
        int Grid[][] = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(8>>1);
//        System.out.println(Leet.dp.uniquePathsWithObstacles(obstacleGrid));
//        System.out.println(Leet.dp.integerBreak(4));
//        System.out.println(Leet.dp.numTrees(4));
//        System.out.println(Leet.dp.numberOfArithmeticSlices(dengcha))
//        System.out.println(Leet.dp.minPathSum(Grid));

//1 49; 2 48

    }

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

            }
        }
        return 0;
    }
}
