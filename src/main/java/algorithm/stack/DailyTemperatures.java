package algorithm.stack;

//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100
//
// Related Topics 栈 数组 单调栈
// 👍 854 👎 0


import java.util.Stack;

//每日温度
//leetcode submit region begin(Prohibit modification and deletion)
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

