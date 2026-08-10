class Solution {
    public int[] findBuildings(int[] heights) {
        TreeSet<Integer>ans=new TreeSet<>();
        int n=heights.length;
        boolean view=true;
        for(int i=0;i<n;i++){
            view=true;
            for(int j=i+1;j<n;j++){
                if(heights[j]>=heights[i]){
                    view=false;
                    break;
                }
            }
            if(view==true){
                ans.add(i);
            }
        }
        int real_ans[]=new int[ans.size()];
        int p=ans.size();
        for(int i=0;i<p;i++){
            real_ans[i]=ans.pollFirst();
        }
        return real_ans;
    }
}