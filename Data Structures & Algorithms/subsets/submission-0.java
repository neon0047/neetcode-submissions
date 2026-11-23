class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        getSet(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    public void getSet(int[] nums, int idx, List<List<Integer>> res, List<Integer> ls){
        if(idx == nums.length) {
            res.add(new ArrayList(ls));
            return;
        }

        getSet(nums, idx + 1, res, ls);
        ls.add(nums[idx]);
        getSet(nums, idx+1, res, ls);
        ls.remove(ls.size()-1);


    }
}
