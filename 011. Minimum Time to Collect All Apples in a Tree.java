class Solution {
    public int DFS(int root, int parent, List<Integer>[] adj, List<Boolean> hasApple) {
        int time = 0;
        for(Integer nbr : adj[root]) {
            if(nbr == parent) continue;
            int timeFromNbr = DFS(nbr, root, adj, hasApple);
            if(timeFromNbr > 0 || hasApple.get(nbr)) time += timeFromNbr + 2;
        }
        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < adj.length; i++)
            adj[i] = new ArrayList<>();
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return DFS(0, -1, adj, hasApple);
    }
}
