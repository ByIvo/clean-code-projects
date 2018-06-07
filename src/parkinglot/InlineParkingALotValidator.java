package parkinglot;

import java.util.List;
import java.util.Stack;

class InlineParkingALotValidator
{

	private int maxNumberOfCars;
	private Stack<ParkingTime> vacancies = new Stack<>();
	private List<ParkingTime> allParkingInfoAvailable;
	
	private InlineParkingALotValidator(List<ParkingTime> allParkingInfoAvailable, int maxNumberOfCars)
	{
		super();
		this.allParkingInfoAvailable = allParkingInfoAvailable;
		this.maxNumberOfCars = maxNumberOfCars;
	}
	
	protected static InlineParkingALotValidator validateIfAllInfoFitsIn(List<ParkingTime> allParkingInfoAvailable, int maxNumberOfCars) {
		return new InlineParkingALotValidator(allParkingInfoAvailable, maxNumberOfCars);
	}
	
	public void validateIfCanPark()
		throws 	ThereIsNoSpaceLeftInTheParkingALotException, AnAlreadyParkedVehicleWantsToLeaveFirstException {
		
		int maxParkedMomentum = getMaxMomentumOfParkingInfo();

		for(int momentum=1; momentum<= maxParkedMomentum; momentum++) {
			validateVacanciesStateInMomemtum(momentum);
		}
	}

	private void validateVacanciesStateInMomemtum(int momentum) 
			throws ThereIsNoSpaceLeftInTheParkingALotException, AnAlreadyParkedVehicleWantsToLeaveFirstException
	{
		validateIfCanParkInThisMomentum(momentum);
		validateIfCanLeaveInThisMomemtum(momentum);
	}

	private void validateIfCanParkInThisMomentum(int momentum) throws ThereIsNoSpaceLeftInTheParkingALotException
	{
		for (ParkingTime parkingTime : allParkingInfoAvailable)
		{
			if(parkingTime.wantToEnterParkingALotAt(momentum)) {
				verifyIfCanParkTheInfoOfNewVehicle(parkingTime);
			}
		}
	}

	private void verifyIfCanParkTheInfoOfNewVehicle(ParkingTime parkingTime) 
			throws ThereIsNoSpaceLeftInTheParkingALotException
	{
		boolean isTheParkingALotFullOfVehicles = vacancies.size() == maxNumberOfCars;
		
		if(isTheParkingALotFullOfVehicles) {
			throw new ThereIsNoSpaceLeftInTheParkingALotException(parkingTime);
		} else {
			vacancies.push(parkingTime);
		}
	}
	
	private void validateIfCanLeaveInThisMomemtum(int momentum) throws AnAlreadyParkedVehicleWantsToLeaveFirstException
	{
		int lastParkingInfo = allParkingInfoAvailable.size() - 1;
		
		for(int i=lastParkingInfo; i>=0; i--) {
			ParkingTime reversedParkingTime = allParkingInfoAvailable.get(i);
			
			if(reversedParkingTime.wantToLeaveParkingALotAt(momentum)) {
				verifyIfParkedTimeCanLeave(reversedParkingTime);
			}
		}
	}

	private void verifyIfParkedTimeCanLeave(ParkingTime reversedParkingTime) throws AnAlreadyParkedVehicleWantsToLeaveFirstException
	{
		boolean theLastCarIsTheSameThatWantsToLeave = vacancies.peek().equals(reversedParkingTime);
		
		if(theLastCarIsTheSameThatWantsToLeave) {
			vacancies.pop();
		} else {
			throw new AnAlreadyParkedVehicleWantsToLeaveFirstException();
		}
	}
	
	private int getMaxMomentumOfParkingInfo()
	{
		int maxMomemtum = 1;
		
		for (ParkingTime parkingTime : allParkingInfoAvailable)
		{
			if(parkingTime.parkingFinishedAt() > maxMomemtum) {
				maxMomemtum = parkingTime.parkingFinishedAt();
			}
		}
		
		return maxMomemtum;
	}

	
}
