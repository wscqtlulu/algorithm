package algorithm.greedy;
//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
//
// 示例 1:
//
// 输入: N = 10
//输出: 9
//
//
// 示例 2:
//
// 输入: N = 1234
//输出: 1234
//
//
// 示例 3:
//
// 输入: N = 332
//输出: 299
//
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。
// Related Topics 贪心 数学
// 👍 198 👎 0


//单调递增的数字
//leetcode submit region begin(Prohibit modification and deletion)
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String[] strings = String.valueOf(n).split("");
        if (strings.length < 2){
            return n;
        }
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.valueOf(strings[i - 1]) > Integer.valueOf(strings[i])){
                strings[i - 1] = String.valueOf(Integer.valueOf(strings[i - 1]) - 1);
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("", strings));
    }
}
