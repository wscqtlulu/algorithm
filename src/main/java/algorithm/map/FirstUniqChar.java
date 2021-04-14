package algorithm.map;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 374 👎 0


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//字符串中的第一个唯一字符
//leetcode submit region begin(Prohibit modification and deletion)
class FirstUniqChar {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() == 1){
                return s.indexOf(String.valueOf(entry.getKey()));
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

