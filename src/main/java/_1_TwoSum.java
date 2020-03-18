import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 7, 11, 15 };
		int target = 9;

		if (null != (twoSum(nums, target))) {
			for (int i : twoSum(nums, target)) {
				System.out.print(i + " ");
			}
		} else
			System.out.println("wrong Answer");
	}

	/**
	 * Approach 1: Brute Force Complexity Analysis
	 * 
	 * Time complexity : O(n^2). For each element, we try to find its complement by
	 * looping through the rest of array which takes O(n) time. Therefore, the time
	 * complexity is O(n^2).
	 * 
	 * Space complexity : O(1).
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	/**
	 * Approach 3: One-pass Hash Table It turns out we can do it in one-pass. While
	 * we iterate and inserting elements into the table, we also look back to check
	 * if current element's complement already exists in the table. If it exists, we
	 * have found a solution and return immediately.
	 * 
	 * Complexity Analysis:
	 * 
	 * Time complexity : O(n). We traverse the list containing n elements only once.
	 * Each look up in the table costs only O(1) time.
	 * 
	 * Space complexity : O(n). The extra space required depends on the number of
	 * items stored in the hash table, which stores at most n elements.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
