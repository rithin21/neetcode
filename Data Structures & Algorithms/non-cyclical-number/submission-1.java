class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=getnext(slow);
            fast=getnext(getnext(fast));
        }while(slow!=fast);

        return slow==1;
    }
    public int getnext(int n){
        int sum=0;
        while(n!=0){
            int digit=n%10;
            sum+=digit*digit;
            n/=10;   
        }
        return sum;
        
    }
}
