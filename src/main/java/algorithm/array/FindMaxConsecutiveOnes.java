package algorithm.array;

//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
//
//
// 示例：
//
//
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//
//
//
//
// 提示：
//
//
// 输入的数组只包含 0 和 1 。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组


//最大连续1的个数
//leetcode submit region begin(Prohibit modification and deletion)
class FindMaxConsecutiveOnes {
    int res = 0;
    int cur = 0;
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 1) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 0;
            }
        }
        return Math.max(res, cur);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

