class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;
        int right = maxPile;
        int ans = maxPile;

        while (left <= right) {
            int mid = left + (right - left) / 2; // candidate speed

            int hours = 0;
            for (int pile : piles) {
                hours += (int) Math.ceil((double) pile / mid);
            }

            if (hours <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}