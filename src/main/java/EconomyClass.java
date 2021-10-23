import java.util.ArrayList;

public class EconomyClass extends Flight {
	private double price;
	private boolean[] seats;
	public EconomyClass() {
		// TODO Auto-generated constructor stub
	}
	public EconomyClass(ArrayList<Passenger> passengers,ArrayList<Ticket> tickets, String typeOfPlane, String origin, String destination,
			String date, String departure, String arrival) {
		super(passengers, tickets, typeOfPlane, origin, destination, date, departure, arrival);
		// TODO Auto-generated constructor stub
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean[] getSeats() {
		return seats;
	}
	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Origin: "+getOrigin());
		System.out.println("Destination: "+getDestination());
		System.out.println("Date: "+getDate());
		System.out.println("Departure Time: "+getDeparture());
		System.out.println("Arrival: "+getArrival());
		System.out.println("Type: "+getTypeOfPlane());
		System.out.println("Fare: "+getPrice());
//		System.out.println("Seats: ");
//		System.out.println("Available: *    Not Available: X");
//		showAvailableSeats();

	}
	@Override
	public void showAvailableSeats() {
		// TODO Auto-generated method stub
		System.out.println("Available: *    Not Available: X");
		for (int i = 1; i < seats.length+1; i++) {
			if(seats[i-1])
			{
				System.out.print("X    ");
			}
			else {
				System.out.print(i+"    ");
			}
			if(i%5==0) {
				System.out.println();
			}
		}
	
	}
	public void bookSeat(int seat) {
		// TODO Auto-generated method stub
		if (seat>=0&&seat<seats.length) {
			seats[seat]=true;
		}
	}
	
}
