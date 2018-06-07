package parkinglot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ThereIsNoSpaceLeftInTheParkingALotExceptionTest
{
	
	@Before
	public void setUp() throws Exception
	{
	}
	
	@Test
	public void theExceptionMessageShouldBeTheSameAsExpected()
	{
		String expectedMessage = "There is no way to fit a new vehicle between 2 and 5";
		ParkingTime parkinTime = ParkingTime.vehicleParkedBetween(2, 5);
		ThereIsNoSpaceLeftInTheParkingALotException exception = new ThereIsNoSpaceLeftInTheParkingALotException(parkinTime);
		
		assertEquals(exception.getMessage(), expectedMessage);
	}
	
}
