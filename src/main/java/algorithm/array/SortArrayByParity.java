package algorithm.array;

//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
// 你可以返回满足此条件的任何数组作为答案。
//
//
//
// 示例：
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
// Related Topics 数组


//按奇偶排序数组
//leetcode submit region begin(Prohibit modification and deletion)
class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            if (nums[i] % 2 != 0) {
                while (index < nums.length && nums[index] % 2 != 0) {
                    index++;
                }
                if (index >= nums.length) {
                    return nums;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                if (index == nums.length){
                    return nums;
                }
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

