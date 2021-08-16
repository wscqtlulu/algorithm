package algorithm.greedy;

//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//
// 每个孩子至少分配到 1 个糖果。
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
//
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？
//
//
//
// 示例 1：
//
//
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
//
//
// 示例 2：
//
//
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
// Related Topics 贪心 数组
// 👍 616 👎 0


//分发糖果
//leetcode submit region begin(Prohibit modification and deletion)
public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }

        int up = 1;
        int down = 1;
        int res = 0;
        //重复计算的谷底
        int sub = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] == ratings[i]){
                res = getRes(down, up, res);
                up = 1;
                down = 1;
                if (i == ratings.length - 1) {
                    int max = Math.max(down, up);
                    res += max;
                    return res - sub;
                }
            } else if (ratings[i - 1] < ratings[i]){
                //到达谷底
                if (down > 1) {
                    res = getRes(down, up, res);
                    up = 1;
                    down = 1;
                    sub++;
                }
                up++;
                if (i == ratings.length - 1) {
                    res = getRes(down, up, res);
                    return res - sub;
                }
            } else if (ratings[i - 1] > ratings[i]){
                down++;
                if (i == ratings.length - 1) {
                    res = getRes(down, up, res);
                    return res - sub;
                }
            }
        }
        return res - sub;
    }
    private int getRes(int down, int up, int res){
        res += Math.max(down, up);
        if ((down - 1) % 2 == 0) {
            res += down * (down / 2);
        } else {
            res += (down - 1) * ((down - 1) / 2) + (down - 1);
        }
        if ((up - 1) % 2 == 0) {
            res += up * (up / 2);
        } else {
            res += (up - 1) * ((up - 1) / 2) + (up - 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


