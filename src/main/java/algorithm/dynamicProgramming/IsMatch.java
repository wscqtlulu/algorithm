package algorithm.dynamicProgramming;

//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3:
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4:
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5:
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
//
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
//
// Related Topics 动态规划


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class IsMatch {
    Map<String, Boolean> memo = new HashMap<String, Boolean>();
    public boolean isMatch(String s, String p) {
//        System.out.println(s + "-" + p);
        if (memo.get(s + "-" + p) != null){
//            System.out.println(s + "-" + p + ":" + memo.get(s + "-" + p));
            return memo.get(s + "-" + p);
        }
        int sL = s.length();
        int pL = p.length();
        boolean result = false;
        if (pL == 0){
            if (pL != sL){
                result = false;
            } else {
                result = true;
            }
        } else {
            if (pL >= 2 && p.charAt(1) == '*'){
                if (firstMatch(s, p)){
                    //匹配一个 *号前字符，继续往后看还有没有匹配*号前字符或者匹配0个*号前字符
                    result = isMatch(s.substring(1, sL), p) || isMatch(s, p.substring(2, pL));
                } else {
                    result = isMatch(s, p.substring(2, pL));
                }
            } else {
                if (sL == 0){
                    result = false;
                } else {
                    result = firstMatch(s, p) && isMatch(s.substring(1, sL), p.substring(1, pL));
                }
            }
        }
        memo.put(s + "-" + p, result);
        return result;
    }
    private boolean firstMatch(String s, String p){
        if (s.length() == 0){
            return false;
        }
        return (s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

