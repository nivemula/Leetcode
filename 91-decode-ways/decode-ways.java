class Solution {
    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]

        for (int i = 1; i < s.length(); i++) {

            int curr = 0;

            // single digit
            if (s.charAt(i) != '0') {
                curr += prev1;
            }

            // two digits
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}