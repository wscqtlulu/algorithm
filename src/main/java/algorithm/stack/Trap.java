package algorithm.stack;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划 单调栈
// 👍 2637 👎 0


//接雨水
//leetcode submit region begin(Prohibit modification and deletion)
class Trap {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            int rH = height[i];
            for (int j = i + 1; j < height.length; j++) {
                rH = Math.max(rH, height[j]);
            }
            int lH = height[i];
            for (int j = i - 1; j >= 0; j--) {
                lH = Math.max(lH, height[j]);
            }
            int h = Math.min(lH, rH) - height[i];
            if (h < 0) {
                h = 0;
            }
            res += h;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

