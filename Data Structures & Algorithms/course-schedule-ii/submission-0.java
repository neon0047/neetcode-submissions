class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> graph = new ArrayList();
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] e: prerequisites){
            graph.get(e[1]).add(e[0]);
            indeg[e[0]]++;
        }
        for(int i= 0;i<indeg.length; i++){
            if(indeg[i] == 0) q.offer(i);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int v = q.poll();
            ans[idx++] = v;
            for(int nbr: graph.get(v)){
                indeg[nbr]--;
                if(indeg[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        if(idx!=ans.length) return new int[0];
        else return ans;
    }
}
