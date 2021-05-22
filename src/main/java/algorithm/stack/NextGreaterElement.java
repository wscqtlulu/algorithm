package algorithm.stack;

//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
//
//
//
// 示例 1:
//
//
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
//
// 示例 2:
//
//
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length <= nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 104
// nums1和nums2中所有整数 互不相同
// nums1 中的所有整数同样出现在 nums2 中
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
// Related Topics 栈
// 👍 426 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//下一个更大元素
//leetcode submit region begin(Prohibit modification and deletion)
class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] res = new int[nums1.length];
//        List<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < nums2.length; i++) {
//            list.add(nums2[i]);
//        }
//        for (int i = 0; i < nums1.length; i++) {
//            int index  = list.indexOf(nums1[i]);
//            if (index == nums2.length - 1) {
//                res[i] = -1;
//            } else {
//                index++;
//                while (index <= nums2.length - 1 && nums2[index] <= nums1[i]){
//                    index++;
//                }
//                if (index > nums2.length - 1){
//                    res[i] = -1;
//                } else {
//                    res[i] = nums2[index];
//                }
//            }
//        }
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums2[0]);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
