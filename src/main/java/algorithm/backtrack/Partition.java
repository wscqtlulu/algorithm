package algorithm.backtrack;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
// Related Topics 字符串 动态规划 回溯
// 👍 831 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//分割回文串
//leetcode submit region begin(Prohibit modification and deletion)
class Partition {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> linkedList = new LinkedList<>();
    public List<List<String>> partition(String s) {
        deal(s, 0);
        return res;
    }

    public void deal(String s, int startIndex){
        if (startIndex >= s.length()){
            res.add(new ArrayList<>(linkedList));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                linkedList.add(s.substring(startIndex, i + 1));
                deal(s, i + 1);
                linkedList.removeLast();
            }
        }
    }

    public Boolean isPalindrome(String s, int startIndex, int i){
        for (int j = startIndex, k = i; j < k; j++,k--) {
            if (s.charAt(j) != s.charAt(k)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

