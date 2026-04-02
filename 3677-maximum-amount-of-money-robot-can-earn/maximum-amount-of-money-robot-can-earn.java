import java.util.*;

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        // initialize with very small value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        // start position
        for (int k = 0; k < 3; k++) {
            if (coins[0][0] >= 0) {
                dp[0][0][k] = coins[0][0];
            } else {
                if (k > 0) dp[0][0][k] = 0; // neutralize
                else dp[0][0][k] = coins[0][0];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {

                    int best = Integer.MIN_VALUE;

                    // from top
                    if (i > 0) {
                        best = Math.max(best, dp[i-1][j][k]);
                    }

                    // from left
                    if (j > 0) {
                        best = Math.max(best, dp[i][j-1][k]);
                    }

                    if (best == Integer.MIN_VALUE) continue;

                    // take normally
                    dp[i][j][k] = Math.max(dp[i][j][k], best + coins[i][j]);

                    // neutralize if negative
                    if (coins[i][j] < 0 && k > 0) {
                        int prev = Integer.MIN_VALUE;

                        if (i > 0) prev = Math.max(prev, dp[i-1][j][k-1]);
                        if (j > 0) prev = Math.max(prev, dp[i][j-1][k-1]);

                        if (prev != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], prev);
                        }
                    }
                }
            }
        }

        return Math.max(dp[m-1][n-1][0],
               Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}