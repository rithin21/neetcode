class Solution {

    class Result{
        int[]points;
        double distance;

        Result(int[]points,double distance){
            this.points=points;
            this.distance=distance;
        }
    }

    public double calc_distance(int[]point)
    {
        int x=point[0];
        int y=point[1];
        int dis=x*x+y*y;
        double ans=Math.sqrt(dis);
        return ans;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Result>q=new PriorityQueue<>((a,b)->Double.compare(a.distance,b.distance));
        int[][]ans=new int[k][2];
        int count=0;
        for(int[]x:points)
        {
            q.offer(new Result(x,calc_distance(x)));
        }
        while(count<k)
        {
            ans[count]=q.poll().points;
            count++;
        }
        return ans;

    }
}
