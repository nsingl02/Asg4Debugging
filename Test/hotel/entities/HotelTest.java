package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
 import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
 public class HotelTest {
     CreditCard creditCard;
    ServiceType serviceType;
    Guest guest;
    @Mock
    Booking booking;
    @Mock
    Room room;
     @InjectMocks
    Hotel hotel;
     Date arrivalDate;
     double cost;
     long confirmationNumber;
     int stayLength;
    int numberOfOccupants;
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
     @BeforeEach
    void setUp() throws ParseException {
         MockitoAnnotations.initMocks(this);
        confirmationNumber = Long.parseLong("10102018");
        guest = new Guest("Daniella","23 Mason",2);
        creditCard = new CreditCard(CreditCardType.VISA,3,3);
     }
   
     @Test
    void testCheckOutRuntimeException(){
         Executable e = () -> hotel.checkout(room.getId());
        assertThrows(RuntimeException.class, e);
     }
    
    @Test
    public void testCheckOut(){
         Mockito.when(room.book(guest,arrivalDate,stayLength,numberOfOccupants,creditCard)).thenReturn(booking);
        Mockito.when(booking.getRoom()).thenReturn(room);
        Mockito.when(room.getId()).thenReturn(2);
        hotel.checkin(hotel.book(room,guest,arrivalDate,stayLength,numberOfOccupants,creditCard));
        assertEquals(1,hotel.activeBookingsByRoomId.size());
        hotel.checkout(2);
        assertEquals(0,hotel.activeBookingsByRoomId.size());
    }
   
 }
     