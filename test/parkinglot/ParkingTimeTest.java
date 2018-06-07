package parkinglot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ParkingTimeTest
{
	
	@Before
	public void setUp() throws Exception
	{
	}
	
	@Test
	public void shouldParkBetweenOneAndTen()
	{
		ParkingTime vehicleParkingInfo = ParkingTime.vehicleParkedBetween(1, 10);
		
		assertEquals(vehicleParkingInfo.parkingStartedAt(), 1);
		assertEquals(vehicleParkingInfo.parkingFinishedAt(), 10);
	}
	
	@Test
	public void shouldWantToEnterAtParkingALotInTheSameMomentumAtItsStarts()
	{
		ParkingTime vehicleParkingInfo = ParkingTime.vehicleParkedBetween(1, 10);
		
		assertEquals(vehicleParkingInfo.wantToEnterParkingALotAt(1), true);
		assertEquals(vehicleParkingInfo.wantToEnterParkingALotAt(2), false);
	}
	
	@Test
	public void shouldWantToLeaveTheParkingALotInTheSameMomentumAtItsFinishes()
	{
		ParkingTime vehicleParkingInfo = ParkingTime.vehicleParkedBetween(1, 10);
		
		assertEquals(vehicleParkingInfo.wantToLeaveParkingALotAt(10), true);
		assertEquals(vehicleParkingInfo.wantToLeaveParkingALotAt(9), false);
	}
	
}
