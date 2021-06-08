package algorithm.search.binary;

//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
// 示例 1:
//
//
//输入: [1,1,2,3,3,4,4,8,8]
//输出: 2
//
//
// 示例 2:
//
//
//输入: [3,3,7,7,10,11,11]
//输出: 10
//
//
// 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
// Related Topics 二分查找


//有序数组中的单一元素
//leetcode submit region begin(Prohibit modification and deletion)
class SingleNonDuplicate {
    int res = -1;
    public int singleNonDuplicate(int[] nums) {
        deal(0, nums.length - 1, nums);
        return res;
    }
    public void deal(int l, int r, int[] nums){
        if (l == r) {
            res = nums[l];
            return;
        }
        int mid = l + (r - l)/2;
        if (mid % 2 == 0) {
            if (mid != 0 && mid != nums.length - 1) {
                if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]){
                    res = nums[mid];
                    return;
                } else if (nums[mid - 1] != nums[mid]) {
                    deal(mid + 1, r, nums);
                } else {
                    deal(l, mid - 1, nums);
                }
            } else if (mid == 0){
                if (nums[mid] != nums[mid + 1]){
                    res = nums[mid];
                    return;
                } else {
                    deal(mid + 1, r, nums);
                }
            } else {
                if (nums[mid] != nums[mid - 1]){
                    res = nums[mid];
                    return;
                } else {
                    deal(l, mid - 1, nums);
                }
            }
        } else {
            if (mid != 0 && mid != nums.length - 1) {
                if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]){
                    res = nums[mid];
                    return;
                } else if (nums[mid - 1] != nums[mid]) {
                    deal(l, mid - 1, nums);
                } else {
                    deal(mid + 1, r, nums);
                }
            } else if (mid == 0){
                if (nums[mid] != nums[mid + 1]){
                    res = nums[mid];
                    return;
                } else {
                    deal(mid + 1, r, nums);
                }
            } else {
                if (nums[mid] != nums[mid - 1]){
                    res = nums[mid];
                    return;
                } else {
                    deal(l, mid - 1, nums);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

