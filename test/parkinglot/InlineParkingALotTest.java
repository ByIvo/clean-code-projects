package parkinglot;

import static org.junit.Assert.*;
import static parkinglot.ParkingTime.vehicleParkedBetween;

import org.junit.Before;
import org.junit.Test;


public class InlineParkingALotTest
{	
	private InlineParkingALot parkingALot;
	
	@Before
	public void setUp() throws Exception
	{
	}
	
	@Test
	public void shouldCreateAInlineParkingALotWithMaxOf4Cars()
	{
		parkingALot = new InlineParkingALot(4);
		
		assertEquals(parkingALot.getMaxNumberOfCars(), 4);
	}
	
	@Test
	public void shouldPark2DriversInTheParkingALot() throws Exception
	{
		parkingALot = new InlineParkingALot(2);
		
		ParkingTime firstParkingVehicle = ParkingTime.vehicleParkedBetween(1,10);
		ParkingTime secondParkingVehicle = ParkingTime.vehicleParkedBetween(1,10);
		
		parkingALot.parkANewVehicle(firstParkingVehicle);
		parkingALot.parkANewVehicle(secondParkingVehicle);
		
		int parkedVehiclesCount = parkingALot.getParkedVehiclesInfo().size();
		assertEquals(parkedVehiclesCount, 2);
	}
	
	@Test(expected = ThereIsNoSpaceLeftInTheParkingALotException.class)
	public void shouldThrowAnExceptionBecauseThereIsNoSpaceLeftInTheParkingALot() throws Exception
	{
		parkingALot = new InlineParkingALot(1);
		
		ParkingTime firstParkingVehicle = ParkingTime.vehicleParkedBetween(1,5);
		ParkingTime vehicleWithouSpaceToPark = ParkingTime.vehicleParkedBetween(4,6);
		
		parkingALot.parkANewVehicle(firstParkingVehicle);
		parkingALot.parkANewVehicle(vehicleWithouSpaceToPark);
	}
	
	@Test(expected = AnAlreadyParkedVehicleWantsToLeaveFirstException.class)
	public void shouldThrowAnExceptionBecauseAnAlreadyParkedVehicleWantsToLeaveFirstThanTheNewVehicle() throws Exception
	{
		parkingALot = new InlineParkingALot(2);
		
		ParkingTime firstParkingVehicle = ParkingTime.vehicleParkedBetween(1,5);
		ParkingTime vehicleWithouSpaceToPark = ParkingTime.vehicleParkedBetween(4,6);
		
		parkingALot.parkANewVehicle(firstParkingVehicle);
		parkingALot.parkANewVehicle(vehicleWithouSpaceToPark);
	}
	
	@Test()
	public void shouldParkAllCarsBecauseThereIsNoConflict() throws Exception
	{
		parkingALot = new InlineParkingALot(3);
		
		parkingALot.parkANewVehicle(vehicleParkedBetween(1,10));
		parkingALot.parkANewVehicle(vehicleParkedBetween(1,6));
		parkingALot.parkANewVehicle(vehicleParkedBetween(1,5));
		parkingALot.parkANewVehicle(vehicleParkedBetween(7,10));
		parkingALot.parkANewVehicle(vehicleParkedBetween(7,8));
		parkingALot.parkANewVehicle(vehicleParkedBetween(9,10));
		
	}
	
}
