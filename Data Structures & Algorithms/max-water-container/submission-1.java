class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int maxvol=0;
        while(l<r)
        {
            maxvol=Math.max(maxvol,Math.min(heights[l],heights[r])*(r-l));
            if(heights[l]<heights[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return maxvol;

        
    }
}
