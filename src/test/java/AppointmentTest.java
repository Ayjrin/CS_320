import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("123", futureDate, "Test appointment");
        assertEquals("123", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Test appointment", appointment.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIdTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        new Appointment("12345678901", futureDate, "Test appointment");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIdNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        new Appointment(null, futureDate, "Test appointment");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        new Appointment("123", pastDate, "Test appointment");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateNull() {
        new Appointment("123", null, "Test appointment");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        new Appointment("123", futureDate, "123456789012345678901234567890123456789012345678901");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        new Appointment("123", futureDate, null);
    }
}

