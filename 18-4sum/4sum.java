class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) { // Define the method to find quadruplets
        List<List<Integer>> res = new ArrayList<>(); // Initialize the result list
        Arrays.sort(nums); // Sort the array to use two-pointer technique and handle duplicates
        int n = nums.length; // Get the length of the array

        for (int i = 0; i < n - 3; i++) { // Loop for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate for the first number
            for (int j = i + 1; j < n - 2; j++) { // Loop for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicate for the second number
                int left = j + 1; // Initialize left pointer
                int right = n - 1; // Initialize right pointer
                while (left < right) { // While pointers do not cross
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right]; // Calculate the sum, use long to avoid overflow
                    if (sum == target) { // If sum matches target
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right])); // Add quadruplet to result
                        while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicate for left
                        while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicate for right
                        left++; // Move left pointer
                        right--; // Move right pointer
                    } else if (sum < target) { // If sum is less than target
                        left++; // Move left pointer to increase sum
                    } else { // If sum is greater than target
                        right--; // Move right pointer to decrease sum
                    }
                }
            }
        }
        return res; // Return the result list
    }
}