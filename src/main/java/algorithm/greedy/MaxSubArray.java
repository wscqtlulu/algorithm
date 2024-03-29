package algorithm.greedy;

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


//leetcode submit region begin(Prohibit modification and deletion)
class MaxSubArray {

    //贪心解法
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > res) {
                res = Math.max(res, count);
            }
            if (count < 0) {
                count = 0;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

