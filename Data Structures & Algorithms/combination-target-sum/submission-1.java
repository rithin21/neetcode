class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int sum=0;
        int i=0;
        List<Integer>currlist=new ArrayList<>();
        backtrack(sum,i,nums,target,currlist);
        return ans;
    }

    public void backtrack(int sum,int i,int[]nums,int target,List<Integer>currlist){
        if(sum>target)
        {
            return;
        }
        else if(i==nums.length)
        {
            return;
        }
        else if(sum==target)
        {
            ans.add(new ArrayList<>(currlist));
            return;
        }
        currlist.add(nums[i]);
        backtrack(sum+nums[i],i,nums,target,currlist);
        currlist.remove(currlist.size()-1);
        backtrack(sum,i+1,nums,target,currlist);
    }
}
