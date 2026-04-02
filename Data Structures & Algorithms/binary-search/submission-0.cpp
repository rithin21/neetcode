class Solution {
public:
    int bsearch(vector<int>& nums, int target,int low,int high) {
        if(low>high)
        {
            return -1;
        }
        int mid=low + (high - low) / 2;
        if(nums[mid]==target)
        {
            return mid;
        }
        else
        {
            if(target<nums[mid])
            {
                return bsearch(nums,target,0,mid-1);
            }
            else
            {
                return bsearch(nums,target,mid+1,high);
            }
        }
        
    }
     int search(vector<int>& nums,int target) {
        return bsearch(nums,target,0,nums.size() - 1);
    }
};
