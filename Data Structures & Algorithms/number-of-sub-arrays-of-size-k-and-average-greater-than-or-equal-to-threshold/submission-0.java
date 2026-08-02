class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0;
        int r=k-1;
        int n=arr.length;
        int count=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum/k>=threshold){
            count++;
        }
        for(r=k;r<n;r++){
            sum-=arr[l];
            l++;
            sum+=arr[r];
            if(sum/k>=threshold){
                count++;
            }
        }
        return count;
    }
}