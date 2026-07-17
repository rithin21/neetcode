class Solution {

    class Pair{
        int index,height;
        Pair(int index,int height){
            this.index=index;
            this.height=height;
        }
    }

    public int largestRectangleArea(int[] heights) {

        //create a minheap to find the next smallest in O(1)
        PriorityQueue<Pair>heap=new PriorityQueue<>((a,b)->Integer.compare(a.height,b.height));
        for(int i=0;i<heights.length;i++){
            heap.offer(new Pair(i,heights[i]));
        }

        //minimum rectangle to start off with 
        int area=0;
        area=(heap.poll().height)*(heights.length);

        while(!heap.isEmpty()){
            Pair curr=heap.poll();
            int index=curr.index;
            int height=curr.height;
            int l=index;
            int r=index;
            while(l-1>=0&&heights[l-1]>=heights[index]){
                l--;
            }
            while(r+1<heights.length&&heights[r+1]>=heights[index]){
                r++;
            }
            area=Math.max(area,height*(r-l+1));
        }

        return area;



    }
}
