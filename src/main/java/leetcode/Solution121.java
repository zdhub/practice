package leetcode;

/***
 * 股票交易问题1
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *               max( 今天选择 rest,        今天选择 sell       )
 *
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *               max( 今天选择 rest,         今天选择 buy         )
 */

@Easy
public class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            if( i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],  -prices[i]);
        }
        return dp[n-1][0];
    }
}
