package algorithm.dynamicProgramming;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2796 👎 0


//最大子序和
//leetcode submit region begin(Prohibit modification and deletion)
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int l = nums.length;
//        int[] dp = new int[l];
//        dp[0] = nums[0];
        int dp1 = nums[0];
        int dp2 = 0;
        int res = dp1;
        for (int i = 1; i < l; i++) {
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            dp2 = Math.max(nums[i], dp1 + nums[i]);
            dp1 = dp2;
            res = Math.max(res, dp2);
        }
        return res;
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < l; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

