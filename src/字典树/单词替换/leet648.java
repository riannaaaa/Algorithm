package 字典树.单词替换;

import java.util.List;

public class leet648 {
//    如果用前缀树，找到end就返回这一段
//    记得update yes

    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((o1,o2) -> o1.compareTo(o2));
        String[] sen = sentence.split(" ");
        StringBuffer s = new StringBuffer();
        boolean yes = false;

        for (int i = 0; i < sen.length; i++) {
            String word = sen[i];
            for (int j = 0; j < dictionary.size(); j++) {
                int index = 0;
                while (index < word.length() && index < dictionary.get(j).length() && word.charAt(index) == dictionary.get(j).charAt(index)) {

                    index++;
                    if (index == dictionary.get(j).length()) {
                        yes = true;
                        break;
                    }
                }
                if (yes) {
                    s.append(dictionary.get(j) + " ");
                    break;
                }
            }
            if (!yes) {s.append(word + " ");}
            yes = false;
        }
        s.deleteCharAt(s.length() - 1);
        return s.toString();

    }
}
