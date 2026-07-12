
class Solution {

    HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return findWays(nums, target, 0, 0);
    }

    public int findWays(int[] nums, int target, int index, int sum) {

        if (index == nums.length) {
            return (sum == target) ? 1 : 0;
        }

        String key = index + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = findWays(nums, target, index + 1, sum + nums[index]);
        int subtract = findWays(nums, target, index + 1, sum - nums[index]);

        int ans = add + subtract;

        memo.put(key, ans);

        return ans;
    }
}