package algorithm.greedy;

//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 假设你总是可以到达数组的最后一个位置。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
//
// Related Topics 贪心 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Jump {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //覆盖边界
        int cover = nums[0];
        //当前覆盖边界
        int curSide = cover;
        //边界
        int side = nums.length - 1;
        int step = 1;
        if (cover >= side) {
            return step;
        }
        for (int i = 1; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            //已覆盖到达边界
            if (cover >= side) {
                //当前位置不在最后边界，走一步直接到边界
                if (i < side) {
                    step++;
                }
                return step;
            }
            //当前位置到达当前边界位置
            if (i >= curSide) {
                step++;
                curSide = cover;
            }
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

