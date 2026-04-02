class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if(edges.size()!=n-1)
        {
            return false;
        }
        vector<vector<int>>adj(n);
        for(auto&v:edges)
        {
            int one=v[0];
            int two=v[1];
            adj[one].push_back(two);
            adj[two].push_back(one);
        }
        return BFS(n,adj);
    }

    bool BFS(int n,vector<vector<int>>&adj)
    {
        vector<bool>visited(n,false);
        queue<int>q;
        q.push(0);
        visited[0]=true;
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
        for(int i=0;i<visited.size();i++)
        {
            if(visited[i]==false)
            {
                return false;
            }
        }
        return true;


    }
};
