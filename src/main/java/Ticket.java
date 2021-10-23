public class Ticket {
	private String origin;
	private String destination;
	private String date;
	private String flightType;
	private int seatNo;
	private Passenger passenger;
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(String origin, String destination, String date, String flightType, int seatNo,
			Passenger passenger) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.flightType = flightType;
		this.seatNo = seatNo;
		this.passenger = passenger;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	
}
