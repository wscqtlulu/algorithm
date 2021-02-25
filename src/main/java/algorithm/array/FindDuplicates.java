package algorithm.array;

//给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//
// 找到所有出现两次的元素。
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
//
// 示例：
//
//
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
//
// Related Topics 数组


import java.util.ArrayList;
import java.util.List;

//数组中重复的数据
//leetcode submit region begin(Prohibit modification and deletion)
class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            while (nums[i] != i + 1) {
                if (nums[i] == -1) {
                    break;
                }
                if (nums[i] == nums[nums[i] - 1]) {
                    res.add(nums[i]);
                    nums[i] = -1;
                    break;
                }
                index = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return res;

//        int l = nums.length;
//        int index = 0;
//        while (index < l) {
//            int position = nums[index] - 1;
//            if (nums[index] == -1) {
//                index++;
//            } else if(index != position){
//                if(nums[index] == nums[position]){
//                    if (!res.contains(nums[index])){
//                        res.add(nums[index]);
//                    }
//                    nums[index] = -1;
//                    index++;
//                } else {
//                    int temp = nums[index];
//                    nums[index] = nums[position];
//                    nums[position] = temp;
//                }
//            } else {
//                index++;
//            }
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

