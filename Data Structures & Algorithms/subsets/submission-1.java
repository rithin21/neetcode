class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer>curr_list=new ArrayList<>();
        rec_call(nums,0,curr_list);
        return ans;  
    }

    public void rec_call(int[]nums,int i,List <Integer>curr_list)
    {
        if(i==nums.length)
        {
            ans.add(new ArrayList<>(curr_list));
            return;
        }
        curr_list.add(nums[i]);
        rec_call(nums,i+1,curr_list);
        curr_list.remove(curr_list.size()-1);
        rec_call(nums,i+1,curr_list);
    }
}
