class Solution {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<bool>visited(n,false);
        vector<vector<int>>adj(n);
        for(auto&v:edges)
        {
            adj[v[0]].push_back(v[1]);
            adj[v[1]].push_back(v[0]);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                count++;
                BFS(i,n,adj,visited);
            }
            
        }
        return count;

    }

    void BFS(int i,int n,vector<vector<int>>&adj,vector<bool>&visited)
    {
        queue<int>q;
        visited[i]=true;
        q.push(i);
        while(q.empty()==false)
        {
            int u=q.front();
            q.pop();
            for(int v:adj[u])
            {
                if(visited[v]==false)
                {
                    visited[v]=true;
                    q.push(v);
                }
            }
        }
    }
};
