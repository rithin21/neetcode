class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer>ans=new ArrayList<>();
        for(int x:nums){
            int left=0;
            int right=ans.size();

            while(left<right){
                int mid=left+(right-left)/2;
                if(ans.get(mid)>=x){
                    right=mid;
                }
                else{
                    left=mid+1;
                }
            }
            if(left==ans.size()){
                ans.add(x);
            }
            else{
                ans.set(left,x);
            }
        }
        return ans.size();
    }
    
}
