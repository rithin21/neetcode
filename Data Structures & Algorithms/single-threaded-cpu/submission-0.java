class Solution {

    class Entry {
        int start;
        int duration;
        int index;

        Entry(int start, int duration, int index) {
            this.start = start;
            this.duration = duration;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        Entry[] arr = new Entry[n];

        // Keep original index
        for (int i = 0; i < n; i++) {
            arr[i] = new Entry(tasks[i][0], tasks[i][1], i);
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a.start, b.start));

        // duration first, then original index
        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> {

            if (a.duration != b.duration) {
                return Integer.compare(a.duration, b.duration);
            }

            return Integer.compare(a.index, b.index);
        });

        int[] ans = new int[n];

        int index = 0;
        int ansIndex = 0;

        long time = 0;

        while (index < n || !pq.isEmpty()) {

            // If no task is currently available,
            // jump time to the next task's start time
            if (pq.isEmpty()) {
                time = Math.max(time, arr[index].start);
            }

            // Add all tasks that have arrived
            while (index < n && arr[index].start <= time) {
                pq.offer(arr[index]);
                index++;
            }

            // Pick shortest duration task
            Entry curr = pq.poll();

            ans[ansIndex++] = curr.index;

            time += curr.duration;
        }

        return ans;
    }
}