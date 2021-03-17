package algorithm.others;

//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
//
// 美式键盘 中：
//
//
// 第一行由字符 "qwertyuiop" 组成。
// 第二行由字符 "asdfghjkl" 组成。
// 第三行由字符 "zxcvbnm" 组成。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
//
//
// 示例 2：
//
//
//输入：words = ["omk"]
//输出：[]
//
//
// 示例 3：
//
//
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 20
// 1 <= words[i].length <= 100
// words[i] 由英文字母（小写和大写字母）组成
//
//键盘行
// Related Topics 哈希表
// 👍 127 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class FindWords {
    List<String> list = new ArrayList();
    public String[] findWords(String[] words) {
        HashSet set1 = new HashSet();
        String s1 = "qwertyuiopQWERTYUIOP";
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }

        HashSet set2 = new HashSet();
        String s2 = "asdfghjklASDFGHJKL";
        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }

        HashSet set3 = new HashSet();
        String s3 = "zxcvbnmZXCVBNM";
        for (int i = 0; i < s3.length(); i++) {
            set3.add(s3.charAt(i));
        }

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            boolean print = true;
            if (w.length() > 0) {
                if (set1.contains(w.charAt(0))){
                    for (int j = 1; j < w.length(); j++) {
                        if (!set1.contains(w.charAt(j))){
                            print = false;
                            break;
                        }
                    }
                } else if (set2.contains(w.charAt(0))){
                    for (int j = 1; j < w.length(); j++) {
                        if (!set2.contains(w.charAt(j))){
                            print = false;
                            break;
                        }
                    }
                } else if (set3.contains(w.charAt(0))){
                    for (int j = 1; j < w.length(); j++) {
                        if (!set3.contains(w.charAt(j))){
                            print = false;
                            break;
                        }
                    }
                } else {
                    print = false;
                }
            } else {
                print = false;
            }
            if (print) {
                list.add(w);
            }
        }
//        String strings[]=(String [])list.toArray();
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

