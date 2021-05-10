package algorithm.map;

//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
//
//
//
// 示例 1：
//
//
//
// 输入：text = "nlaebolko"
//输出：1
//
//
// 示例 2：
//
//
//
// 输入：text = "loonbalxballpoon"
//输出：2
//
//
// 示例 3：
//
// 输入：text = "leetcode"
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= text.length <= 10^4
// text 全部由小写英文字母组成
//
// Related Topics 哈希表 字符串


import java.util.HashMap;
import java.util.HashSet;

//气球的最大数量
//leetcode submit region begin(Prohibit modification and deletion)
class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
        int res = 0;
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }
        int doubleChar = Math.min(map.get('l'), map.get('o'));
        int singleChar = Math.min(Math.min(map.get('b'), map.get('a')),map.get('n'));
        res = doubleChar == 0 ? 0 : Math.min(doubleChar / 2, singleChar);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

