class Solution {

    List<List<Integer>>result=new ArrayList<>();
    List<Integer>currentsubset=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums,target,0,0);
        return result;
    }
    void backtrack(int[]nums,int target,int index,int sum)
    {
        if(sum==target)
        {
            result.add(new ArrayList<>(currentsubset));
            return;
        }
        if(sum>target||index>nums.length-1)
        {
            return;
        }
        currentsubset.add(nums[index]);
        backtrack(nums,target,index,sum+nums[index]);
        currentsubset.remove(currentsubset.size()-1);
        backtrack(nums,target,index+1,sum);
    }
        
}
