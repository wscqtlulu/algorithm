package algorithm.slidingWindow;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//最小覆盖子串
//leetcode submit region begin(Prohibit modification and deletion)
class MinWindow {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            Character nc = t.charAt(i);
            need.put(nc, need.get(nc) == null ? 0 : need.get(nc) + 1);
        }
        //数量匹配的字符数
        int matchNum = 0;
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()){
            Character cR = s.charAt(right);
            right++;
            if(need.containsKey(cR)){
                window.put(cR, window.get(cR) == null ? 0 : window.get(cR) + 1);
                //这里要用equals而不能用==，因为Integer == Integer在-127～128之外的范围会返回false
                if (need.get(cR).equals(window.get(cR))){
                    matchNum++;
                }
            }
            //满足子串条件，但不一定为最优（最小），左移窗口
            while (matchNum == need.size()){
                Character cL = s.charAt(left);
                if (right - left + 1 < len){
                    len = right - left + 1;
                    start = left;
                    end = right;
                }
                left++;
                if (need.containsKey(cL)){
                    if (need.get(cL).equals(window.get(cL))){
                        matchNum--;
                    }
                    window.put(cL, window.get(cL) == null ? 0 : window.get(cL) - 1);
                }
            }
        }
        return len < Integer.MAX_VALUE ? s.substring(start, end) : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
