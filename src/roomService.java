public class RoomService {
    private final Map<Integer, Boolean> rooms = new ConcurrentHashMap<>();

    public RoomService(int totalRooms) {
        for (int i = 1; i <= totalRooms; i++) {
            rooms.put(i, true); // true = available
        }
    }

    public synchronized boolean bookRoom(int roomNumber) {
        if (rooms.getOrDefault(roomNumber, false)) {
            rooms.put(roomNumber, false);
            return true;
        }
        return false;
    }

    public synchronized void cancelBooking(int roomNumber) {
        if (rooms.containsKey(roomNumber)) {
            rooms.put(roomNumber, true);
        }
    }

    public boolean isAvailable(int roomNumber) {
        return rooms.getOrDefault(roomNumber, false);
    }
}
