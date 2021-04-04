package algorithm.array;

//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 347 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//两个数组的交集
//leetcode submit region begin(Prohibit modification and deletion)
class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        int start = 0;
        for (int i : set2) {
            res[start] = i;
            start++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
