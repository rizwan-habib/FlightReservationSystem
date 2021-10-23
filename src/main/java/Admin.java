import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Admin {
	private ArrayList<Flight> flights=new ArrayList<Flight>();
	private ArrayList<Passenger> passengers=new ArrayList<Passenger>();
// 	Passenger
 	public Admin() {
		// TODO Auto-generated constructor stub
	}
 	
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}


	public ArrayList<Flight> getFlights() {
		return flights;
	}


	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	public void signup() {
		Scanner myReader = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = myReader.nextLine();
		System.out.println("Enter your address: ");
		String address = myReader.nextLine();
		System.out.println("Enter your age: ");
		int age = myReader.nextInt();
		myReader.nextLine();
		System.out.println("Enter your passport number: ");
		String pNo = myReader.nextLine();
		System.out.println("Enter username to set: ");
		String username = myReader.nextLine();
		System.out.println("Enter password to set: ");
		String password = myReader.nextLine();
		Passenger p=new Passenger(name, address, age, pNo, username, password);
		try
		{
		    String filename= "passengers.csv";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n"+name+","+address+","+age+","+pNo+","+username+","+password);//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	public Passenger login() {
		try {
			File myObj = new File("passengers.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",");
	        	Passenger passenger=new Passenger();
		        passenger.setName(arrOfStr[0]);
		        passenger.setAddress(arrOfStr[1]);
		        passenger.setAge(Integer.parseInt(arrOfStr[2]));
		        passenger.setPassportNumber(arrOfStr[3]);
		        passenger.setUsername(arrOfStr[4]);
		        passenger.setPassword(arrOfStr[5]);
		        passengers.add(passenger);
			}
			myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		String username="",username1="",password="";
		Scanner myObj = new Scanner(System.in);
		boolean flag=false;
		Passenger p=new Passenger();
		do {
			System.out.print("Enter Username: ");
		    username = myObj.nextLine();
		    for (int i = 0; i < passengers.size(); i++) {
		    	if(username.equals(passengers.get(i).getUsername())) {
		    		flag=true;
		    		p=passengers.get(i);
		    	}	
			}
		} while (!flag);
		do {
			System.out.print("Enter Password: ");
		    password = myObj.nextLine();
		    
		} while (!password.equals(p.getPassword()));
		return p;
	}

	public void FlightReading() {
		try {
			File myObj = new File("flights.csv");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arrOfStr = data.split(",");
			    if(arrOfStr[6].equals("Business")) {
		        	Flight flight=new BusinessClass();
			        flight.setDate(arrOfStr[0]);
			        flight.setOrigin(arrOfStr[1]);
			        flight.setDeparture(arrOfStr[2]);
			        flight.setDestination(arrOfStr[3]);
			        flight.setArrival(arrOfStr[4]);
			        flight.setPrice(Double.parseDouble(arrOfStr[5]));
			        flight.setTypeOfPlane("Business");
			        boolean[] seats;
			        seats=new boolean[80];
			        for (int i = 0; i < seats.length; i++) {
						seats[i]=false;
					}
			        flight.setSeats(seats);
			        flights.add(flight);
			    }
			    else
			    {
			    	Flight flight=new EconomyClass();
			        flight.setDate(arrOfStr[0]);
			        flight.setOrigin(arrOfStr[1]);
			        flight.setDeparture(arrOfStr[2]);
			        flight.setDestination(arrOfStr[3]);
			        flight.setArrival(arrOfStr[4]);
			        flight.setPrice(Double.parseDouble(arrOfStr[5]));
			        flight.setTypeOfPlane("Economy");
			        boolean[] seats;
			        seats=new boolean[120];
			        for (int i = 0; i < seats.length; i++) {
						seats[i]=false;
					}
			        flight.setSeats(seats);
			        flights.add(flight);
			    }
			}
			myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	public void searchAndBook(Passenger user) {
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter Departure City: ");
		
	    String departure = myObj.nextLine();
		System.out.print("Enter Destination City: ");
		String destination = myObj.nextLine();
		ArrayList<Flight> direct_flights=new ArrayList<Flight>();
		ArrayList<Flight> indirect_flights1=new ArrayList<Flight>();
		ArrayList<Flight> indirect_flights2=new ArrayList<Flight>();
		boolean flag=false;
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getOrigin().equals(departure) && flights.get(i).getDestination().equals(destination)) {
				flag=true;
				System.out.println();
				System.out.println();
				System.out.println();
				flights.get(i).display();
				direct_flights.add(flights.get(i));
			}
			else if (flights.get(i).getOrigin().equals(departure)) {
				
				for (int j = 0; j < flights.size(); j++) {
//					System.out.print("matched"+flights.get(j).getDestination());
					if (flights.get(j).getDestination().equals(destination) && flights.get(j).getOrigin().equals(flights.get(i).getDestination())) {
//						System.out.print("matched"+flights.get(j).getDestination());
						flag=true;
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Indirect Flight:");
						System.out.println("Flight 1:");
						flights.get(i).display();
						System.out.println();
						System.out.println("Flight 2:");
						flights.get(j).display();
						indirect_flights1.add(flights.get(i));
						indirect_flights2.add(flights.get(j));
					
					}
				}
			}
			
		}
		if(!flag) {
			System.out.println("Flights not Found");
		}
		else if (direct_flights.size()>0) {
			Scanner myObj1 = new Scanner(System.in);
			int number=1;
			while(number!=0) {
				do {
					System.out.print("Select a flight from above direct to show the available seats or press 0 to go for booking: ");
					number=myObj1.nextInt();
					myObj1.nextLine();
				}while(number>direct_flights.size() || number<0);
				if(number!=0)
					direct_flights.get(number-1).showAvailableSeats();
			}
			number=1;
			do {
				System.out.print("Select a flight from above direct for booking: ");
				number=myObj1.nextInt();
				myObj1.nextLine();
			}while(number>direct_flights.size() || number<0);
			if(number!=0)
				directBooking(direct_flights.get(number-1),user);
		}
		else if (indirect_flights1.size()>0) {
			Scanner myObj1 = new Scanner(System.in);
			int number=1;
			while(number!=0) {
				do {
					System.out.print("Select a flight from above indirect to show the available seats or press 0 to go for booking: ");
					number=myObj1.nextInt();
					myObj1.nextLine();
				}while(number>indirect_flights1.size() || number<0);
				
				if(number!=0)
					indirect_flights1.get(number-1).showAvailableSeats();
			}
			number=1;
			do {
				System.out.print("Select a flight from above indirect for booking: ");
				number=myObj1.nextInt();
				myObj1.nextLine();
			}while(number>indirect_flights1.size() || number<0);
			if(number!=0)
				indirectBooking(indirect_flights1.get(number-1),indirect_flights2.get(number-1),user);
	
		}
	}
	private void directBooking(Flight f,Passenger user) {
		f.getPassengers().add(user);
		int num=0;
		Scanner myReader = new Scanner(System.in);
		
		do {
			System.out.print("Enter a available seat number for flight "+f.getOrigin()+" to "+f.getDestination()+": ");
			num = myReader.nextInt();
			myReader.nextLine();
			
		} while (f.getSeats()[num-1]);
		f.bookSeat(num-1);
		Ticket t=new Ticket(f.getOrigin(), f.getDestination(), f.getDate(),f.getTypeOfPlane() , num-1, user);
		f.getTickets().add(t);
//		try {
		  String str=f.getOrigin()+f.getDestination()+f.getDate()+".csv";
//		  fileName = fileName + ".txt";
//		  System.out.print(str);
		    File file = new File(str);
		    boolean isFileCreated;
			try {
				isFileCreated = file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // New change
//		    System.out.print("Was the file created? -- ");
//		    Syst11em.out.println(isFileCreated);
		try
		{
//		    String filename= f.getOrigin()+f.getDestination()+".csv";
		    FileWriter fw = new FileWriter(str,true); //the true will append the new data
		    if(file.length()!=0) {
		    	fw.write("\n"+f.getOrigin()+","+f.getDestination()+","+f.getDate()+","+f.getTypeOfPlane()+","+(num-1)+","+user.getName()+","+user.getPassportNumber()+","+user.getAddress());//appends the string to the file
		    }
		    else {
		    	fw.write(f.getOrigin()+","+f.getDestination()+","+f.getDate()+","+f.getTypeOfPlane()+","+num+","+user.getName()+","+user.getPassportNumber()+","+user.getAddress());//appends the string to the file
			    
		    }
		    	fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	private void indirectBooking(Flight f1,Flight f2,Passenger user) {
//		System.out.println("booking done");
//		f1.display();
//		f2.display();
		directBooking(f1, user);
		directBooking(f2, user);
	}

}
