class Solution {
    int count;
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> ad = new ArrayList();
        for(int i = 0; i<n; i++) ad.add(new ArrayList());
        for(int[] e: edges){
            ad.get(e[0]).add(e[1]);
            ad.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        count = 0;
        boolean cycle = cycleExist(ad, vis, 0, -1);
        System.out.println(count);
        System.out.println(cycle);
        return !cycle && count == n;
    }
    public boolean cycleExist(List<List<Integer>> ad, boolean[] vis, int i, int p){
        vis[i] = true;
        count++;
        for(int nbr: ad.get(i)){
            if(!vis[nbr]){
                if(cycleExist(ad, vis, nbr, i)) return true;
            }else if (nbr != p){
                return true;
            }
        }
        return false;
    }
}
