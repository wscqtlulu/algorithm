package algorithm.search.binary;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 827 👎 0


//搜索插入位置
//leetcode submit region begin(Prohibit modification and deletion)
class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int hight = nums.length - 1;
        int low = 0;
        int mid = 0;
        while (hight >= low) {
            mid = low + (hight - low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if ((mid > 0 && nums[mid - 1] < target) || (mid == 0 && nums[mid] > target)){
                    return mid;
                }
                hight = mid - 1;
            } else {
                if ((mid < nums.length - 1 && nums[mid + 1] > target) || (mid == nums.length - 1 && nums[mid] < target)){
                    return mid + 1;
                }
                low = mid + 1;
            }
        }
        return mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

