class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int>indegree(numCourses);
        vector<vector<int>>adj(numCourses);
        vector<int>final;
        for(auto& v :prerequisites)
        {
            int sub=v[0];
            int pre=v[1];
            adj[pre].push_back(sub);
            indegree[sub]++;
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
            final.push_back(u);
            for(int v:adj[u])
            {
                indegree[v]--;
                if(indegree[v]==0)
                {
                    q.push(v);
                }
            }
        }
        if(count==numCourses)
        {
            return final;
        }
        else 
        {
            return {};
        }
    }
};
