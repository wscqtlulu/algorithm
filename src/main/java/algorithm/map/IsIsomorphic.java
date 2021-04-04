package algorithm.map;

//给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
// 示例 1:
//
//
//输入：s = "egg", t = "add"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "foo", t = "bar"
//输出：false
//
// 示例 3：
//
//
//输入：s = "paper", t = "title"
//输出：true
//
//
//
// 提示：
//
//
// 可以假设 s 和 t 长度相同。
//
// Related Topics 哈希表
// 👍 345 👎 0


import java.util.HashMap;
import java.util.LinkedHashMap;

//同构字符串
//leetcode submit region begin(Prohibit modification and deletion)
class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        int[] iS = new int[s.length()];
        int[] iT = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            Character sC = s.charAt(i);
            if (mapS.containsKey(sC)){
                iS[i] = mapS.get(sC);
            } else {
                mapS.put(sC, i);
                iS[i] = i;
            }
        }
        for (int i = 0; i < t.length(); i++) {
            Character tC = t.charAt(i);
            if (mapT.containsKey(tC)){
                iT[i] = mapT.get(tC);
            } else {
                mapT.put(tC, i);
                iT[i] = i;
            }
            if (iS[i] != iT[i]){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

