package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 获取硬币的最小数量
 * 我的coinChange算法一直没有成功通过，而且还很耗费时间，代码也不优雅
 * Leetcode上大家的解法，只用到了一维数组（dp）,而且其实不用排序，非常简单和优雅
 */
@Medium
class Solution322 {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] coins = new int[]{186,419,83,408};
        Arrays.sort(coins);
        int result = solution322.coinChange(coins, 6249);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[][] coinChange = new int[coins.length][amount];

        for (int j = 0; j < amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j + 1 < coins[i]) {
                    coinChange[i][j] = -1;
                } else if ((j + 1) == coins[i]) {
                    coinChange[i][j] = 1;
                } else {
                    int beforeMin = GetMin(coinChange, coins, j+1);
                    coinChange[i][j] = beforeMin == -1 ? -1 : beforeMin + 1;
                }
            }
        }
        return GetColumn(coinChange, amount);
    }

    public int GetMin(int[][] coinChange, int[] coins, int column) {
        if (column > coinChange[0].length) {
            return -1;
        }
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < column) {
                int toCheckColumn = column - coins[i];
                int tempMin = GetColumn(coinChange, toCheckColumn);
                if (tempMin == -1) {
                    return -1;
                }
                if (tempMin < minNumber){
                    minNumber = tempMin;
                }
            }
        }
        return minNumber;
    }

    public int GetColumn(int[][] coinChange, int column) {
        int min = coinChange[0][column-1];
        for (int i = 0; i < coinChange.length; i++) {
            if (coinChange[i][column-1] == -1){
                continue;
            }
            if (coinChange[i][column-1] < min) {
                min = coinChange[i][column-1];
            }
        }
        return min;
    }

    /**
     * 方式二：带备忘录的动态规划方法
     * 动态规划式的解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeV1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for(int i = 1; i < dp.length; i++){
            dp[i] = dp.length;
            for(int j = 0; j < coins.length; j++){
                if(i>=coins[j]) dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        return dp[amount] == dp.length ? -1 : dp[amount];
    }


    /**
     *
     * 方式一：不带备忘录的穷举法
     *
     * public int coinChange(int[] coins, int amount){
     *      return dp(coins, amount)
     * }
     *
     * 这个就是核心的dp伪代码，需要做的就是补充退出条件
     * public int dp(int[] coins, int n){
     *     for(int coin : coins){
     *         res = min(res, 1 + dp(coins, n - coin))
     *     }
     *     return res
     * }
     */
}
