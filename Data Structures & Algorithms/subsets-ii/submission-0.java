class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer>curr_list=new ArrayList<>();
        backtrack(0,curr_list,nums);
        return ans;
    }

    public void backtrack(int i,List<Integer>curr_list,int[]nums)
    {
        if(i==nums.length)
        {
            ans.add(new ArrayList<>(curr_list));
            return;
        }
        curr_list.add(nums[i]);
        backtrack(i+1,curr_list,nums);
        curr_list.remove(curr_list.size()-1);
        while(i<nums.length-1&&nums[i+1]==nums[i])
        {
            i++;
        }
        backtrack(i+1,curr_list,nums);
    }
}
