class Solution {
public:
    vector<int>parent;


    int find(int a)
    {
        if(parent[a]!=a)
        {
            parent[a]=find(parent[a]);
        }
        return parent[a];

    }

    bool unite(int a,int b)
    {
        int pa=find(a);
        int pb=find(b);
        if(pa==pb)
        {
            return false;
        }
        parent[pb]=pa;
        return true;

    }

    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n=edges.size();
        parent.resize(n+1);
        for(int i=1;i<n+1;i++)
        {
            parent[i]=i;
        }
        for(auto&e:edges)
        {
            if(unite(e[0],e[1])==false)
            {
                return e;
            }
        }
        return {};    
    }

    
};
