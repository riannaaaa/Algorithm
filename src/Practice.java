public class Practice {

    public static void main(String[] args) {
        int g[][] = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        char XO[][] = new char[][]{{'O', 'O'}, {'O', 'O'}};
        char XO1[][] = new char[][]{{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};

        int find[][] = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int L934[][] = new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        int L994[][] = new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}};
        int L9342[][] = new int[][]{{0, 1}, {1, 0}};

        //[['X','O','X','O','X','O'],
        // ['O','X','O','X','O','X'],
        // ['X','O','X','O','X','O'],
        // ['O','X','O','X','O','X']]

        int[] s = new int[]{1, 0, 0, 0, 0, 0, 1};
        int[] per = new int[]{1, 2, 3};
        Practice solution = new Practice();

//        solution.canPlaceFlowers(s,2);
//        System.out.println(solution.findMinArrowShots(g));
//        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
//        System.out.println(solution.largestOddNumber("123456"));
//        System.out.println(solution.findCircleNum(find));
//        System.out.println(solution.permute(per));
//        System.out.println(solution.diffWaysToCompute("3-4*5")); //3-4*5
//        System.out.println(Arrays.toString(solution.permutationMine("abc"))); //3-4*5
//        System.out.println((solution.combine(4,2))); //3-4*5
//        char Board[][] = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'} };
//
//        System.out.println((solution.exist(Board,"SEE")));
//        System.out.println((solution.shortestBridge(L934)));
//        System.out.println((solution.shortestBridge(L9342)));
//        System.out.println((solution.countPrimes(10)));
//        System.out.println((solution.convertToBase7(-7)));
//        System.out.println((solution.addStrings("88","3")));
//        System.out.println((solution.longestPalindrome("dtgrtoxuybwyfskikukcqlvprfipgaygawcqnfhpxoifwgpnzjfdnhpgmsoqzlpsaxmeswlhzdxoxobxysgmpkhcylvqlzenzhzhnakctrliyyngrquiuvhpcrnccapuuwrrdufwwungaevzkvwbkcietiqsxpvaaowrteqgkvovcoqumgrlsxvouaqzwaylehybqchsgpzbkfugujrostopwhtgrnrggocprnxwsecmvofawkkpjvcchtxixjtrnngrzqpiwywmnbdnjwqpmnifdiwzpmabosrmzhgdwgcgidmubywsnshcgcrawjvfiuxzyzxsbpfhzpfkjqcpfyynlpshzqectcnltfimkukopjzzmlfkwlgbzftsddnxrjootpdhjehaafudkkffmcnimnfzzjjlggzvqozcumjyazchjkspdlmifvsciqzgcbehqvrwjkusapzzxyiwxlcwpzvdsyqcfnguoidiiekwcjdvbxjvgwgcjcmjwbizhhcgirebhsplioytrgjqwrpwdciaeizxssedsylptffwhnedriqozvfcnsmxmdxdtflwjvrvmyausnzlrgcchmyrgvazjqmvttabnhffoe")));
//        System.out.println((solution.partition("aab")));
//        solution.solve(XO1);

    }

}
