import java.util.ArrayList;

public abstract class Flight {
	protected ArrayList<Passenger> passengers=new ArrayList<Passenger>();
	protected ArrayList<Ticket> tickets=new ArrayList<Ticket>();
//	Passenger passengers;
	protected String typeOfPlane;
	protected String origin;
	protected String destination;
	protected String date;
	protected String departure;
	protected String arrival;

	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(ArrayList<Passenger> passengers, ArrayList<Ticket> tickets, String typeOfPlane, String origin,
			String destination, String date, String departure, String arrival) {
		super();
		this.passengers = passengers;
		this.tickets = tickets;
		this.typeOfPlane = typeOfPlane;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.departure = departure;
		this.arrival = arrival;
	}
	public void addPassenger(Passenger user) {
		passengers.add(user);
	}


	public ArrayList<Ticket> getTickets() {
		return tickets;
	}




	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}




	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}

	public String getTypeOfPlane() {
		return typeOfPlane;
	}

	public void setTypeOfPlane(String typeOfPlane) {
		this.typeOfPlane = typeOfPlane;
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
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public abstract void display();
	public abstract void showAvailableSeats();
	public abstract void setPrice(double price);
	public abstract void setSeats(boolean[] seats);
	public abstract void bookSeat(int seat);
	public abstract boolean[] getSeats();
	public abstract double getPrice();
}
