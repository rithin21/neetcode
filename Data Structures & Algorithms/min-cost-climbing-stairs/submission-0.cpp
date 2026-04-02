class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        if(cost.size()==0)
        {
            return 0;
        }
        else if(cost.size()==1)
        {
            return cost[0];
        }
        else 
        {
            return min(recfn(0,cost),recfn(1,cost));
        }    
    }
    int recfn(int x,vector<int>&cost)
    {
        if(x>=cost.size())
        {
            return 0;
        }
        return cost[x]+min(recfn(x+1,cost),recfn(x+2,cost));
    }
};
