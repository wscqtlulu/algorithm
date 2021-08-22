package algorithm.greedy;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
//
//
// 示例：
//
//
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//
//
//
// 提示：
//
//
// S的长度在[1, 500]之间。
// S只包含小写字母 'a' 到 'z' 。
//
// Related Topics 贪心 哈希表 双指针 字符串
// 👍 547 👎 0


import java.util.LinkedList;
import java.util.List;

//划分字母区间
//leetcode submit region begin(Prohibit modification and deletion)
class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] edge = new int[123];
        for (int i = 0; i < s.length(); i++) {
            edge[s.charAt(i) - 0] = i;
        }
        List<Integer> list = new LinkedList<>();
        int last = -1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            index = Math.max(edge[s.charAt(i) - 0], index);
            if (index == i) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

