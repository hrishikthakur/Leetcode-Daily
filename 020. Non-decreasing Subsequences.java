class Solution {
    public void DFS(int[] nums, int idx, List<Integer> currSubsequence, Set<List<Integer>> res) {
        if(idx == nums.length) {
            if(currSubsequence.size() > 1) res.add(new ArrayList<>(currSubsequence));
            return;
        }
        if(currSubsequence.size() == 0 || nums[idx] >= currSubsequence.get(currSubsequence.size() - 1)) {
            currSubsequence.add(nums[idx]);
            DFS(nums, idx + 1, currSubsequence, res);
            currSubsequence.remove(currSubsequence.size() - 1);
        }
        DFS(nums, idx + 1, currSubsequence, res);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        DFS(nums, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }
}
