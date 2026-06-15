class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][]prep=new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++)
        {
            prep[i]=intervals[i];
        }
        prep[intervals.length]=newInterval;
        Arrays.sort(prep,(a,b)->a[0]-b[0]);

        List<int[]>ans=new ArrayList<>();
        int start=prep[0][0];
        int end=prep[0][1];
        for(int i=1;i<prep.length;i++)
        {
            if(prep[i][0]<=end)
            {
                end=Math.max(prep[i][1],end);
            }
            else
            {
                ans.add(new int[]{start,end});
                start=prep[i][0];
                end=prep[i][1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
