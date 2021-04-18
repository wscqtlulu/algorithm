package algorithm.array;

//包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值
//求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
//
// 示例 1:
//
//
//输入:
//[[1,1,1],
// [1,0,1],
// [1,1,1]]
//输出:
//[[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
//
//
// 注意:
//
//
// 给定矩阵中的整数范围为 [0, 255]。
// 矩阵的长和宽的范围均为 [1, 150]。
//
// Related Topics 数组


//图片平滑器
//leetcode submit region begin(Prohibit modification and deletion)
class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0){
            return M;
        }
        int[][] res = new int[M.length][M[0].length];
        int mL = M.length;
        int mmL = M[0].length;
        for (int i = 0; i < mL; i++) {
            int c = 9;
            int real = 0;
            for (int j = 0; j < mmL; j++) {
                real += M[i][j];
                if (i == 0){
                    c--;
                } else {
                    real += M[i - 1][j];
                }
                if (j == 0){
                    c--;
                } else {
                    real += M[i][j - 1];
                }
                if (i == mL - 1) {
                    c--;
                } else {
                    real += M[i + 1][j];
                }
                if (j == mmL - 1) {
                    c--;
                } else {
                    real += M[i][j + 1];
                }

                if (i != 0 && j != 0) {
                    real += M[i - 1][j - 1];
                } else {
                    c--;
                }
                if (i != mL - 1 && j != mmL - 1) {
                    real += M[i + 1][j + 1];
                } else {
                    c--;
                }
                if (i != 0 && j != mmL - 1) {
                    real += M[i - 1][j + 1];
                } else {
                    c--;
                }
                if (i != mL - 1 && j != 0) {
                    real += M[i + 1][j - 1];
                } else {
                    c--;
                }
                System.out.println("real:" + real);
                System.out.println("c:" + c);
                if (real/c < 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = 1;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

