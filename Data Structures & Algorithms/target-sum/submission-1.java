class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        findways(nums,target,0,0);
        return count;
    }

    public void findways(int[]nums,int target,int index,int sum){
        if(index==nums.length&&sum==target){
            count++;
            return;
        }
        if(index==nums.length){
            return;
        }
        findways(nums,target,index+1,sum+nums[index]);
        findways(nums,target,index+1,sum-nums[index]);
    }
}
