
class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);

            // Keep only the k largest elements
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);

        // Remove the smallest if heap grows beyond k
        if (pq.size() > k) {
            pq.poll();
        }

        // Root is the kth largest element
        return pq.peek();
    }
}