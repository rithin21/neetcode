

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Sort by start time
        Collections.sort(intervals,
                Comparator.comparingInt(i -> i.start));

        List<List<Interval>> rooms = new ArrayList<>();

        for (Interval curr : intervals) {

            boolean placed = false;

            // Try to place meeting in an existing room
            for (List<Interval> room : rooms) {

                Interval lastMeeting =
                        room.get(room.size() - 1);

                if (curr.start >= lastMeeting.end) {
                    room.add(curr);
                    placed = true;
                    break;
                }
            }

            // Need a new room
            if (!placed) {
                List<Interval> newRoom = new ArrayList<>();
                newRoom.add(curr);
                rooms.add(newRoom);
            }
        }

        return rooms.size();
    }
}