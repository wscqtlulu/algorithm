package algorithm.others;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//
//
// 提示：
//
//
// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
//
// Related Topics 字符串
// 👍 381 👎 0


//字符串相加
//leetcode submit region begin(Prohibit modification and deletion)
class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuffer stringBuffer = new StringBuffer();
        int res = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || res != 0) {
            if (i >= 0) {
                res += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                res += num2.charAt(j--) - '0';
            }
            stringBuffer.append(res%10);
            res = res/10;
        }
        return stringBuffer.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

