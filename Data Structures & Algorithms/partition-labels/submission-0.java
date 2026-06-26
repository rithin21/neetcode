class Solution {

    class pair {
        int start, end;

        pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Integer> partitionLabels(String s) {

        HashMap<Character, pair> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                map.get(ch).end = i;
            } else {
                map.put(ch, new pair(i, i));
            }
        }

        pair[] intervals = new pair[map.size()];

        int idx = 0;
        for (pair p : map.values()) {
            intervals[idx++] = p;
        }

        Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));

        List<Integer> finallist = new ArrayList<>();

        int start = intervals[0].start;
        int end = intervals[0].end;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i].start <= end) {
                end = Math.max(end, intervals[i].end);
            } else {
                finallist.add(end - start + 1);
                start = intervals[i].start;
                end = intervals[i].end;
            }
        }

        finallist.add(end - start + 1);

        return finallist;
    }
}