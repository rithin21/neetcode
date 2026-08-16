class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> curr_list = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, set, curr_list);

        return ans;
    }

    public void backtrack(int[] nums, HashSet<Integer> set,
                           List<Integer> curr_list) {

        if (curr_list.size() == nums.length) {
            ans.add(new ArrayList<>(curr_list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Already used in current permutation
            if (set.contains(i)) {
                continue;
            }

            // Skip duplicate at the same recursion level
            if (i > 0 && nums[i] == nums[i - 1]
                    && !set.contains(i - 1)) {
                continue;
            }

            set.add(i);
            curr_list.add(nums[i]);

            backtrack(nums, set, curr_list);

            curr_list.remove(curr_list.size() - 1);
            set.remove(i);
        }
    }
}