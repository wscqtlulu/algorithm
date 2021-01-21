package algorithm.backtrack;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Permute {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<Integer>();
        permute(nums, trace);
        return res;
    }
    public void permute(int[] nums, LinkedList<Integer> trace){
        if (trace.size() == nums.length){
            res.add(new LinkedList<Integer>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!trace.contains(nums[i])){
                trace.add(nums[i]);
                permute(nums, trace);
                trace.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
