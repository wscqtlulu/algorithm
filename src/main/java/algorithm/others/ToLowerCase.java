package algorithm.others;

//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//
//
//
// 示例 1：
//
//
//输入: "Hello"
//输出: "hello"
//
// 示例 2：
//
//
//输入: "here"
//输出: "here"
//
// 示例 3：
//
//
//输入: "LOVELY"
//输出: "lovely"
//
// Related Topics 字符串
// 👍 148 👎 0


//转换成小写字母
//leetcode submit region begin(Prohibit modification and deletion)
class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                stringBuffer.append((char) (str.charAt(i) - ('A' - 'a')));
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

