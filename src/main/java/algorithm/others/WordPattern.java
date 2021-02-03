package algorithm.others;

//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
// 示例1:
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
//
// 示例 2:
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false
//
// 示例 3:
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false
//
// 示例 4:
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false
//
// 说明:
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
// Related Topics 哈希表


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//单次规律
//leetcode submit region begin(Prohibit modification and deletion)
class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Integer> mapP = new HashMap<String, Integer>();
        Map<String, Integer> mapS = new HashMap<String, Integer>();
        String[] strings = s.split(" ");
        int[] pi = new int[pattern.length()];
        int[] si = new int[strings.length];
        if (strings.length != pi.length){
            return false;
        }
        int j = 0;
        int k = 0;
        for (int i = 0; i < pattern.length(); i++) {
            String c = "" + pattern.charAt(i);
            if (mapP.containsKey(c)){
                pi[i] = mapP.get(c);
            } else {
                mapP.put(c, ++j);
                pi[i] = j;
            }
            if (mapS.containsKey(strings[i])){
                si[i] = mapS.get(strings[i]);
            } else {
                mapS.put(strings[i], ++k);
                si[i] = k;
            }
            if (pi[i] != si[i]){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

