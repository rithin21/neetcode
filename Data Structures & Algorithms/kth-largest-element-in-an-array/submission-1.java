class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:nums){
            q.offer(x);
        }
        int count=0;
        while(count<k-1){
            q.poll();
            count++;
        }
        return q.peek();

        
    }
}
