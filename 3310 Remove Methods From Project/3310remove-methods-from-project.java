import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e:invocations)
            adj.get(e[0]).add(e[1]);

        boolean[] vis = new boolean[n];
        dfs(k,adj,vis);

        for(int[] e:invocations){
            if(!vis[e[0]] && vis[e[1]]){
                List<Integer> ans = new ArrayList<>();
                for(int i=0;i<n;i++) ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
            if(!vis[i]) ans.add(i);

        return ans;
    }

    void dfs(int node,List<List<Integer>> adj,boolean[] vis){
        vis[node]=true;
        for(int x:adj.get(node))
            if(!vis[x]) dfs(x,adj,vis);
    }
}