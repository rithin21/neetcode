class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int l=0;
        int n=customers.length;
        int r=minutes-1;
        int unsatisfied=0;
        int max=0;
        int final_r=0;
        int final_l=0;

        for(int i=0;i<=r;i++){
            if(grumpy[i]==1){
                unsatisfied+=customers[i];
            }
        }
        if(unsatisfied>max){
            final_l=l;
            final_r=r;
            max=unsatisfied;
        }
        l++;
        r++;
        
        
        while(r<n){
            if(grumpy[l-1]==1){
                unsatisfied-=customers[l-1];
            }
            if(grumpy[r]==1){
                unsatisfied+=customers[r];
            }
            if(unsatisfied>max){
                final_l=l;
                final_r=r;
                max=unsatisfied;
            }
            l++;
            r++;    
        }

        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                max += customers[i];
            }
}
        return max;
    }
}