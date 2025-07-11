class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[][]graph , boolean[]visited,int src,int dest,ArrayList<Integer>path){
        path.add(src);
        if(src==dest){
            ans.add(new ArrayList<>(path)); // make a copy of current path
            path.remove(path.size() - 1);   // backtrack
            return;
        }
        visited[src]=true;
        for(int e:graph[src]){
            if(visited[e]==false){
                dfs(graph,visited,e,dest,path);
            }
        }
        //backtracking
        path.remove(path.size() - 1);
        visited[src]=false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean [] visited = new boolean[graph.length];
        ArrayList<Integer>path = new ArrayList<Integer>();
        dfs(graph,visited,0,graph.length-1,path);
        return ans;
    }
}