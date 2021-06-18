package algorithm.others;

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//
//
//
//
//
// 示例 1：
//
// 输入："ab-cd"
//输出："dc-ba"
//
//
// 示例 2：
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
// 示例 3：
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
//
//
//
//
// 提示：
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串


//仅仅反转字母
//leetcode submit region begin(Prohibit modification and deletion)
class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int l = s.length();
        if (l == 0 || l == 1) {
            return s;
        }
        int start = 0;
        int end = l - 1;
        while (start < end) {
            while (!Character.isLowerCase(s.charAt(start)) &&
                    !Character.isUpperCase(s.charAt(start)) && start < end){
                start++;
            }
            while (!Character.isLowerCase(s.charAt(end)) &&
                    !Character.isUpperCase(s.charAt(end)) && start < end){
                end--;
            }
            if (start < end) {
                if (end == l - 1) {
                    s = s.substring(0, start) + s.charAt(end) + s.substring(start + 1, end) + s.charAt(start);
                } else {
                    s = s.substring(0, start) + s.charAt(end) + s.substring(start + 1, end) + s.charAt(start) + s.substring(end + 1, l);
                }
            }
            start++;
            end--;
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

