import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomServiceTest {
    RoomService service = new RoomService(5);

    @Test
    void testSuccessfulBooking() {
        assertTrue(service.bookRoom(1), "Room 1 should be booked successfully");
        assertFalse(service.isAvailable(1), "Room 1 should no longer be available");
    }

    @Test
    void testDoubleBookingFailure() {
        service.bookRoom(2);
        assertFalse(service.bookRoom(2), "Room 2 should not be bookable twice");
    }

    @Test
    void testCancellation() {
        service.bookRoom(3);
        service.cancelBooking(3);
        assertTrue(service.isAvailable(3), "Room 3 should be available after cancellation");
    }
}