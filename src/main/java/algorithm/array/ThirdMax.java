package algorithm.array;

//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
//
//
//
// 示例 1：
//
//
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。
//
// 示例 2：
//
//
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
//
//
// 示例 3：
//
//
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
//
//
//
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
// Related Topics 数组


//第三大的数
//leetcode submit region begin(Prohibit modification and deletion)
class ThirdMax {

    Integer n1,n2,n3;

    public int thirdMax(int[] nums) {

        n1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (n2 == null) {
                if (n1 != nums[i]){
                    if (n1 < nums[i]){
                        n2 = nums[i];
                    } else {
                        n2 = n1;
                        n1 = nums[i];
                    }
                }
            } else if (n3 == null) {
                if (n1 != nums[i] && n2 != nums[i]){
                    if (nums[i] > n2) {
                        n3 = nums[i];
                    } else if (nums[i] > n1) {
                        n3 = n2;
                        n2 = nums[i];
                    } else {
                        n3 = n2;
                        n2 = n1;
                        n1 = nums[i];
                    }
                }
            } else {
                if (nums[i] != n1 && nums[i] != n2 && nums[i] != n3){
                    if (nums[i] > n3) {
                        n1 = n2;
                        n2 = n3;
                        n3 = nums[i];
                    } else if (nums[i] > n2) {
                        n1 = n2;
                        n2 = nums[i];
                    } else if (nums[i] > n1) {
                        n1 = nums[i];
                    }
                }
            }
        }
        //System.out.println("n1:" + n1 + " n2:" + n2 + " n3:" + n3);
        return n3 == null ? (n2 == null ? n1 : n2) : n1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

