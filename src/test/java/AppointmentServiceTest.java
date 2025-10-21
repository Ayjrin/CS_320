import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("123", futureDate, "Test appointment");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("123"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment1 = new Appointment("123", futureDate, "Test appointment");
        Appointment appointment2 = new Appointment("123", futureDate, "Another appointment");
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("123", futureDate, "Test appointment");
        service.addAppointment(appointment);
        service.deleteAppointment("123");
        assertNull(service.getAppointment("123"));
    }
}


