package algorithm.array;

//你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
//
// 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
//
//
// 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
// 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
// 如果 k == 0 ，将第 i 个数字用 0 替换。
//
//
// 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
//
// 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
//
//
//
// 示例 1：
//
//
//输入：code = [5,7,1,4], k = 3
//输出：[12,10,16,13]
//解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
//
//
// 示例 2：
//
//
//输入：code = [1,2,3,4], k = 0
//输出：[0,0,0,0]
//解释：当 k 为 0 时，所有数字都被 0 替换。
//
//
// 示例 3：
//
//
//输入：code = [2,4,9,3], k = -2
//输出：[12,5,6,13]
//解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
//
//
//
//
// 提示：
//
//
// n == code.length
// 1 <= n <= 100
// 1 <= code[i] <= 100
// -(n - 1) <= k <= n - 1
//
// Related Topics 数组
// 👍 6 👎 0


//拆炸弹
//leetcode submit region begin(Prohibit modification and deletion)
class Decrypt {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0){
            return res;
        }
        int l = code.length;
        for (int i = 0; i < l; i++) {
            int sum = 0;
            int absK = Math.abs(k);
            if (k > 0) {
                int pos = i + 1 + k;
                for (int j = i + 1; j < pos; j++) {
                    if (j >= l) {
                        sum += code[j - l];
                    } else {
                        sum += code[j];
                    }
                }
                res[i] = sum;
                sum = 0;
            } else if (k < 0) {
                int neg = i - 1 + k;
                for (int j = i - 1; j > neg; j--) {
                    if (j < 0) {
                        sum += code[j + l];
                    } else {
                        sum += code[j];
                    }
                }
                res[i] = sum;
                sum = 0;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

