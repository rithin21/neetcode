class Solution {

    HashMap<String, Boolean> cache = new HashMap<>();

    int[] nums;
    int target;

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums)
        {
            sum += num;
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        this.nums = nums;
        this.target = sum / 2;

        return dfs(0, 0);
    }

    public boolean dfs(int index, int currentSum)
    {
        if(currentSum == target)
        {
            return true;
        }

        if(currentSum > target)
        {
            return false;
        }

        if(index == nums.length)
        {
            return false;
        }

        String key = index + "," + currentSum;

        if(cache.containsKey(key))
        {
            return cache.get(key);
        }

        boolean take =
                dfs(index + 1,
                    currentSum + nums[index]);

        boolean skip =
                dfs(index + 1,
                    currentSum);

        boolean result = take || skip;

        cache.put(key, result);

        return result;
    }
}