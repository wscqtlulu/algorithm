package algorithm.others;

//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例：
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
//
//
//
// 提示：
//
//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 字符串
// 👍 293 👎 0


import java.util.Stack;

//反转字符串中的单词
//leetcode submit region begin(Prohibit modification and deletion)
class ReverseWords {
    public String reverseWords(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' '){
                stack.push(s.charAt(i));
            } else {
                while (!stack.isEmpty()){
                    stringBuffer.append(stack.pop());
                }
                if (i != s.length() - 1) {
                    stringBuffer.append(' ');
                }
            }
        }
        while (!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

