package algorithm.backtrack;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
// Related Topics 数组 回溯
// 👍 699 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//组合
//leetcode submit region begin(Prohibit modification and deletion)
class Combine {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int n = 0;
    int k = 0;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        deal(1, new LinkedList<>());
        return res;
    }

    public void deal(int startIndex, LinkedList<Integer> list){
        if (list.size() == k) {
            List<Integer> l = new ArrayList<>(list);
            res.add(l);
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            list.add(i);
            deal(i + 1, list);
            list.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

