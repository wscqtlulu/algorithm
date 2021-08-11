package algorithm.others;

//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2,4]
//输出：[2,3]
//
//
// 示例 2：
//
//
//输入：nums = [1,1]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104
//
// Related Topics 位运算 数组 哈希表 排序
// 👍 173 👎 0


import java.util.HashSet;
import java.util.Set;

//错误的集合
//leetcode submit region begin(Prohibit modification and deletion)
class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int setSum = 0;
        int realSum = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum += i + 1;
            realSum += nums[i];
            if (!set.contains(nums[i])) {
                setSum += nums[i];
                set.add(nums[i]);
            }
        }
        res[0] = realSum - setSum;
        res[1] = sum - setSum;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

