class Solution {
public:
    int getSum(int a, int b) {
        int carry =0,res=0;
        for(int i=0;i<32;i++)
        {
            int abit=(a>>i)&1;
            int bbit=(b>>i)&1;
            int curbit=abit^bbit^carry;
            carry=(abit+bbit+carry);
            if(carry>=2)
            {
                carry=1;
            }
            else{
                carry=0;
            }
            if(curbit){
                res=res|(1<<i);
            }
        }
        return res;
        
    }
};
