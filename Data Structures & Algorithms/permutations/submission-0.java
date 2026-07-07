class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new HashSet<>(),new ArrayList<Integer>());
        return ans;
        
    }

    public void backtrack(int[]nums,Set<Integer>set,ArrayList<Integer>curr_list)
    {
        if(curr_list.size()==nums.length)
        {
            ans.add(new ArrayList<>(curr_list));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(i))
            {
                continue;
            }
            set.add(i);
            curr_list.add(nums[i]);
            backtrack(nums,set,curr_list);
            int x=curr_list.get(curr_list.size()-1);
            curr_list.remove(curr_list.size()-1);
            set.remove(i);
        }
    }
}
