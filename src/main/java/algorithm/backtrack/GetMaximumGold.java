package algorithm.backtrack;

//你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄
//金数量；如果该单元格是空的，那么就是 0。
//
// 为了使收益最大化，矿工需要按以下规则来开采黄金：
//
//
// 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
// 矿工每次可以从当前位置向上下左右四个方向走。
// 每个单元格只能被开采（进入）一次。
// 不得开采（进入）黄金数目为 0 的单元格。
// 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
//
//
//
//
// 示例 1：
//
// 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
//输出：24
//解释：
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//一种收集最多黄金的路线是：9 -> 8 -> 7。
//
//
// 示例 2：
//
// 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//输出：28
//解释：
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
//
//
//
//
// 提示：
//
//
// 1 <= grid.length, grid[i].length <= 15
// 0 <= grid[i][j] <= 100
// 最多 25 个单元格中有黄金。
//
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//黄金矿工
//leetcode submit region begin(Prohibit modification and deletion)
class GetMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        int[][] selected = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 0){
                    continue;
                }
                selected[row][col] = 1;
                int total = backTrace(grid, row, col, selected, 0);
                selected[row][col] = 0;
                max = Math.max(total, max);
            }
        }
        return max;
    }
    public int backTrace(int[][] grid, int row, int col, int[][] selected, int sumV){
        sumV += grid[row][col];
        //up
        int upV = row - 1 < 0 ? 0 : grid[row - 1][col];
        boolean upS = row - 1 < 0 ? true : selected[row - 1][col] == 1 ? true : false;
        //down
        int downV = row + 1 > grid.length - 1 ? 0 : grid[row + 1][col];
        boolean downS = row + 1 > grid.length - 1 ? true : selected[row + 1][col] == 1 ? true : false;
        //left
        int leftV = col - 1 < 0 ? 0 : grid[row][col - 1];
        boolean leftS = col - 1 < 0 ? true : selected[row][col - 1] == 1 ? true : false;
        //right
        int rightV = col + 1 > grid[row].length - 1 ? 0 : grid[row][col + 1];
        boolean rightS = col + 1 > grid[row].length - 1 ? true : selected[row][col + 1] == 1 ? true : false;

        //各方向都不能走，结束
        if ((upV <= 0 || upS) && (downV <= 0 || downS) && (leftV <= 0 || leftS) && (rightV <= 0 || rightS)){
            return sumV;
        }

        int upSum = 0;
        if (upV > 0 && !upS){
            selected[row - 1][col] = 1;
            upSum = backTrace(grid, row - 1, col, selected, sumV);
            selected[row - 1][col] = 0;
        }
        int downSum = 0;
        if (downV > 0 && !downS){
            selected[row + 1][col] = 1;
            downSum = backTrace(grid, row + 1, col, selected, sumV);
            selected[row + 1][col] = 0;
        }
        int leftSum = 0;
        if (leftV > 0 && !leftS){
            selected[row][col - 1] = 1;
            leftSum = backTrace(grid, row, col - 1, selected, sumV);
            selected[row][col - 1] = 0;
        }
        int rightSum = 0;
        if (rightV > 0 && !rightS){
            selected[row][col + 1] = 1;
            rightSum = backTrace(grid, row, col + 1, selected, sumV);
            selected[row][col + 1] = 0;
        }
        return Math.max(Math.max(Math.max(upSum, downSum), leftSum), rightSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

