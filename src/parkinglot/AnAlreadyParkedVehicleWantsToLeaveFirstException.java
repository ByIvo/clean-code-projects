package parkinglot;


public class AnAlreadyParkedVehicleWantsToLeaveFirstException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	
	public AnAlreadyParkedVehicleWantsToLeaveFirstException()
	{
		super("An already parked vehicle wants to leave first than the new vehicle parking info");
	}
	
}
