class Solution {
    public int minCut(String s) {

        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];

        for (int end = 0; end < n; end++) {

            dp[end] = end; 

            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) == s.charAt(end)
                        && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {

                    isPalindrome[start][end] = true;

                    if (start == 0) {
                        dp[end] = 0;
                    } else {
                        dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}