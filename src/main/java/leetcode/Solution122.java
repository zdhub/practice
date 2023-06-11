package leetcode;

/**
 * 依旧是股票交易问题
 * 和121不一样的地方在于，这里的dp[i][1] 后面的 第二项不能被省略，因为交易可以任意次
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // dp[i-1][0]在121题中是0，所以可以省略
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
