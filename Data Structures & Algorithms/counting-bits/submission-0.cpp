class Solution {
public:
    vector<int> countBits(int n) {
        vector<int>setbits;
        for(int i=0;i<n+1;i++)
        {
            int num=i;
            int res=0;
            while(num)
            {
                num=num&(num-1);
                res++;
            }
            setbits.push_back(res);
        }
        return setbits;
        
    }
};
