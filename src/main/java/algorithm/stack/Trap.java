package algorithm.stack;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划 单调栈
// 👍 2637 👎 0


import java.util.Stack;

//接雨水
//leetcode submit region begin(Prohibit modification and deletion)
class Trap {
    public int trap(int[] height) {
//        int res = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (i == 0 || i == height.length - 1) {
//                continue;
//            }
//            int rH = height[i];
//            for (int j = i + 1; j < height.length; j++) {
//                rH = Math.max(rH, height[j]);
//            }
//            int lH = height[i];
//            for (int j = i - 1; j >= 0; j--) {
//                lH = Math.max(lH, height[j]);
//            }
//            int h = Math.min(lH, rH) - height[i];
//            if (h < 0) {
//                h = 0;
//            }
//            res += h;
//        }
//        return res;

//        int res = 0;
//        int[] rH = new int[height.length];
//        rH[height.length - 1] = height[height.length - 1];
//        for (int j = height.length - 2; j > 0; j--) {
//            rH[j] = Math.max(rH[j + 1], height[j]);
//        }
//        int[] lH = new int[height.length];
//        lH[0] = height[0];
//        for (int j = 1; j < height.length; j++) {
//            lH[j] = Math.max(lH[j - 1], height[j]);
//        }
//        for (int i = 0; i < height.length; i++) {
//            if (i == 0 || i == height.length - 1) {
//                continue;
//            }
//            int h = Math.min(lH[i], rH[i]) - height[i];
//            if (h < 0) {
//                h = 0;
//            }
//            res += h;
//        }
//        return res;

        //单调栈解法
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (height[i] < height[stack.peek()]){
                    stack.push(i);
                } else if (height[i] == height[stack.peek()]){
                    stack.pop();
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                        int mid = stack.pop();
                        if (!stack.isEmpty()) {
                            int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                            int w = i - stack.peek() - 1;
                            res += h * w;
                        }
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

