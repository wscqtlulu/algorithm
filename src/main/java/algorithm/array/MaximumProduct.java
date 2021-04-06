package algorithm.array;

//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：6
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4]
//输出：24
//
//
// 示例 3：
//
//
//输入：nums = [-1,-2,-3]
//输出：-6
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
//
// Related Topics 数组 数学


//三个数的最大乘积
//leetcode submit region begin(Prohibit modification and deletion)
class MaximumProduct {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        //最小
        int min1 = Integer.MAX_VALUE;
        //第二小
        int min2 = Integer.MAX_VALUE;
        //最大
        int max1 = Integer.MIN_VALUE;
        //第二大
        int max2 = Integer.MIN_VALUE;
        //第三大
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        //比较最小的两个数乘积*最大的数 与 最大的三个数的乘积
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

