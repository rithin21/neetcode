class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        int l=0;
        int r=0;
        int maxprice=0;
        while(r<n)
        {
            int price=prices[r]-prices[l];
            if(price<0)
            {
                l++;
            }
            else
            {
                 maxprice=max(maxprice,price);
                 r++;
            }
           
        }
        return maxprice;
        
    }
};
