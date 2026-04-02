class Solution {
public:
    int maxArea(vector<int>& heights) {
        int l=0;
        int r=heights.size()-1;
        int max_vol=0;
        while(l<r)
        {
            int vol=(r-l)*min(heights[r],heights[l]);
            max_vol=max(max_vol,vol);
            if(heights[l]<heights[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return max_vol;
    }
};
