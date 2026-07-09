class Solution {

    class Info {
        char ch;
        int freq;
        int availableTime;

        Info(char ch, int freq, int availableTime) {
            this.ch = ch;
            this.freq = freq;
            this.availableTime = availableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        // Count frequencies
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Max Heap based on frequency
        PriorityQueue<Info> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Info(entry.getKey(), entry.getValue(), 0));
        }

        // Cooldown Queue
        Queue<Info> cooldown = new ArrayDeque<>();

        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {

            time++;

            // Execute the highest frequency task
            if (!pq.isEmpty()) {

                Info curr = pq.poll();
                curr.freq--;

                // Put it into cooldown if still remaining
                if (curr.freq > 0) {
                    curr.availableTime = time + n;
                    cooldown.offer(curr);
                }
            }

            // If a task's cooldown has finished,
            // move it back into the heap.
            if (!cooldown.isEmpty()
                    && cooldown.peek().availableTime == time) {

                pq.offer(cooldown.poll());
            }
        }

        return time;
    }
}