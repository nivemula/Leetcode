class Solution {
    public long[] distance(int[] nums) {

        int n = nums.length;
        long[] result = new long[n];

        // Step 1: group indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: process each group
        for (List<Integer> list : map.values()) {

            int size = list.size();
            long[] prefix = new long[size];

            // prefix sum of indices
            prefix[0] = list.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < size; i++) {

                int idx = list.get(i);

                long left = 0;
                if (i > 0) {
                    left = (long) idx * i - prefix[i - 1];
                }

                long right = 0;
                if (i < size - 1) {
                    right = (prefix[size - 1] - prefix[i]) - (long) idx * (size - i - 1);
                }

                result[idx] = left + right;
            }
        }

        return result;
    }
}