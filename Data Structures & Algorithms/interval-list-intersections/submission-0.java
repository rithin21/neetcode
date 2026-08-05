class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m=firstList.length;
        int n=secondList.length;
        int[][]ans=new int[m+n][2];
        int index=0;

        for(int i=0;i<m;i++){
            int []first=firstList[i];
            for(int j=0;j<n;j++){
                int x[]=new int[2];
                int[]sec=secondList[j];
                if(sec[0]<=first[1]&&sec[1]>=first[0]){
                    x[0]=Math.max(first[0],sec[0]);
                    x[1]=Math.min(first[1],sec[1]);
                    ans[index++]=x;
                }

            }
        }
        return Arrays.copyOf(ans, index);
    }
}