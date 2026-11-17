class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] e: prerequisites){
            graph.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(!vis[i] && cycle(graph, i, vis, pathVis)) return false;
        }
        return true;
    }
    public boolean cycle(List<List<Integer>> graph, int v, boolean[] vis, boolean[] pathVis){
        vis[v] = true;

        pathVis[v] = true;
        for(int nbr: graph.get(v)){
            if(!vis[nbr]){
                if(cycle(graph, nbr, vis, pathVis)) return true;
            }else if(pathVis[nbr]){
                return true;
            }
        }
        pathVis[v] = false;
        return false;
    }
}
