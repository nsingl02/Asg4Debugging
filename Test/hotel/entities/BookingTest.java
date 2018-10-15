package hotel.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import java.text.SimpleDateFormat;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
class BookingTest{
	Room mockRoom = new Room(101,RoomType.SINGLE);
	Guest mockGuest = new Guest("Nipun","Singla",1234);
	Booking mockBooking;
	Booking newBooking;
	Hotel hotel = new Hotel();
	CreditCard mockCard = new CreditCard(CreditCardType.VISA,2,2);
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	double cost = 2.00;
	double cosst = 2.00;
	
	void setUp() throws Exception{
		format = new SimpleDateFormat("dd-MM-yyyy");
		Date arrivalDate = format.parse("11-09-2010");
		int Length = 1;
		int Number = 1;
		mockBooking = new Booking(mockGuest,mockRoom,arrivalDate,Length,Number,mockCard);
		
	}
	
	void tearDown() throws Exception{
		
	}
	
	final void testServiceCharge() throws Exception{
		mockBooking.addServiceCharge(ServiceType.ROOM_SERVICE, cost);
		assertEquals(2.00,cost);
	}
	
}
	
