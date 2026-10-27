public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // XOR all elements in the array
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }

    // Optional: Main method to test the solution
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        int[] test1 = {2, 2, 1};
        System.out.println("Output 1: " + solver.singleNumber(test1)); // Expected: 1

        int[] test2 = {4, 1, 2, 1, 2};
        System.out.println("Output 2: " + solver.singleNumber(test2)); // Expected: 4

        int[] test3 = {1};
        System.out.println("Output 3: " + solver.singleNumber(test3)); // Expected: 1
    }
}
