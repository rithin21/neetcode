

class Solution {

    public boolean makesquare(int[] arr) {

        int sum = 0;

        for (int x : arr) {
            sum += x;
        }

        // Cannot divide into 4 equal sides
        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        // Largest stick cannot be bigger than one side
        Arrays.sort(arr);
        if (arr[arr.length - 1] > target) {
            return false;
        }

        Set<Integer> chosen = new HashSet<>();

        return backtrack(arr, 0, target, 0, chosen, 0);
    }

    private boolean backtrack(
            int[] arr,
            int index,
            int target,
            int curr,
            Set<Integer> chosen,
            int count) {

        // We have successfully built 4 sides
        if (count == 3) {
            return true;
        }

        // Current side is complete
        if (curr == target) {
            return backtrack(
                    arr,
                    0,          // IMPORTANT: start from beginning
                    target,
                    0,          // new side
                    chosen,
                    count + 1
            );
        }

        // Try every unused matchstick
        for (int i = index; i < arr.length; i++) {

            if (chosen.contains(i)) {
                continue;
            }

            // Don't exceed target
            if (curr + arr[i] > target) {
                continue;
            }

            chosen.add(i);

            if (backtrack(
                    arr,
                    i + 1,
                    target,
                    curr + arr[i],
                    chosen,
                    count
            )) {
                return true;
            }

            // Undo choice
            chosen.remove(i);
        }

        return false;
    }
}