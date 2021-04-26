package algorithm.stack;

//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//
// 注意：n 的值小于15000。
//
// 示例1:
//
//
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
//
//
// 示例 2:
//
//
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
//
//
// 示例 3:
//
//
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
//
// Related Topics 栈


import java.util.Stack;

//132模式
//leetcode submit region begin(Prohibit modification and deletion)
class Find132pattern {
    public boolean find132pattern(int[] nums) {
//        if (nums.length < 3){
//            return false;
//        }
//        int index1 = 0;
//        int index2 = 1;
//        int index3 = 2;
//        int l = nums.length;
//        while (index1 < l) {
//            int num1 = nums[index1];
//            index2 = index1 + 1;
//            while (index2 < l) {
//                if (nums[index2] > num1 + 1) {
//                    int num2 = nums[index2];
//                    index3 = index2 + 1;
//                    while (index3 < l) {
//                        int num3 = nums[index3];
//                        if (num3 > num1 && num3 < num2) {
//                            return true;
//                        }
//                        index3++;
//                    }
//                }
//                index2++;
//            }
//            index1++;
//        }
        int l = nums.length;
        int two = Integer.MIN_VALUE;
        Stack<Integer> thr = new Stack<Integer>();
        for (int i = l - 1; i >= 0; i--) {
            if (nums[i] < two){
                return true;
            }
            while (!thr.isEmpty() && thr.peek() < nums[i]){
                two = thr.pop();
            }
            thr.push(nums[i]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

