class Solution {

    List<List<Integer>>result=new ArrayList<>();
    List<Integer>currentsubset=new ArrayList<>();
    int[]nums;


    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        backtrack(0);
        return result;    
    }

    void backtrack(int index)
    {
        if(index==nums.length)
        {
            result.add(new ArrayList<Integer>(currentsubset));
            return;
        }

        backtrack(index+1);
        
        currentsubset.add(nums[index]);
        backtrack(index+1);

        currentsubset.remove(currentsubset.size()-1);
    }
}
