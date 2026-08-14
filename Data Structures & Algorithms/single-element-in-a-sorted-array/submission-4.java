class Solution {
    public int singleNonDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            // mid is paired with mid + 1
            if (mid + 1 <= r && nums[mid] == nums[mid + 1]) {

                // Left side:  [l ... mid-1]
                // Pair:        [mid, mid+1]
                // Right side: [mid+2 ... r]

                int rightLen = r - mid - 1;

                if (rightLen % 2 == 1) {
                    // Single is on the right
                    l = mid + 2;
                } else {
                    // Single is on the left
                    r = mid - 1;
                }
            }

            // mid is paired with mid - 1
            else if (mid - 1 >= l && nums[mid] == nums[mid - 1]) {

                // Left side:  [l ... mid-2]
                // Pair:        [mid-1, mid]
                // Right side: [mid+1 ... r]

                int leftLen = mid - l - 1;

                if (leftLen % 2 == 1) {
                    // Single is on the left
                    r = mid - 2;
                } else {
                    // Single is on the right
                    l = mid + 1;
                }
            }

            else {
                // mid doesn't match either neighbor
                return nums[mid];
            }
        }

        return nums[l];
    }
}