class Solution {
    public int rob(int[] nums) {
        int prev1=0;
        int prev2=0;
        int maxamt=0;
        for(int i=0;i<nums.length;i++)
        {
            maxamt=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=maxamt;
        }
        return maxamt;
        
    }
}
