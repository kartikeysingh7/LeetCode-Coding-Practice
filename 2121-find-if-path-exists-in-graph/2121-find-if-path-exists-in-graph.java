class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the undirected graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Start BFS
        q.offer(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == destination) {
                return true;
            }

            for (int neighbor : graph.get(node)) {
                if (!vis[neighbor]) {
                    q.offer(neighbor);
                    vis[neighbor] = true;
                }
            }
        }

        return false; // No path found
    }
}