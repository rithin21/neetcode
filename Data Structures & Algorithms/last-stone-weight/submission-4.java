class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:stones){
            q.offer(x);
        }

        while(q.size()>1){
            int x=q.poll();
            int y=q.poll();
            if(Math.abs(x-y)>0){
                q.offer(Math.abs(x-y));
            }
        }
        if(q.size()==0){
            return 0;
        }
        
        return q.peek();
        
    }
}
