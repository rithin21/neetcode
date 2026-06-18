class Solution {
    public int maxProduct(int[] nums) {

        int[] maxpdt = new int[nums.length];
        int[] minpdt = new int[nums.length];

        maxpdt[0] = nums[0];
        minpdt[0] = nums[0];

        int ans = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            maxpdt[i] = Math.max(
                nums[i],
                Math.max(
                    nums[i] * maxpdt[i-1],
                    nums[i] * minpdt[i-1]
                )
            );

            minpdt[i] = Math.min(
                nums[i],
                Math.min(
                    nums[i] * maxpdt[i-1],
                    nums[i] * minpdt[i-1]
                )
            );

            ans = Math.max(ans, maxpdt[i]);
        }

        return ans;
    }
}