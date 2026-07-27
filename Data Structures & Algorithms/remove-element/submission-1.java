class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int count=0;
        TreeSet<Integer>indices=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]==val){
                nums[i]=-1;
                indices.add(i);
                count++;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=-1){
                //swap with the -1 index
                if(!indices.isEmpty()&&indices.first()<i){
                    int temp=nums[i];
                    nums[i]=-1;
                    nums[indices.first()]=temp;
                    indices.pollFirst();
                    indices.add(i);
                }
                
            }
        }
        return n-count;
    }
}