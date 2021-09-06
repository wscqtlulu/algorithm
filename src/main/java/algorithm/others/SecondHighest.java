package algorithm.others;

//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
//
// 混合字符串 由小写英文字母和数字组成。
//
//
//
// 示例 1：
//
//
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
//
//
// 示例 2：
//
//
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 只包含小写英文字母和（或）数字。
//
// Related Topics 哈希表 字符串
// 👍 3 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

//字符串中第二大的数字
//leetcode submit region begin(Prohibit modification and deletion)
class SecondHighest {
    public int secondHighest(String s) {
        if (s.length() <= 1) {
            return -1;
        }
        int m1 = -1;
        int m2 = -1;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isLetter(c)){
                continue;
            }
            int num = c - '0';
            if (num > m2){
                m1 = m2;
                m2 = num;
            } else if (num < m2 && num > m1){
                m1 = num;
            }
        }
        return m1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

