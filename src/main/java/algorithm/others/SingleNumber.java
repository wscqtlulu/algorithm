package algorithm.others;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 哈希表
// 👍 1699 👎 0



//只出现一次的数字
//leetcode submit region begin(Prohibit modification and deletion)
class SingleNumber {
    public int singleNumber(int[] nums) {

        //异或运算
        //归零律：a ⊕ a = 0
        //恒等律：a ⊕ 0 = a
        //交换律：a ⊕ b = b ⊕ a
        //结合律：a ⊕ b ⊕ c = a ⊕ (b ⊕ c) = (a ⊕ b) ⊕ c
        //自反：a ⊕ b ⊕ a = b
        //0异或任意数等于任意数
        //相同的数异或等于0，不同的数异或等于1
        //0 ⊕ a ⊕ b ⊕ c ⊕ a ⊕ b = 0 ⊕ a ⊕ a ⊕ b ⊕ b ⊕ c = 0 ⊕ c = c

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

