package algorithm.stack;

public class NextGreaterElements2 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
