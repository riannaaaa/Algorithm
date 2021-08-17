package 剑指;

import java.util.*;

public class offer57 {
    //注意判断是先该指针还是先看窗口内状态
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int l = 1, r = 1;
        int sum1 = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (r <= sum / 2 + 1) {
            if (sum1 < sum) {
                r += 1;
                sum1 += r;
            } else if (sum1 > sum) {
                sum1 -= l;
                l += 1;
            } else {
                ArrayList<Integer> res1 = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    res1.add(i);
                }
                res.add(res1);
                l += 1;
                r = l;
                sum1 = l;
            }
        }
        return res;
    }

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        int index = 0;
        dfs(s, "", 0, 0);
        return res;
    }

    public void dfs(String s, String ip, int index, int counter) {
        if (counter == 4 && index == s.length()) {
            res.add(ip.substring(0, ip.length() - 1));
            return;
        }
        if (counter >= 4) return;
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;
            if (counter == 0 && s.length() - (index + i) > 9 || counter == 0 && s.length() - (index + i) < 3) break;
            String part = s.substring(index, index + i);
            int partInt = Integer.parseInt(part);
            if (partInt > 255 || part.charAt(0) == '0' && part.length() != 1) break;
            dfs(s, ip + part + ".", index + i, counter + 1);
        }

        //第一个后最多9位最少3位
        //第二个后最多6位最少2位
        //第二个后最多3位最少1位
    }



    public int numRabbits(int[] answers) {
        int[] nums = new int[1000];
        for (int i = 0; i < answers.length; i++) {
            nums[answers[i]]++;
        }
        int res = 0;
        res += nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] == 1) res += i;
            else if (i >= nums[i] - 1) res += (i + 1);
            else {
                int f = nums[i] / (i + 1);
                int d = nums[i] % (i + 1);
                res += (f + d) * (i + 1);
            }
        }
        return res;
    }

    static int[] ress = new int[2];

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int min = Integer.MAX_VALUE, sum1 = 0;
        int l = 0, r = array.length - 1;
        boolean flag = false;
        while (l < r) {
            sum1 = array[l] + array[r];
            if (sum1 < sum) {
                l++;
            } else if (sum1 > sum) {
                r--;
            } else {
                flag = true;
                if (array[l] * array[r] < min) {
                    min = array[l] * array[r];
                    ress[0] = array[l];
                    ress[1] = array[r];
                }
                l++;
                r--;
            }
        }
        ArrayList<Integer> rr = new ArrayList<>();
        for (int i = 0; i < ress.length; i++) {
            rr.add(ress[i]);
        }
        return flag ? rr : new ArrayList<>();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
//      int[] Leet.dp = new int[triangle.size()];//到达n层的最短路径
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {

            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j));
                    if (i == triangle.size() - 1) {
                        min = Math.min(min, triangle.get(i).get(j));
                    }
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1));
                    if (i == triangle.size() - 1) {
                        min = Math.min(min, triangle.get(i).get(j));
                    }
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                    if (i == triangle.size() - 1) {
                        min = Math.min(min, triangle.get(i).get(j));
                    }
                }
            }
        }
        return min;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int r = 0, c = 0;
        int length = matrix.length * matrix[0].length;
        res.add(matrix[0][0]);
        for (int i = 0; i < length; i++) {
            if (c + 1 < matrix[0].length && matrix[r][c + 1] != 101) {
                c = c + 1;
                res.add(matrix[r][c]);
                matrix[r][c] = 101;
            } else if (r + 1 < matrix.length && matrix[r + 1][c] != 101) {
                r = r + 1;
                res.add(matrix[r][c]);
                matrix[r][c] = 101;
            } else if (c - 1 >= 0 && matrix[r][c - 1] != 101) {
                c = c - 1;
                res.add(matrix[r][c]);
                matrix[r][c] = 101;
            } else if (r - 1 >= 0 && matrix[r - 1][c] != 101) {
                r = r - 1;
                res.add(matrix[r][c]);
                matrix[r][c] = 101;
            } else
                return res;
        }
        return res;
    }

    public int removeDuplicates(int[] nums) {
        int num = 1;
        int same = 0;
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == first) {
                same++;
                num++;
                if (num > 2) {
                    nums[i] = 100000;
                }
            } else {
                first = nums[i];
                num = 1;
            }
        }
        int res = nums.length - same;
        int index = 0;
        int swap = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 100000 && i < res) {
                index = i;
                while (nums[i] == 100000) i++;
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                i = index + 1;
                swap++;
            }
        }
        return res;
    }

    public String reorganizeString(String s) {
        int max = 0;
        int same = 1;
        int single = 0;
        int count = 0;
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                same++;
                count++;
            } else if (count == 1) single++;
            first = s.charAt(i);
            count = 1;
            max = Math.max(max, same);
            same = 1;
        }
        return null;//max - 1 <= single;
    }

    public String multiply(String num1, String num2) {
        String ress = "";
        long tmp = 0;
        String res = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int first = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int second = num1.charAt(i) - '0';
                int result = first * second;
                res = "" + (result);
                for (int k = 0; k < (num2.length() - i - 1 + num1.length() - j - 1); k++) {
                    res += "0";
                }
                ress = addStrings(ress, res);
            }
        }
        return ress;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }


    public String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        String res = "";
        StringBuffer stringBuffer = new StringBuffer();
        String[] s = new String[nums.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (o1, o2) -> ((o1 + o2).compareTo((o2 + o1))));
        System.out.println(Arrays.toString(s));

        for (int i = 0; i < s.length; i++) {
            res += s[i];
        }
        return res;
    }
    static String maxString = "";

    public static void dfs(String[] s, int begin, int end, boolean[] visited, int index, String cur, int max) {
        if (index == end - begin + 1) {
            if (Integer.parseInt(cur) > max) {
                max = Integer.parseInt(cur);
                maxString = cur;
            }
            ;
        }
        for (int i = 0; i <= end - begin; i++) {
            if (visited[index]) continue;
            visited[index] = true;
            int l = s[begin + i].length();
            cur += (s[begin + i]);
            dfs(s, begin, end, visited, index + 1, cur, max);
            cur = cur.substring(0, cur.length() - l);
        }
    }

    public String largestNumber1(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        String res = "";
        StringBuffer stringBuffer = new StringBuffer();
        String[] s = new String[nums.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, this::mySort);
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, (o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));
        for (int i = 0; i < s.length; i++) {
            res += s[i];
        }
        return res;
    }
    public List<Integer> lexicalOrder(int n) {
        String[] res= new String[n];
        System.out.println();
        String no = "";
        for (int i = 1; i <= n; i++) {
            no = String.valueOf(i);
            res[i] = no;
        }
        Arrays.sort(res);
        List<Integer> res1 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            res1.add(Integer.parseInt(res[i]));
        }
        return (res1);
    }
    public int jumpFloorII(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        int[] dp = new int[target + 1];
        Arrays.fill(dp,1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
//1, 2 1, 1 2, 1,1,1
    public int mySort(String o1, String o2) {
        if (o1.length() > o2.length()) {
            for (int i = 0; i < o2.length(); i++) {
                if (o1.charAt(i) == o2.charAt(i)) continue;
                return o2.charAt(i) - o1.charAt(i);
            }
            for (int i = 0; i < o2.length(); i++) {
                if (o1.charAt(o2.length()) == o2.charAt(i)) continue;
                return o2.charAt(i) - o1.charAt(o2.length());
            }
        } else
            for (int i = 0; i < o1.length(); i++) {
                if (o1.charAt(i) == o2.charAt(i)) continue;
                return o1.charAt(i) - o2.charAt(i);
            }
        for (int i = 0; i < o1.length(); i++) {
            if (o2.charAt(o1.length()) == o1.charAt(i)) continue;
            return o1.charAt(i) - o2.charAt(o1.length());
        }
        return 0;
    }
    static List<List<String>> resr = new ArrayList<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<String> cur = new ArrayList<>();
        boolean[] visited = new boolean[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            if (!visited[i]) continue;
            cur.add(accounts.get(i).get(0));
            resr.add(cur);
            dfs(accounts, visited, i);
        }
        return resr;
    }
    public void dfs(List<List<String>> accounts, boolean[] visited, int index){
        for (int i = 0; i < accounts.get(index).size(); i++) {
            String cur = accounts.get(index).get(i);
            for (int j = index; j < accounts.size(); j++) {
                for (int k = 0; k < accounts.get(j).size(); k++) {
                     if (cur.equals(accounts.get(j).get(k))) {
                         visited[j] = true;
                         for (int z = 0; z < accounts.get(j).size(); z++) {
                             resr.get((resr.size() - 1)).add(accounts.get(j).get(z));
                         }
                     }
                }
            }
        }
        }
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        boolean[] visited = new boolean[employees.size()];
        Collections.sort(employees,(o1,o2) -> o1.id - o2.id);
        for (Employee employee : employees) {
            if (employee.id == id) {
                res += employee.importance;
                for (Integer subordinate : employee.subordinates) {
                    visited[subordinate] = true;
                }
            }
        }
        for (Employee employee : employees) {
            if (visited[employee.id]) {
                res += employee.importance;
                for (Integer subordinate : employee.subordinates) {
                    if (subordinate < employee.id) {
                        res += itAll(employees,subordinate,visited);
                    }
                    else
                    visited[subordinate] = true;
                }
            }
        }
        return res;
    }

    private int itAll(List<Employee> employees, Integer subordinate, boolean[] visited) {
        for (Employee employee : employees) {
            if (employee.id == subordinate) {

                for (Integer sub : employee.subordinates) {
                    visited[sub] = true;
                }
                return employee.importance;
            }
        }
        return 0;
    }
    static int[] max = new int[]{0};
    public int lengthOfLIS(int[] nums) {
        dfs(nums, 1, max, 1, nums[0]);

        return max[0];
    }
    public void dfs(int[] nums, int curLength, int[] max, int index, int cur){
        if (index == nums.length - 1) {
            max[0] = cur < nums[nums.length - 1] ? Math.max(max[0], curLength) + 1 : Math.max(max[0], curLength) ;
            return;
        }
        for (int i = index; i < nums.length - 1; i++) {
            while (nums[index] <= cur) {
                index++;
            }

            dfs(nums, curLength + 1, max, index + 1, nums[index]);
        }

    }
    public static void main(String[] args) {
        int[] res = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] res1 = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(new offer57().FindNumbersWithSum(res, 21));
//        System.out.println(new offer57().jumpFloorII(3));
        System.out.println(new offer57().lengthOfLIS(res1));


        //  System.out.println(new offer57().reverse(s,6,9));


    }
}
//
//
//            first = (long) (first * Math.pow(10,num1.length() - 1 - i));
//            for (int j = num2.length() - 1; j >= 0; j--) {
//                long second = Integer.parseInt(num2.charAt(j) + "");
//                second = (long) (second * Math.pow(10,num2.length() - 1 - j));
//                tmp = first * second;
//                res += tmp;
//            }
//

//    public String reverse(String s, int l, int r){
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append(s.substring(0,l));
//        for (int i = r - 1; i > l; i--) {
//            stringBuffer.append(s.charAt(i));
//        }
//        stringBuffer.append(s.substring(r + 1));
//        return stringBuffer.toString();
//    }
//    public String multiply(String num1, String num2) {
//        long res = 0;
//        long tmp = 0;
//        for (int i = num2.length() - 1; i >= 0; i--) {
//            long first = Integer.parseInt(num2.charAt(i) + "");
//            first = (long) (first * Math.pow(10,num1.length() - 1 - i));
//            for (int j = num2.length() - 1; j >= 0; j--) {
//                long second = Integer.parseInt(num2.charAt(j) + "");
//                second = (long) (second * Math.pow(10,num2.length() - 1 - j));
//                tmp = first * second;
//                res += tmp;
//            }
//        }
//        return res + "";
//    }

  //  }




