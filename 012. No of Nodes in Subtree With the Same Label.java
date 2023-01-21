class Solution {
    public int[] DFS(int curr, int parent, List<Integer>[] adj, 
                    String labels, int[] res) {
        int[] currCount = new int[26];
        char currLabel = labels.charAt(curr);
        currCount[currLabel - 'a'] = 1;
        for(int nbr : adj[curr]) {
            if(nbr == parent) continue;
            int[] childCount = DFS(nbr, curr, adj, labels, res);
            for(int i = 0; i < 26; i++) {
                currCount[i] += childCount[i];
            }
        }
        res[curr] = currCount[currLabel - 'a'];
        return currCount;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] res = new int[n];
        DFS(0, -1, adj, labels, res);
        return res;
    }
}
