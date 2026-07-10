class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //track the maxele
        int max_ele=Integer.MIN_VALUE;
        
        //starting indice
        int l=0;
        int r=k-1;

        //store the ans at each window
        int[]ans=new int[nums.length-k+1];

        for(int i=l;i<=r;i++){
            max_ele=Math.max(max_ele,nums[i]);
        }
        ans[0]=max_ele;

        while(r+1<nums.length){
            r++;
            if(nums[r]>max_ele){
                max_ele=nums[r];
            }
            if(nums[l]==max_ele){
                max_ele=nums[l+1];
                for(int i=l+1;i<=r;i++){
                    max_ele=Math.max(max_ele,nums[i]);
                }
            }
            l++;
            ans[l]=max_ele;

        }
        return ans;        
    }
}
