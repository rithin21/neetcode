class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        vector<int>final;
      for(int j=0;j<nums.size();j++)
      {
        for(int i=0;i<nums.size();i++)
        {
            if(nums[j]+nums[i]==target && i!=j)
            {
                final.push_back(j);
                final.push_back(i);
                return final;
            }
        }
      } 
      return final; 
    }
    
};
