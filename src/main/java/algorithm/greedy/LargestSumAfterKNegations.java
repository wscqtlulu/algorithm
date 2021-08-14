package algorithm.greedy;

import java.util.Arrays;

public class LargestSumAfterKNegations {
    //先排序，对负数取反，如果所有负数都变成了正数，重新排序，对最小一位连续反转
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                if (k > 0) {
                    nums[i] = -nums[i];
                    k--;
                } else {
                    break;
                }
            } else {
                if (k > 0) {
                    break;
                }
            }
        }
        if (k > 0) {
            Arrays.sort(nums);
            int l  = k;
            for (int i = 0; i < l; i++) {
                nums[0] = -nums[0];
                k--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
