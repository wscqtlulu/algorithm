package algorithm.others;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Yanghui {
    public List<List<Integer>> generate(int numRows) {
        int[][] intList = new int[numRows][numRows];
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                int left = 0;
                int right = 0;
                if (i - 1 >= 0){
                    if (j - 1 >= 0){
                        left = intList[i - 1][j - 1];
                    }
                    if (j < i){
                        right = intList[i - 1][j];
                    }
                }
                if (left == 0 && right == 0){
                    intList[i][j] = 1;
                    list.add(1);
                } else {
                    intList[i][j] = left + right;
                    list.add(left + right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

