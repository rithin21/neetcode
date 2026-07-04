class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }

        int[]indegree=new int[numCourses];
        for(int []x:prerequisites)
        {
            graph.get(x[1]).add(x[0]);
            indegree[x[0]]++;
        }

        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }

        int i=-1;
        int[]ans=new int[numCourses];
        while(!q.isEmpty())
        {
            i++;
            int curr=q.poll();
            ans[i]=curr;
            for(int x:graph.get(curr))
            {
                indegree[x]--;
                if(indegree[x]==0)
                {
                    q.offer(x);
                }
            }

        }

        if(i==numCourses-1)
        {
            return ans;
        }

        else
        {
            return new int[0];
        }

        
        
    }
}
