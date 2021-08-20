package  无分组.通过删除字母匹配到字典里最长单词;

import java.util.List;

public class leet524 {
    //字典序：
    //   s1.compareTo(s2);
    public String findLongestWord(String s, List<String> dictionary) {
        int index = 0;
        boolean found = false;
        int max = 0;
        int res = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (index < dictionary.get(i).length() && s.charAt(j) == dictionary.get(i).charAt(index)) {
                    index++;
                }
            }
            if (index == dictionary.get(i).length()) {
                found = true;
                if (dictionary.get(i).length() > max) {
                    max = dictionary.get(i).length();
                    res = i;
                } else if (dictionary.get(i).length() == max) {
                    if (dictionary.get(i).compareTo(dictionary.get(res)) < 0) {
                        res = i;
                    }
                }
            }
            index = 0;
//                found = false;


        }
        return found ? dictionary.get(res) : "";
    }
}
