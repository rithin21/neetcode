class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean first = false;
        boolean second = false;
        boolean third = false;

        for (int[] triplet : triplets) {

            // Ignore invalid triplets
            if (triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]) {
                continue;
            }

            // Check if this triplet contributes to the target
            if (triplet[0] == target[0])
                first = true;

            if (triplet[1] == target[1])
                second = true;

            if (triplet[2] == target[2])
                third = true;
        }

        return first && second && third;
    }
}