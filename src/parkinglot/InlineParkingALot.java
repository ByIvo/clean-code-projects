package parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InlineParkingALot
{
	private final int maxNumberOfCars;
	private final List<ParkingTime> parkingTimes;

	public InlineParkingALot(int maxNumberOfCars)
	{
		this.maxNumberOfCars = maxNumberOfCars;
		this.parkingTimes = new ArrayList<>();
	}

	public int getMaxNumberOfCars()
	{
		return maxNumberOfCars;
	}

	public List<ParkingTime> getParkedVehiclesInfo()
	{
		return Collections.unmodifiableList(parkingTimes);
	}
	
	public void parkANewVehicle(ParkingTime parkingTimeOfVehicle)
		throws 	ThereIsNoSpaceLeftInTheParkingALotException,
				AnAlreadyParkedVehicleWantsToLeaveFirstException
	{
		validateIfCanParkNewVehicleDuring(parkingTimeOfVehicle);
		
		parkingTimes.add(parkingTimeOfVehicle);
	}

	private void validateIfCanParkNewVehicleDuring(ParkingTime newParkingTimeOfVehicle) 
		throws  AnAlreadyParkedVehicleWantsToLeaveFirstException,
				ThereIsNoSpaceLeftInTheParkingALotException
	{
		List<ParkingTime> allParkingInfoAvailable = gatherAlreadyParkedInfoWith(newParkingTimeOfVehicle);
		
		var validator = InlineParkingALotValidator.validateIfAllInfoFitsIn(allParkingInfoAvailable, maxNumberOfCars);
		validator.validateIfCanPark();
	}
		

	private List<ParkingTime> gatherAlreadyParkedInfoWith(ParkingTime newParkingTimeOfVehicle)
	{
		List<ParkingTime> allParkingInfo = new ArrayList<>(parkingTimes);
		allParkingInfo.add(newParkingTimeOfVehicle);
		
		return allParkingInfo;
	}

}
