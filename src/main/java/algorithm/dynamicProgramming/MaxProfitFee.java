package algorithm.dynamicProgramming;

//买卖股票的最佳时机含手续费
public class MaxProfitFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) {
            return 0;
        }
        //动态规划
        //第几天、是否持有、收益
        int[][] dp = new int[2][2];
        //第一天不持有，收益0
        dp[0][0] = 0;
        //第一天持有，需要按照第一天股票价格买进，收益-prices[0]
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[i] - fee);
            dp[1][1] = Math.max(dp[0][0] - prices[i], dp[0][1]);
            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
        }
        return dp[1][0];
    }
}
