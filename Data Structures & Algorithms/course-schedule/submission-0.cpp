class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int>indegree(numCourses,0);
        vector<vector<int>>adj(numCourses);
        for(auto &p:prerequisites)
        {
            int c=p[0];
            int pre=p[1];
            adj[pre].push_back(c);
            indegree[c]++;
        }
        queue<int>q;
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.push(i);
            }
        }
        int count=0;
        while(q.empty()==false)
        {
            int u=q.front();
            q.pop();
            count++;
            for(int v:adj[u])
            {
                indegree[v]--;
                if(indegree[v]==0)
                {
                    q.push(v);
                }
            }
        }
         return count==numCourses;
    }
   
};
