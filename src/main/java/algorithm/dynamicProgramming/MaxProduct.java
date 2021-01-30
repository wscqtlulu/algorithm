package algorithm.dynamicProgramming;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划


//乘积最大子数组
//leetcode submit region begin(Prohibit modification and deletion)
class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length < 1){
            return 0;
        }
        //最大值*负数可能变为最小值，最小值*负数可能变为最大值

        //以i为结尾的子串的最大值
        int[] max = new int[nums.length];
        //以i为结尾的子串的最小值
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
        }
        int res = max[0];
        for (int i = 0; i < max.length; i++) {
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
