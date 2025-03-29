import java.util.*;

class Solution {
    public static List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> result = new ArrayList <>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int pivot = 0; pivot < n; pivot++) {
            if (nums[pivot] > 0) {
                break;
            }
            if (pivot > 0 && nums[pivot] == nums[pivot - 1]){
                continue;
            }
            int low = pivot + 1;
            int high = n -1;
            while (low < high) {
                int total = nums[pivot] + nums[low] + nums[high];
                if (total < 0) {
                    low ++;
                }
                if (total > 0) {
                    high--;
                }
                else {
                    result.add(Arrays.asList(nums[pivot], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while ( low < high && nums[high] == nums[high + 1]){
                        high--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] testCases = {
                // Test Case 1: Basic case
                {-1, 0, 1, 2, -1, -4},
                // Test Case 2: No valid triplets
                {1, 2, 3, 4, 5},
                // Test Case 3: All zeros
                {0, 0, 0, 0},
                // Test Case 4: Mixed numbers with duplicates
                {-4, -1, -1, 0, 1, 2, 2},
                // Test Case 5: Large negative and positive range
                {-10, -7, -3, -1, 0, 3, 7, 10},
                // Test Case 6: All negative
                {-3, -5, -7, -9}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("\nTest Case " + (i + 1) + ":\n\tInput: " + Arrays.toString(nums));
            List<List<Integer>> result = threeSum(nums);
            System.out.print("\tOutput: ");
            System.out.println(result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}