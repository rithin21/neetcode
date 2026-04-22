class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int maxele=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxele=Math.max(maxele,piles[i]);
        }
        int l=1;
        int r=maxele;
        int ans=Integer.MAX_VALUE;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            int thours=0;
            for(int pile:piles)
            {
                thours+=(pile+mid-1)/mid;
            }
            if(thours<=h)
            {
                ans=mid;
                r=mid-1;
            }
            else if(thours>h)
            {
                l=mid+1;
            }
        }
        return ans;
        
    }
}
