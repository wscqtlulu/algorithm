package algorithm.map;

//给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
//
// 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
//
// 返回所有不常用单词的列表。
//
// 您可以按任何顺序返回列表。
//
//
//
//
//
//
// 示例 1：
//
// 输入：A = "this apple is sweet", B = "this apple is sour"
//输出：["sweet","sour"]
//
//
// 示例 2：
//
// 输入：A = "apple apple", B = "banana"
//输出：["banana"]
//
//
//
//
// 提示：
//
//
// 0 <= A.length <= 200
// 0 <= B.length <= 200
// A 和 B 都只包含空格和小写字母。
//
// Related Topics 哈希表
// 👍 84 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//两句话中的不常见单词
//leetcode submit region begin(Prohibit modification and deletion)
class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        String[] strings1 = s1.split(" ");
        for (int i = 0; i < strings1.length; i++) {
            if (map.containsKey(strings1[i])){
                map.put(strings1[i], 0);
            } else {
                map.put(strings1[i], 1);
            }
        }
        String[] strings2 = s2.split(" ");
        for (int i = 0; i < strings2.length; i++) {
            if (map.containsKey(strings2[i])){
                map.put(strings2[i], 0);
            } else {
                map.put(strings2[i], 1);
            }
        }
        for (Map.Entry e :
                map.entrySet()) {
            if ((Integer) e.getValue() == 1) {
                list.add((String)e.getKey());
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
