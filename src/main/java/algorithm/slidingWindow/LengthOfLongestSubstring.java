package algorithm.slidingWindow;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window


import java.util.HashSet;
import java.util.Set;

//无重复字符的最长子串
//leetcode submit region begin(Prohibit modification and deletion)
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int right = 0;
        int left = 0;
        int len = 0;
        while (right < s.length()){
            Character r = s.charAt(right);
            //发现重复
            if (set.contains(r)){
                while (left < right){
                    Character l = s.charAt(left);
                    left++;
                    //元素移出窗口
                    set.remove(l);
                    //左移发现重复值，停止左移指针
                    if (r.equals(l)){
                        break;
                    }
                }
            } else {
                len = Math.max(right - left + 1, len);
            }
            //元素加入窗口
            set.add(r);
            right++;
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

