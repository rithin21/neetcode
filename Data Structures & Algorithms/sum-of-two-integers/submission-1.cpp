class Solution {
public:
    int getSum(int a, int b) //the prvs soln did 1bit at a time but this evaluates both the numbers entirely at one go and loops until the carry becomes 0
    {
        while(b!=0)//i will need to loop until the carry becomes 0
        {
            int carry=(a&b)<<1;//find the positions wer there is a carry
            a=a^b;// finding the sum without considering the carry
            b=carry;
        }
        return a;
    }
};
