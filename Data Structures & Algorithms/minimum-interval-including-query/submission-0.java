class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        for(int j=0;j<queries.length;j++){
            PriorityQueue<int[]>heap=new PriorityQueue<>((a,b)->Integer.compare(a[1]-a[0]+1,b[1]-b[0]+1));
            for(int []x:intervals){
                if(x[0]<=queries[j]&&x[1]>=queries[j]){
                    heap.offer(x);
                }
            }
            if(heap.isEmpty()){
                queries[j]=-1;
            }
            else{
                int[]y=heap.poll();
                queries[j]=y[1]-y[0]+1;
            }
            
        }

        return queries;
        
        
    }
}
