package algorithm.slidingWindow;

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
// 示例1:
//
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//
//
//
//
// 示例2:
//
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//
//
//
// 注意：
//
//
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间
//
// Related Topics 双指针 Sliding Window


import java.util.HashMap;
import java.util.Map;

//字符串的排列
//leetcode submit region begin(Prohibit modification and deletion)
class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            Character n = s1.charAt(i);
            need.put(n, need.get(n) == null ? 0 : need.get(n) + 1);
        }
        int right = 0;
        int left = 0;
        int matchNum = 0;
        while (right < s2.length()){
            Character r = s2.charAt(right);
            if (need.containsKey(r)){
                window.put(r, window.get(r) == null ? 0 : window.get(r) + 1);
                //一个字母数量符合
                if (need.get(r).equals(window.get(r))){
                    matchNum++;
                }
            }
            right++;
            while (right - left >= s1.length()){
                Character l = s2.charAt(left);
                if (matchNum == need.size()){
                    return true;
                }
                left++;
                if (need.containsKey(l)){
                    if (need.get(l).equals(window.get(l))){
                        matchNum--;
                    }
                    window.put(l, window.get(l) == null ? 0 : window.get(l) - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

