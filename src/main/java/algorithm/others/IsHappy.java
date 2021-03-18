package algorithm.others;

//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：
//
//
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果 可以变为 1，那么这个数就是快乐数。
//
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//
//
// 示例 2：
//
//
//输入：n = 2
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= n <= 231 - 1
//
// Related Topics 哈希表 数学


import java.util.HashSet;

//快乐数
//leetcode submit region begin(Prohibit modification and deletion)
class IsHappy {
    public boolean isHappy(int n) {
        HashSet set = new HashSet();
        set.add(n);
        while (n != 1) {
            int sum = 0;
            while (n / 10 != 0) {

                int t = n % 10;
                sum = sum + t * t;
                n = n / 10;
            }
            int t = n % 10;
            n = sum + t * t;
            if (set.contains(n)){
                return false;
            }
            set.add(n);
        }

        return true;

//        if (n < 10) {
//            if (n != 1) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//        int res = 0;
//        int i1 = n%10;
//        n = n/10;
//        while (n > 9) {
//            i1 *= i1;
//            res += i1;
//            i1 = n%10;
//            n = n/10;
//        }
//        n *= n;
//        res += n;
//        return isHappy(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

