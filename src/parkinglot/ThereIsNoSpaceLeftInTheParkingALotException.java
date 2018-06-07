package parkinglot;

import java.text.MessageFormat;

public class ThereIsNoSpaceLeftInTheParkingALotException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParkingTime parkingTime;
	
	public ThereIsNoSpaceLeftInTheParkingALotException(ParkingTime parkingTime)
	{
		this.parkingTime = parkingTime;
	}
	
	@Override
	public String getMessage()
	{
		String pattern = "There is no way to fit a new vehicle between {0} and {1}";
		
		int parkingStartedAt = parkingTime.parkingStartedAt();
		int parkingFinishedAt = parkingTime.parkingFinishedAt();
		
		return MessageFormat.format(pattern, parkingStartedAt, parkingFinishedAt);
	}
	
}
