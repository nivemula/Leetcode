import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // size 0 rhombus (single cell)
                set.add(grid[i][j]);

                // try larger rhombuses
                for (int k = 1; i + 2*k < m && j - k >= 0 && j + k < n; k++) {
                    int sum = 0;
                    // top to right
                    for (int t = 0; t < k; t++) sum += grid[i+t][j+t];
                    // right to bottom
                    for (int t = 0; t < k; t++) sum += grid[i+k+t][j+k-t];
                    // bottom to left
                    for (int t = 0; t < k; t++) sum += grid[i+2*k-t][j-t];
                    // left to top
                    for (int t = 0; t < k; t++) sum += grid[i+k-t][j-k+t];

                    set.add(sum);
                }
            }
        }

        // convert to array and sort descending
        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        int len = arr.length;
        int resLen = Math.min(3, len);
        int[] res = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            res[i] = arr[len-1-i];
        }

        return res;
    }
}