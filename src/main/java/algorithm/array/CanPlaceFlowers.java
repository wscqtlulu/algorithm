package algorithm.array;

//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
//
//
//
// 示例 1：
//
//
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
//
//
// 示例 2：
//
//
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= flowerbed.length <= 2 * 104
// flowerbed[i] 为 0 或 1
// flowerbed 中不存在相邻的两朵花
// 0 <= n <= flowerbed.length
//
// Related Topics 贪心算法 数组


//种花问题
//leetcode submit region begin(Prohibit modification and deletion)
class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int l = flowerbed.length;
        if (l < 2) {
            if (l == 1 && n < 2 && flowerbed[0] == 0) {
                return true;
            } else if (l == 0 && n == 0){
                return true;
            } else {
                return false;
            }
        }

        int pre = 0;
        for (int i = 0; i < l; i++) {
            //当前是1
            if (flowerbed[i] == 1) {
                pre = 1;
            }
            //当前是0
            else {
                //前一个是0
                if (pre != 1) {
                    if (i + 1 >= l) {
                        n--;
                        if (n <= 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    //后一个是0
                    else if (flowerbed[i + 1] == 0){
                        n--;
                        if (n <= 0) {
                            return true;
                        }
                        pre = 1;
                    }
                }
                //前一个是1
                else {
                    pre = 0;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

