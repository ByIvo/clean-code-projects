package parkinglot;


public class ParkingTime
{
	private final int parkingStartsAt;
	private final int parkingFinishesAt;
	
	private ParkingTime(int parkingStartsAt, int parkingFinishesAt)
	{
		this.parkingStartsAt = parkingStartsAt;
		this.parkingFinishesAt = parkingFinishesAt;
	}

	public static ParkingTime vehicleParkedBetween(int parkingStartsAt, int parkingFinishesAt)
	{
		return new ParkingTime(parkingStartsAt, parkingFinishesAt);
	}

	public int parkingStartedAt()
	{
		return parkingStartsAt;
	}

	public int parkingFinishedAt()
	{
		return parkingFinishesAt;
	}
	
	public boolean wantToEnterParkingALotAt(int momentum) {
		return this.parkingStartsAt == momentum;
	}

	public boolean wantToLeaveParkingALotAt(int momentum)
	{
		return this.parkingFinishedAt() == momentum;
	}
	
}
